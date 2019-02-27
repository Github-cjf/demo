package org.sang.demo.impl;

import org.sang.demo.bean.Customer;
import org.sang.demo.inter.IbuildCustomer;

/**
 * Created by CJF on 2019/2/25.
 * 建造者模式builder
 */
public class VIPCUstomerBuild implements IbuildCustomer {
    @Override
    public void buildId() {
        customer.setId(5l);
    }

    @Override
    public void buildFirstName() {
        customer.setFirstName("Tom");
    }

    @Override
    public void buildLastName() {
        customer.setLastName("Cat");
    }

    @Override
    public Customer createCustomer() {
        return customer;
    }

}
