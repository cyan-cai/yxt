package com.java.yxt.base;

/**
 * 服务类型枚举类
 *
 * @author zanglei
 */
public enum ApiComplianceEnum {

    POSITION(1, "天通位置服务"),
    SHORT_DATA(2, "天通物联网短数据服务"),
    INDUSTRY_MESSAGE(3, "天通物联网行短服务"),
    SHORTMESSAGE_BROADCAST(4, "短报文广播");
    /**
     * 服务类型编码
     */
    private int code;
    /**
     * 服务类型描述
     */
    private String desc;

    private ApiComplianceEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
