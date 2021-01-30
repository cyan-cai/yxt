/**
 *
 */
package com.java.yxt.base;

/**
 * @author lfl
 * @Description 行短业务校验状态码定义
 * @date 2020年8月26日
 */
public enum IndustryMessageValidationEnum implements IStatusEnum {
    /** */
    INDUSTRY_MESSAGE_CONTENT_TOOLONG(60001, "短信内容长度超限，不允许超过70个字"),
    INDUSTRY_MESSAGE_NUMBER_TOOMANY(60002, "短信接收方号码数量超限，不允许超过100个"),
    INDUSTRY_MESSAGE_REQUEST_PARAM_NULL(60005, "校验失败,行短下发请求参数不能为空!"),
    INDUSTRY_MESSAGE_SRCTERM_ID_NULL(60006, "校验失败,行短短信息发送方号码不能为空!"),
    INDUSTRY_MESSAGE_DESTTERM_IDS_NULL(60007, "校验失败,行短短信息接受方号码不能为空!"),
    INDUSTRY_MESSAGE_DESTTERM_IDS_TOOMANY(60008, "校验失败,行短短信息接受方数量超限!"),
    INDUSTRY_MESSAGE_CONTENT_INFO_NULL(60009, "校验失败,行短消息内容不能为空!"),
    INDUSTRY_MESSAGE_NORMAL_CONTENT_TOOLONG(60010, "短信内容长度超限，普通短信不允许超过253个字节"),
    INDUSTRY_MESSAGE_LONG_CONTENT_TOOLONG(60011, "短信内容长度超限，长短信不允许超过140个字节"),
    INDUSTRY_MESSAGE_CONTENT_INFO_TOOMANY(60024, "校验失败,行短消息内容不能超过标准限制!"),
    INDUSTRY_MESSAGE_CONTENT_COMPLIANCE_ERROR(60025, "校验失败,行短消息内容敏感词校验失败!"),
    INDUSTRY_MESSAGE_DESTTERM_WHITE_IDS_NULL(60012, "校验失败,经黑名单主被叫校验接收端没有符合条件的终端号码!"),
    INDUSTRY_MESSAGE_CONTENT_BYTE_TURN_NULL(60013, "行短内容字节转换后为空!"),
    INDUSTRY_MESSAGE_CONTENT_BYTE_TURN_ERROR(60014, "行短内容字节转换异常!"),
    INDUSTRY_MESSAGE_REQUEST_RECORD_INSERT_ERROR(60015, "创建SP用户请求记录入库失败!"),
    INDUSTRY_MESSAGE_REQUEST_RECORD_INSERT_EXCEPTION(60016, "创建SP用户请求记录入库异常!"),
    INDUSTRY_MESSAGE_LONG_CONTENT_SPLIT_LIST_NULL(60017, "长短信拆分,获取的短信集合不能为空!"),
    INDUSTRY_MESSAGE_LONG_CONTENT_SPLIT_LIST_EXCEPTION(60018, "长短信拆分,发生异常!"),
    INDUSTRY_MESSAGE_LONG_CONTENT_GET_REFERENCENUM_EXCEPTION(60019, "长短信获取参考号,发生异常!"),
    INDUSTRY_MESSAGE_SEND_DETAIL_RECORD_INSERT_EXCEPTION(60020, "行短发送记录以及明细记录入库发生异常!"),
    INDUSTRY_MESSAGE_CUSTOMER_CODE_NULL(60021, "校验失败,行短短信息发送客户标识不能为空!"),
    INDUSTRY_MESSAGE_BLACK_LIST_STATUS_ERROR(60022, "校验失败,行短黑名单主被叫状态校验失败!"),
    INDUSTRY_MESSAGE_BLACK_LIST_EXCEPTION(60023, "校验失败,行短黑名单主被叫校验fegin调用异常!"),

    INDUSTRY_MESSAGE_ADD_SIGNATURE_ISNULL(60024, "新增失败,添加对象为空"),
    INDUSTRY_MESSAGE_ADD_SIGNATURE_CONTENT_ISNULL(60025, "新增失败,企业签名内容为空"),
    INDUSTRY_MESSAGE_ADD_SIGNATURE_CONTENT_TOOLONG(60026, "校验失败,企业签名长度超长"),
    INDUSTRY_MESSAGE_ADD_SIGNATURE_CUSTOMERID_ISEXIST(60027, "新增失败,已经存在该企业的企业签名"),

    INDUSTRY_MESSAGE_REC_PARAM_NULL(60035, "校验失败,行短上报请求参数不能为空!"),
    INDUSTRY_MESSAGE_REC_SRCTERM_ID_NULL(60036, "校验失败,行短上报短信息发送方号码不能为空!"),
    INDUSTRY_MESSAGE_REC_DESTTERM_IDS_NULL(60037, "校验失败,行短上报短信息接受方号码不能为空!"),
    INDUSTRY_MESSAGE_REC_CONTENT_INFO_NULL(60038, "校验失败,行短上报消息内容不能为空!"),
    INDUSTRY_MESSAGE_REC_DESTTERM_WHITE_IDS_NULL(60039, "校验失败,经黑名单主被叫校验接收端没有符合条件的终端号码!"),
    INDUSTRY_MESSAGE_REC_CUSTOMER_CODE_NULL(60040, "校验失败,行短上报请求参数客户标识不能为空!"),
    INDUSTRY_MESSAGE_REC_CATEGORY_NULL(60041, "校验失败,行短上报短信类型不能为空!"),
    INDUSTRY_MESSAGE_REC_RESPONSE_RECORD_INSERT_EXCEPTION(60042, "创建行短上报请求记录入库异常!"),
    INDUSTRY_MESSAGE_REC_CATEGORY_ERROR(60043, "校验失败,行短上报短信类型无效!"),
    INDUSTRY_MESSAGE_REC_LONGMSG_PARAM_ERROR(60044, "校验失败,行短为长短信时合并参数不能为空!"),
    INDUSTRY_MESSAGE_REC_LONGMSG_INSERT_EXCEPTION(60045, "校验失败,行短上行长短信入库发生异常!"),
    INDUSTRY_MESSAGE_REC_LONGMSG_NOT_REACH_REPORT_NUM(60046, "行短上行长短信入库成功,但尚未达到合并标准,暂不发送!"),
    INDUSTRY_MESSAGE_REC_LONGMSG_INSERT_ERROR(60047, "行短上报长短信入库失败!"),
    INDUSTRY_MESSAGE_REC_LONGMSG_MERGE_INSERT_ERROR(60048, "行短上行合并拆分后的长短信后入库失败!"),
    INDUSTRY_MESSAGE_REC_MESSAGE_REPORT_URL_NULL(60049, "行短上报获取到客户的url为空!"),
    INDUSTRY_MESSAGE_REC_LONGMSG_MERGED_INSERT_EXCEPTION(60050, "行短上行合并后的长短信入库发生异常!"),
    INDUSTRY_MESSAGE_CUSTOMER_CALLBLACKURL_NULL(60051, "行短上行获取客户回调地址为空!"),
    INDUSTRY_MESSAGE_CUSTOMER_CALLBLACKURL_EXCEPTION(60052, "行短上行获取客户回调地址fegin调用异常!");

    public int code;
    public String message;

    private IndustryMessageValidationEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
