package com.demo.common.exception;

/**
 * 返回给用户端的状态码
 * Created by LiZhi on 2019/3/13.
 */
public enum ResponseStatusEm {
    /** 成功，默认 */
    SUCCESS("00"),
    /** 参数错误 */
    PARAM_ERR("01"),
    /** 账户id错误 */
    ACCOUNT_ERR("03"),
    /** 服务层异常 */
    SERVICE_ERR("11"),
    /** 服务层异常-不需要堆栈 */
    SERVICE_ERR_NO_STACK_TRACE("12"),
    /** 暂无售票 */
    TICKET_ERR("13"),
    /** 优惠券异常 */
    COUPON_ERR("14"),
    /** 客户端异常 */
    CLIENT_ERR("98"),
    /** 未知异常 */
    UNKNOWN_ERR("99");

    public String status;

    ResponseStatusEm(String status) {
        this.status = status;
    }
}
