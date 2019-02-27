package org.sang.demo.impl;

import org.sang.demo.inter.CommonInter;

/**
 * Created by CJF on 2019/2/26.
 *
 */
public abstract class DecorateCommon implements CommonInter{
    CommonInter ci;
    public DecorateCommon(CommonInter inter){
        this.ci = inter;
    }

    @Override
    public void say(String name) {
        System.out.println("装饰者模式abstract1");
        ci.say(name);
        System.out.println("装饰者模式abstract2");
    }

    public static void main(String[] args) {
        CommonInter ci = new DecorateCommonBefore(new DecorateCommonAfter(new CommonImpl()));
        ci.say("ace");
    }
}
