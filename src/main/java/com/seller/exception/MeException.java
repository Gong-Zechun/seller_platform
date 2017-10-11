package com.seller.exception;


import com.seller.constants.ErrorCode;

/**
 * 类功能描述：买手平台异常类定义
 * @author Allen Gong
 * @version 1.0.0
 * @history 2017-03-31 Allen Gong 创建
 */
public class MeException extends RuntimeException{
    private static final long serialVersionUID = 6813372265586429505L;

    /**
     * message key
     */
    private Integer messageKey;

    /**
     * message args
     */
    private String message;

    /**
     * Constructor
     */
    public MeException(){
        super();
    }

    /**
     * Constructor
     * @param messageKey message key
     */
    public MeException(Integer messageKey){
        this.messageKey= messageKey;
        this.message = ErrorCode.ERROR_MSG_MAP.get(messageKey);
    }

    /**
     * Constructor
     * @param messageKey message key
     * @param messageArgs message args
     */
    public MeException(Integer messageKey,String message){
        this.messageKey= messageKey;
        this.message= message;
    }

    /**
     * Constructor
     * @param cause cause exception
     */
    public MeException(Throwable cause){
        super(cause);
    }

    /**
     * Constructor
     * @param cause cause exception
     * @param messageKey message Key
     */
    public MeException(Throwable cause,Integer messageKey){
        super(cause);
        this.messageKey= messageKey;
    }

    /**
     * Constructor
     * @param cause cause exception
     * @param messageKey message Key
     * @param messageArgs message args
     */
    public MeException(Throwable cause,Integer messageKey,String message){
        super(cause);
        this.messageKey= messageKey;
        this.message= message;
    }

    /**
     * @return the messageKey
     */
    public Integer getMessageKey(){
        return messageKey;
    }

    /**
     * @param messageKey the messageKey to set
     */
    public void setMessageKey(Integer messageKey){
        this.messageKey= messageKey;
    }

    /**
     * @return the messageArgs
     */
    public String getMessage(){
        return message;
    }

    /**
     * @param messageArgs the messageArgs to set
     */
    public void setMessage(String message){
        this.message= message;
    }
}
