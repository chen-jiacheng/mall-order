package com.dohhub.mall.order.common.enums;

/**
 * Created by chenjiacheng on 2025/5/4 23:18
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public enum BusinessCodeEnum {

    /**
     * 业务异常
     */
    BUSINESS_SUCCESS("200", "ok"),

    /**
     * 业务异常
     */
    BUSINESS_EXCEPTION("1000", "业务异常"),

    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION("2000", "系统异常"),

    /**
     * 参数异常
     */
    PARAMETER_EXCEPTION("3000", "参数异常"),

    /**
     * 其他异常
     */
    OTHER_EXCEPTION("4000", "其他异常"),
    /**
     * 订单不存在
     */
    ORDER_NOT_EXIST("5000", "订单不存在"),
    /**
     * 订单已支付
     */
    ORDER_PAID("5001", "订单已支付"),
    /**
     * 订单已取消
     */
    ORDER_CANCEL("5002", "订单已取消"),
    /**
     * 订单已完成
     */
    ORDER_COMPLETE("5003", "订单已完成"),
    /**
     * 订单已关闭
     */
    ORDER_CLOSE("5004", "订单已关闭"),
    /**
     * 订单已发货
     */
    ORDER_SHIPPED("5005", "订单已发货"),
    /**
     * 订单已退款
     */
    ORDER_REFUND("5006", "订单已退款"),
    /**
     * 订单已退货
     */
    ORDER_RETURN("5007", "订单已退货"),
    /**
     * 订单已换货
     */
    ORDER_EXCHANGE("5008", "订单已换货"),
    /**
     * 订单已评价
     */
    ORDER_EVALUATED("5009", "订单已评价"),
    /**
     * 订单已锁定
     */
    ORDER_LOCKED("5010", "订单已锁定"),
    /**
     * 订单已解锁
     */
    ORDER_UNLOCKED("5011", "订单已解锁"),
    /**
     * 订单已支付成功
     */
    ORDER_PAID_SUCCESS("5012", "订单已支付成功"),
    /**
     * 订单已支付失败
     */
    ORDER_PAID_FAIL("5013", "订单已支付失败"),
    /**
     * 订单已支付取消
     */
    ORDER_PAID_CANCEL("5014", "订单已支付取消"),
    /**
     * 订单已支付超时
     */
    ORDER_PAID_TIMEOUT("5015", "订单已支付超时"),
    /**
     * 订单已支付异常
     */
    ORDER_PAID_EXCEPTION("5016", "订单已支付异常"),
    /**
     * 订单已支付处理中
     */
    ORDER_PAID_PROCESSING("5016", "订单已支付异常"),

    ;

    private String code;
    private String msg;

    BusinessCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
