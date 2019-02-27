package org.sang.demo.bean;

import org.sang.demo.inter.Operation;

/**
 * Created by CJF on 2019/2/20.
 */
public class AddOperation extends Operation{
    @Override
    public double getResult() {
        return this.getNum1() + this.getNum2();
    }
}
