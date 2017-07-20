package com.ganpai.controller;

import com.ganpai.VO.ProvincesVO;
import com.ganpai.VO.CitiesVO;
import com.ganpai.VO.AreasVO;
import com.ganpai.cache.RegionCache;
import com.ganpai.common.PaginationData;
import com.ganpai.common.ResponseResult;
import com.ganpai.dto.ProvincesDTO;
import com.ganpai.dto.CitiesDTO;
import com.ganpai.dto.AreasDTO;
import com.ganpai.redis.RedisClient;
import com.ganpai.service.AreasService;
import com.ganpai.service.CitiesService;
import com.ganpai.service.ProvincesService;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@Controller
@RequestMapping("/region")
public class RegionController {


    final BeanCopier inCopier = BeanCopier.create(ProvincesVO.class, ProvincesDTO.class, false);

    final BeanCopier outCopier = BeanCopier.create(ProvincesDTO.class, ProvincesVO.class, false);

    private ProvincesDTO convert(ProvincesVO vo) {
        ProvincesDTO result = new ProvincesDTO();
        inCopier.copy(vo, result, null);
        return result;
    }

    private ProvincesVO convert(ProvincesDTO dto) {
        ProvincesVO result = new ProvincesVO();
        outCopier.copy(dto, result, null);
        return result;
    }

    private List<ProvincesVO> convertProvince(List<ProvincesDTO> doList) {
        List<ProvincesVO> result = new ArrayList<>();
        if (doList != null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }

    final BeanCopier inCopierCity = BeanCopier.create(CitiesVO.class, CitiesDTO.class, false);

    final BeanCopier outCopierCity = BeanCopier.create(CitiesDTO.class, CitiesVO.class, false);

    private CitiesDTO convert(CitiesVO vo) {
        CitiesDTO result = new CitiesDTO();
        inCopierCity.copy(vo, result, null);
        return result;
    }

    private CitiesVO convert(CitiesDTO dto) {
        CitiesVO result = new CitiesVO();
        outCopierCity.copy(dto, result, null);
        return result;
    }

    private List<CitiesVO> convertCity(List<CitiesDTO> doList) {
        List<CitiesVO> result = new ArrayList<>();
        if (doList != null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }


    final BeanCopier inCopierArea = BeanCopier.create(AreasVO.class, AreasDTO.class, false);

    final BeanCopier outCopierArea = BeanCopier.create(AreasDTO.class, AreasVO.class, false);

    private AreasDTO convert(AreasVO vo) {
        AreasDTO result = new AreasDTO();
        inCopierArea.copy(vo, result, null);
        return result;
    }

    private AreasVO convert(AreasDTO dto) {
        AreasVO result = new AreasVO();
        outCopierArea.copy(dto, result, null);
        return result;
    }

    private List<AreasVO> convertArea(List<AreasDTO> doList) {
        List<AreasVO> result = new ArrayList<>();
        if (doList != null && !doList.isEmpty()) {
            doList.forEach(e -> result.add(convert(e)));
        }
        return result;
    }

    @Autowired
    private ProvincesService provincesService;
    @Autowired
    private CitiesService citiesService;
    @Autowired
    private AreasService areasService;

    @RequestMapping("/provinces")
    @ResponseBody
    public ResponseResult<ProvincesVO> provinces() throws Exception{
        try{
            //获取省市县
            //获取省
            getProvincesAndPutToCache();

            //获取市
            getCitiesAndPutToCache();

            //获取县
            getAreasAndPutToCache();

            List<ProvincesVO> provincesVOList = (List<ProvincesVO>)RegionCache.getSingleTon().get(RegionCache.PROVINCE);
            return ResponseResult.success(provincesVOList);
        }catch (Exception e){
            return ResponseResult.failed(e.getMessage());
        }
    }

    @RequestMapping("/cities")
    @ResponseBody
    public ResponseResult<CitiesVO> cities(@RequestParam Long provinceId) throws Exception{
        try{
            Object cityObject = getCitiesAndPutToCache();
            List<CitiesVO> citiesVOList = (List<CitiesVO>)cityObject;

            List<CitiesVO> returnCitiesVOList = new ArrayList<>();
            for (CitiesVO citiesVO:citiesVOList
                    ) {
                if(provinceId.intValue() == citiesVO.getProvinceId().intValue()){
                    returnCitiesVOList.add(citiesVO);
                }
            }
            return ResponseResult.success(returnCitiesVOList);
        }catch (Exception e){
            return ResponseResult.failed(e.getMessage());
        }

    }

    @RequestMapping("/areas")
    @ResponseBody
    public ResponseResult<AreasVO> areas(@RequestParam Long cityId) throws Exception{
        try{
            Object areaObject = getAreasAndPutToCache();
            List<AreasVO> areasVOList = (List<AreasVO>)areaObject;

            List<AreasVO> returnAreasVOList = new ArrayList<>();
            for (AreasVO areasVO:areasVOList
                    ) {
                if(cityId.intValue() == areasVO.getCityId().intValue()){
                    returnAreasVOList.add(areasVO);
                }
            }
            return ResponseResult.success(returnAreasVOList);
        }catch (Exception e){
            return ResponseResult.failed(e.getMessage());
        }

    }

    public Object getProvincesAndPutToCache() {
        Object provinceObject = RegionCache.getSingleTon().get(RegionCache.PROVINCE);
        if(null == provinceObject){
            ProvincesDTO provincesDTO = new ProvincesDTO();
            PaginationData<ProvincesDTO> paginationData = provincesService.list(provincesDTO,1,1000);
            List<ProvincesDTO> provincesDTOList = paginationData.getRows();
            RegionCache.getSingleTon().put(RegionCache.PROVINCE,convertProvince(provincesDTOList));
        }
        return RegionCache.getSingleTon().get(RegionCache.PROVINCE);
    }

    public Object getCitiesAndPutToCache() {
        Object cityObject = RegionCache.getSingleTon().get(RegionCache.CITY);
        if(null == cityObject){
            CitiesDTO citiesDTO = new CitiesDTO();
            PaginationData<CitiesDTO> paginationData = citiesService.list(citiesDTO,1,1000);
            List<CitiesDTO> citiesDTOList = paginationData.getRows();
            RegionCache.getSingleTon().put(RegionCache.CITY,convertCity(citiesDTOList));
        }
        return RegionCache.getSingleTon().get(RegionCache.CITY);
    }

    public Object getAreasAndPutToCache() {
        Object areaObject = RegionCache.getSingleTon().get(RegionCache.AREA);
        if(null == areaObject){
            AreasDTO areasDTO = new AreasDTO();
            PaginationData<AreasDTO> paginationData = areasService.list(areasDTO,1,1000);
            List<AreasDTO> areasDTOList = paginationData.getRows();
            RegionCache.getSingleTon().put(RegionCache.AREA,convertArea(areasDTOList));
        }
        return RegionCache.getSingleTon().get(RegionCache.AREA);
    }
}
