package com.ganpai.enmu;

/**
 * Created by zhaoxl on 21/04/2017.
 */
public enum SexyEnum {

    MAN((byte)0,"男"),
    WOMEN((byte)1,"女");

    private final Byte code;
    private final String description;

    SexyEnum(Byte code, String description) {
        this.code = code;
        this.description = description;
    }

    public Byte getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
