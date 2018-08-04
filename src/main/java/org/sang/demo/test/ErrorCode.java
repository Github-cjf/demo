package org.sang.demo.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CJF on 2018-7-23.
 */
public enum ErrorCode {
    nullCode("1", "值为空"),
    sizeCode("2", "数组越界"),

    unknown("-1", "未知错误");

    private String code;
    private String msg;

    ErrorCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private static Map<String, String> map = new HashMap<>();
    static {
        for(ErrorCode code : ErrorCode.values()){
            map.put(code.getCode(), code.getMsg());
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorCode getErrorByName(String msg){
        for(ErrorCode code : ErrorCode.values()){
            if(code.getMsg().equals(msg)){
                return code;
            }
        }
        return unknown;
    }

    public static void main(String[] args) {
        System.out.println(map);
    }
}
