package org.sang.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by CJF on 2018-5-2.
 */
@Component
public class beanInject {
    @Value("其他Bean的属性")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}

