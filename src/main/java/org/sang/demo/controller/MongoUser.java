package org.sang.demo.controller;

import lombok.Data;

import java.util.UUID;

/**
 * Created by CJF on 2019/4/18.
 */
@Data
public class MongoUser {
    private String _id;

    private String loginName;

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
    }
}
