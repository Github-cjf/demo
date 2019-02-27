package org.sang.demo.inter;

import lombok.Data;

/**
 * Created by CJF on 2019/2/20.
 */
@Data
public abstract class Operation {
    private double num1;
    private double num2;

    public abstract double getResult();
}
