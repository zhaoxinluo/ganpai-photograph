package com.ganpai.enmu;

/**
 * Created by zhaoxl on 21/04/2017.
 */
public enum AcceptEnum {

    NO_ACCEPT((byte)0,"未被接受"),
    ACCEPTED((byte)1,"已被接受");

    private final Byte code;
    private final String description;

    AcceptEnum(Byte code, String description) {
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
