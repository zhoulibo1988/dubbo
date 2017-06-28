package org.ivan.entity.utils;

public enum ParameterEunm {
    /**
     * 返回请求标识ErrorCode
     */
    RESULT_DATA_STATUS_KEY("返回标识", "resultCode"),
    /**
     * 返回的内容标识Data
     */
    RESULT_DATA_CONTENT_KEY("内容标识", "Data"),
    /**
     * 返回的错误描述ErrorMessage
     */
    RESULT_DATA_MESSAGE_KEY("返回的错误描述", "message"),
    /**
     * 返回的用户sessionId:userCertificate
     */
    SESSION_ID_PARA_NAME("用户sessionId标识", "userCertificate"),
    /**
     * 成功编号
     */
    SUCCESSFUL_CODE("成功", 200),
    /**
     * 失败
     */
    FAILED_CODE("失败", 201),
    /**
     * 内部错误403
     */
    ERROR_403_CODE("403错误,请求资源不可用", 403),
    /**
     * 内部错误404
     */
    ERROR_404_CODE("404错误,链接无效", 404),
    /**
     * 内部错误500
     */
    ERROR_500_CODE("500错误,请求资源报错", 500),
    /**
     * 内部未知错误
     */
    ERROR_UNKNOWN_CODE("未知错误", 9999),
    /**
     * 用户未登录
     */
    ERROR_LOGIN_CODE("用户未登录", 2000),

    /**
     * @Fields ERROR_MUTEX_EXIT : 用户当前登录的账号在其他设备登陆
     */
    ERROR_MUTEX_EXIT("用户账号在其他设备登陆",2100),
    
    /**
     * 参数错误
     */
    ERROR_PARAMS_CODE("参数有误", 2001),
    /**
     * 上传失败
     */
    ERROR_UPLOADFILE_CODE("上传失败", 2002),

    /**
     * 用户无权限
     */
    ERROR_NO_POWER("用户无权限", 2003),;

    private Object parameterName;

    private Object backParameter;

    private ParameterEunm(Object parameterName, Object backParameter) {
        this.parameterName = parameterName;
        this.backParameter = backParameter;
    }

    public Object getParameterName() {
        return parameterName;
    }

    public void setParameterName(Object parameterName) {
        this.parameterName = parameterName;
    }

    public Object getBackParameter() {
        return backParameter;
    }

    public void setBackParameter(Object backParameter) {
        this.backParameter = backParameter;
    }


}
