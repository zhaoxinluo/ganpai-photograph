package com.ganpai.controller;

import com.ganpai.common.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 拦截器错误信息 返回处理controller
 *
 * Created by Administrator on 2017/7/13 0013.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/userLogin")
    @ResponseBody
    public ResponseResult<String> userLogin() throws Exception{

        return ResponseResult.failed(ResponseResult.ResponseCode.TO_LOGIN_FAILED.getCode(),ResponseResult.ResponseCode.TO_LOGIN_FAILED.getMessage());
    }

    @RequestMapping("/homePage")
    @ResponseBody
    public ResponseResult<String> homePage() {
        return ResponseResult.failed(ResponseResult.ResponseCode.TO_HOME_PAGE_FAILED.getCode(),ResponseResult.ResponseCode.TO_HOME_PAGE_FAILED.getMessage());
    }


}