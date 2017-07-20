package com.ganpai.enmu;

/**
 * Created by luyunfei on 21/04/2017.
 */
public enum DelEnum {

    UNDEFINED((byte) -1,"未知"),
    NO_DEL((byte) 0,"未删除"),
    DEL((byte) 1,"已删除");

    private final byte code;
    private final String description;

    DelEnum(byte code, String description) {
        this.code = code;
        this.description = description;
    }

    public byte getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static DelEnum getDelEnum(Byte code){
        if(code!=null){
            for(DelEnum it : DelEnum.values()){
                if(it.getCode() == code.byteValue()){
                    return it;
                }
            }
        }
        return DelEnum.UNDEFINED;
    }
}
