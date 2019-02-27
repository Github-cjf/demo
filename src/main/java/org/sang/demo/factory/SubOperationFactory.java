package org.sang.demo.factory;

import org.sang.demo.bean.SubOperation;
import org.sang.demo.inter.Operation;
import org.sang.demo.inter.OperationInter;

/**
 * Created by CJF on 2019/2/20.
 */
public class SubOperationFactory implements OperationInter {
    @Override
    public Operation getOperation() {
        return new SubOperation();
    }
}
