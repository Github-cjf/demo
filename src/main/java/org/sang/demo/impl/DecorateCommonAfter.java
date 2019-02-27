package org.sang.demo.impl;

import org.sang.demo.inter.CommonInter;

/**
 * Created by CJF on 2019/2/27.
 */
public class DecorateCommonAfter extends DecorateCommon{
    public DecorateCommonAfter(CommonInter inter) {
        super(inter);
    }

    public void say(String name) {
        super.say(name);
        System.out.println("装饰者模式after");
    }
}
