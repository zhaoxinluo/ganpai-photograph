package com.ganpai.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.ganpai.VO.UserVO;
import com.ganpai.common.CommonParam;
import com.ganpai.common.PaginationData;
import com.ganpai.common.ResponseResult;
import com.ganpai.controller.base.BaseController;
import com.ganpai.dto.UserDTO;
import com.ganpai.redis.RedisClient;
import com.ganpai.service.UserService;
import com.ganpai.utils.*;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    private static String address = "http://www.baidu.com/id=%s";

    final BeanCopier inCopier = BeanCopier.create(UserVO.class, UserDTO.class, false);

    final BeanCopier outCopier = BeanCopier.create(UserDTO.class, UserVO.class, false);

    private UserDTO convert(UserVO vo) {
        UserDTO result = new UserDTO();
        inCopier.copy(vo, result, null);
        return result;
    }

    private UserVO convert(UserDTO dto) {
        UserVO result = new UserVO();
        outCopier.copy(dto, result, null);
        return result;
    }

    private List<UserVO> convert(List<UserDTO> doList) {
        List<UserVO> result = new ArrayList<>();
        if (doList != null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    @Autowired
    private RedisClient redisClient;

    @Autowired
    private UserService userService;

    @Autowired
    private SendMobile sendMobile;

    @Autowired
    private SendEmail sendEmail;

    @RequestMapping("/login")
    @ResponseBody
    public ResponseResult<String> login(@RequestParam String name, @RequestParam String password, HttpServletResponse response)throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);
        userDTO.setPassword(MD5Util.getMD5String(password));

        PaginationData<UserDTO> paginationData = userService.list(userDTO,1,1);
        List<UserDTO> userDTOList = paginationData.getRows();
        if(CollectionUtils.isEmpty(userDTOList)){
            return ResponseResult.failed("用户不存在");
        }
        UserDTO resultDTO = userDTOList.get(0);

        //cooke value
        String cookieValue = MD5Util.getMD5String(resultDTO.getId()+"");

        //redis value
        String redisValue = resultDTO.getLoginName() +","+ resultDTO.getUserName()+"," + resultDTO.getMobile();


        //设置cookie Response
        CookieUtil.addCookie(response, CommonParam.COOKIE_KEY,cookieValue,CommonParam.COOKIE_AGE);

        //存储到redis
        redisClient.setex(cookieValue,CommonParam.REDIS_AGE,redisValue);

        return ResponseResult.success(convert(userDTO));
    }

    @RequestMapping("/register")
    @ResponseBody
    public ResponseResult<String> register(UserVO userVO){
        try{
            String password = MD5Util.getMD5String(userVO.getPassword());
            UserDTO userDTO = convert(userVO);
            userDTO.setPassword(password);
            userService.create(userDTO);
            return ResponseResult.success(userDTO.getId());
        }catch (Exception e){
            return ResponseResult.failed(e.getMessage());
        }
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public ResponseResult<String> updatePassword(UserVO userVO){
        //校验原密码
        String oldPassword = MD5Util.getMD5String(userVO.getPassword());

        UserDTO userDTO = userService.queryByPrimaryKey(userVO.getId());
        if(null == userDTO){
            return ResponseResult.failed(ResponseResult.ResponseCode.TO_LOGIN_FAILED.getCode(),"用户不存在");
        }


        if(StringUtils.isNotBlank(oldPassword) && !StringUtils.equals(oldPassword,userDTO.getPassword())){
            return ResponseResult.failed(ResponseResult.ResponseCode.TO_LOGIN_FAILED.getCode(),"原密码错误");
        }

        //修改密码
        UserDTO updateUserDTO = new UserDTO();
        updateUserDTO.setId(userVO.getId());
        updateUserDTO.setPassword(MD5Util.getMD5String(userVO.getNewPassword()));
        try{
            userService.update(updateUserDTO);
            return ResponseResult.success("密码修改成功");
        }catch (Exception e){
            return ResponseResult.failed(ResponseResult.ResponseCode.TO_LOGIN_FAILED.getCode(),"密码修改失败");
        }
    }


    @RequestMapping("/checkLoginName")
    @ResponseBody
    public ResponseResult<String> checkLoginName(@RequestParam String loginName){
        UserDTO userDTO = new UserDTO();
        userDTO.setLoginName(loginName);
        PaginationData<UserDTO> paginationData = userService.list(userDTO,1,1);
        List<UserDTO> userDTOList = paginationData.getRows();
        if(CollectionUtils.isNotEmpty(userDTOList)){
            return ResponseResult.failed("用户名已经存在");
        }
        return ResponseResult.success();
    }

    @RequestMapping("/checkMobile")
    @ResponseBody
    public ResponseResult<String> checkMobile(@RequestParam String mobile){
        UserDTO userDTO = new UserDTO();
        userDTO.setMobile(mobile);
        PaginationData<UserDTO> paginationData = userService.list(userDTO,1,1);
        List<UserDTO> userDTOList = paginationData.getRows();
        if(CollectionUtils.isNotEmpty(userDTOList)){
            return ResponseResult.failed("手机号已被使用");
        }
        return ResponseResult.success();
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public ResponseResult<String> checkEmail(@RequestParam String email){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        PaginationData<UserDTO> paginationData = userService.list(userDTO,1,1);
        List<UserDTO> userDTOList = paginationData.getRows();
        if(CollectionUtils.isNotEmpty(userDTOList)){
            return ResponseResult.failed("邮箱已被注册");
        }
        return ResponseResult.success();
    }

    @RequestMapping("/loginOut")
    @ResponseBody
    public ResponseResult<String> loginOut(HttpServletRequest request,HttpServletResponse response){
        Cookie cookie = CookieUtil.getCookieByName(request,CommonParam.COOKIE_KEY);

        String cookieValue = cookie.getValue();

        cookie.setMaxAge(0);

        redisClient.expire(cookieValue,0);

        return ResponseResult.success("用户退出成功");
    }




    @RequestMapping("/lookingUser")
    @ResponseBody
    public ResponseResult<String> lookingUser(@RequestParam String name){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(name);

        PaginationData<UserDTO> paginationData = userService.list(userDTO,1,1);
        List<UserDTO> userDTOList = paginationData.getRows();
        if(CollectionUtils.isEmpty(userDTOList)){
            return ResponseResult.failed("用户不存在");
        }
        UserDTO resultDTO = userDTOList.get(0);

        /**
         *对应手机号码 找回密码
         */
        if(StringUtils.equals(resultDTO.getMobile(),name)){
            return ResponseResult.success(ResponseResult.ResponseCode.MOBILE.getCode(),ResponseResult.ResponseCode.MOBILE.getMessage(),convert(resultDTO));
        }
        if(StringUtils.equals(resultDTO.getEmail(),name)){
            return ResponseResult.success(ResponseResult.ResponseCode.EMAIL.getCode(),ResponseResult.ResponseCode.EMAIL.getMessage(),convert(resultDTO));
        }

        return ResponseResult.success(convert(resultDTO));

    }

    @RequestMapping("/sendMobile")
    @ResponseBody
    public ResponseResult<String> sendMobile(@RequestParam String mobile){
        try{

            //发送短信前  验证有效期内是否已经发送过
            String mobileCode = redisClient.get(mobile);
            if(StringUtils.isNotBlank(mobileCode)){
                return ResponseResult.failed("验证码,已发送,请查看手机");
            }

            String randomNum = MathUtil.getRandomSixNumber()+"";
            String result = sendMobile.sendMobile(mobile, randomNum);
            if(StringUtils.equals(result,"1")){

                //设置验证码到redis
                redisClient.setex(mobile,CommonParam.REDIS_AGE_10_MINUTE,randomNum);

                return ResponseResult.success(mobile);
            }
            return ResponseResult.failed("发送短信错误");
        }catch (Exception e){
            return ResponseResult.failed("发送短信错误");
        }
    }

    @RequestMapping("/validMobileCode")
    @ResponseBody
    public ResponseResult<String> validMobileCode(@RequestParam String mobileCode,@RequestParam String mobile){
        try{
            String redisMobileCode = redisClient.get(mobile);
            if(null == redisMobileCode){
                return ResponseResult.failed("验证码已失效,请重新发送");
            }
            if(!StringUtils.equals(redisMobileCode,mobile)){
                return ResponseResult.failed("验证码错误,请重新输入");
            }
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.failed(e.getMessage());
        }

    }


    @RequestMapping("/sendEmail")
    @ResponseBody
    public ResponseResult<String> sendEmail(UserVO userVO){
        try{
            sendEmail.sendEmail(userVO.getEmail(),userVO.getLoginName(),String.format(address,userVO.getId()));
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.failed(e.getMessage());
        }
    }



}
