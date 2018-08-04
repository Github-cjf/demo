package org.sang.demo.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CJF on 2018-7-18.
 */
public enum ColorEnum {
    red(1, "red"),
    yellow(2, "yellow"),
    blue(3, "blue")
    ;

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ColorEnum(int code, String name) {
        this.code = code;
        this.name = name;

    }

    public static Map<Integer, String> getProp(){
        Map<Integer, String> m = new HashMap<>();
        for(ColorEnum color : ColorEnum.values()){
            m.put(color.getCode(), color.getName());
            System.out.println(color.getName());
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(ColorEnum.getProp());
    }
}
