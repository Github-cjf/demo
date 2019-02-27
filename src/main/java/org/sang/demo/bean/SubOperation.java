package org.sang.demo.bean;

import org.junit.Before;
import org.sang.demo.inter.Operation;

/**
 * Created by CJF on 2019/2/20.
 */
public class SubOperation extends Operation{
    private String NAME = "input";
    @Override
    public double getResult() {
        return this.getNum1() - this.getNum2();
    }
}
