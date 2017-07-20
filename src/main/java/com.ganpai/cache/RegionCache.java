package com.ganpai.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
public class RegionCache extends HashMap<String,Object> {
    /**
     * 相关key
     */
    public static final String PROVINCE = "province";
    public static final String CITY = "city";
    public static final String AREA = "area";


    private void RegionCache(){}

    private static class RegionCacheSingleTon{
         private static final RegionCache regionCache = new RegionCache();
    }

    public static RegionCache getSingleTon(){
        return RegionCacheSingleTon.regionCache;
    }
}
