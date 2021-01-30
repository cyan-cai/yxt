package com.java.yxt.base;

/**
 * 服务类型枚举类
 * @author zanglei
 */
public enum ApiCategoryEnum {

    FINE_POSITION("1","精定位"),
    ROUGH_POSITION("2","粗定位"),
    IOT_SHORTDATA("3","物联网短数据"),
    IOT_INDUSTRY_SMS("4","物联网行业短信"),
    SHORTMESSAGE_BROADCAST("5","短报文广播")
    ;
    /**
     * 服务类型编码
     */
    private String code;
    /**
     * 服务类型描述
     */
    private String desc;

   private ApiCategoryEnum(String code,String desc){
       this.code = code;
       this.desc = desc;
   }

    public String getCode() {
      return code;
    }

    public String getDesc() {
        return desc;
    }

}
