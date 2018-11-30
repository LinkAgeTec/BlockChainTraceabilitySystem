package com.mmall.exception;

/**
* @Description:    java类作用描述
* @Author:         ACtangle
* @CreateDate:     2018/11/29 15:10
* @UpdateUser:     ACtangle
* @UpdateDate:     2018/11/29 15:10
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ParamException extends RuntimeException{
    public ParamException() {
        super();
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    protected ParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
