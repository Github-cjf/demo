package org.sang.demo.test;

/**
 * Created by CJF on 2018-7-19.
 */
public class MyException extends RuntimeException{
    Throwable t;
    ErrorCode error;
    String remark;

    public MyException(){
        super();
    }

    public MyException(String remark){
        super(remark);
    }

    public MyException(ErrorCode error, String remark){
        this.error = error;
        this.remark = remark;
    }

    public MyException(Throwable t, String remark){
        this.t = t;
        this.remark = remark;
    }

    public MyException(Throwable t, ErrorCode error, String remark){
        this.t = t;
        this.error = error;
        this.remark = remark;
    }
}
