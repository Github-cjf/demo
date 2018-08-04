package org.sang.demo;

import org.springframework.boot.jackson.JsonObjectSerializer;

import java.util.Map;

/**
 * Created by CJF on 2018-7-23.
 */
public class jsonchange {
    public static void main(String[] args) {
        Map<String, Object> map = JsonUtil.objToMap("[{id:12,name:44}]");

        System.out.println(map);

    }
}
