package org.sang.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by CJF on 2018-7-23.
 */
public class TransactionTest {
    @Autowired
    TransactionTemplate transactionTemplate;
    public static void main(String[] args) {

    }

    public void test(){

        transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                
                return null;
            }
        });
    }
}
