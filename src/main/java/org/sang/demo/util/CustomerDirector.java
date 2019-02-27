package org.sang.demo.util;

import org.sang.demo.bean.Customer;
import org.sang.demo.impl.VIPCUstomerBuild;
import org.sang.demo.inter.IbuildCustomer;

/**
 * Created by CJF on 2019/2/25.
 */
public class CustomerDirector {
    public static Customer setCustomer(IbuildCustomer c){
        c.buildId();
        c.buildFirstName();
        c.buildLastName();
        return c.createCustomer();
    }

    public static void main(String[] args) {
        Customer c = CustomerDirector.setCustomer(new VIPCUstomerBuild());
        System.out.println(c.toString());
    }
}
