package org.sang.demo.controller;

import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Type;

/**
 * Created by CJF on 2019/4/10.
 */
public class CustomTypeReference extends TypeReference<String> {
    {
        Type superClass = this.getClass().getGenericSuperclass();
        System.out.println(superClass);
    }

    public static void main(String[] args) {
        new CustomTypeReference();
    }
}
