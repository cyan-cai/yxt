package com.java.yxt.base;

/**
 * 网关类型枚举类
 * @author zanglei
 */
public enum ApiGatewayEnum {

    FINE_POSITION("1","精定位"),
    ROUGH_POSITION("2","粗定位"),
    NORMAL_SHORTDATA("3","普通短数据")
    ;
    /**
     * 服务类型编码
     */
    private String code;
    /**
     * 服务类型描述
     */
    private String desc;

   private ApiGatewayEnum(String code, String desc){
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
