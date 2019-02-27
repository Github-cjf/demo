package org.sang.demo.inter;

import org.sang.demo.bean.Customer;

/**
 * Created by CJF on 2019/2/25.
 */
public interface IbuildCustomer {
    Customer customer = new Customer();
    void buildId();
    void buildFirstName();
    void buildLastName();
    Customer createCustomer();
}
