package org.sang.demo;

/**
 * Created by CJF on 2018-8-24.
 */
public enum SexEnum {
    male("1", "男"),
    female("2", "女"),
    unknown("-1","未知")
    ;

    private String code;

    private String value;

    SexEnum(String code, String value){
        this.code = code;
        this.value = value;
    }

//    @JsonValue
    public String getCode(){
        return code;
    }

//    @JsonCreator
    public static SexEnum valueOfCode(String code){
        for(SexEnum sex : SexEnum.values()){
            if(sex.getCode().equals(code)){
                return sex;
            }
        }
        return null;
    }
}
