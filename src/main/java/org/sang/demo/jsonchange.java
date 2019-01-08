package org.sang.demo;

import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by CJF on 2018-7-23.
 */
public class jsonchange {
    public static void main(String[] args) {
        Map<String, Object> map = JsonUtil.objToMap("[{id:12,name:44}]");

        System.out.println(map);

    }


    public void say(){
        System.out.println("say:123");
    }
}
