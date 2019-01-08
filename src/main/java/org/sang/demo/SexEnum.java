package org.sang.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by CJF on 2018-8-24.
 */
public enum SexEnum {
    male("男"),
    female("女"),
    unknown("未知")
    ;

    private String code;

    SexEnum(String code){
        this.code = code;
    }

    @JsonValue
    public String getCode(){
        return code;
    }

    @JsonCreator
    public static SexEnum valueOfCode(String code){
        for(SexEnum sex : SexEnum.values()){
            if(sex.getCode().equals(code)){
                return sex;
            }
        }
        return null;
    }
}
