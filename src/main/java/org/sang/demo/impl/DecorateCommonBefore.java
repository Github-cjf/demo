package org.sang.demo.impl;

import org.sang.demo.inter.CommonInter;

/**
 * Created by CJF on 2019/2/27.
 */
public class DecorateCommonBefore extends DecorateCommon{
    public DecorateCommonBefore(CommonInter inter) {
        super(inter);
    }

    public void say(String name) {
        System.out.println("装饰者模式before");
        super.say(name);
    }
}
