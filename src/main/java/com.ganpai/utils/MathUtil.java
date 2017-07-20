package com.ganpai.utils;

/**
 * Created by Administrator on 2017/7/15 0015.
 */
public class MathUtil {
    /**
     * 6位随机数
     * @return
     */
    public static int getRandomSixNumber(){
        return (int)((Math.random()*9+1)*100000);
    }
}
