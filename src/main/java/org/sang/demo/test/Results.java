package org.sang.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by CJF on 2019/3/13.
 */
@Component
public class Results {
    @Autowired
    public List<TestAutowired.Ranks> ranks;
}
