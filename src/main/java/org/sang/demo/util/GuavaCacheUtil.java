package org.sang.demo.util;

import com.google.common.cache.Cache;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * Created by CJF on 2019/3/28.
 */
public class GuavaCacheUtil {
    private static Cache<String, Object> cache;

    public static void main(String[] args) {

        Student s = new Student();
        System.out.println(StringUtils.isEmpty(s.getBytes()));
    }


    @Data
    public static class Student {
        String name;
        byte[] bytes;
    }
}
