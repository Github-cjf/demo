package org.sang.demo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by CJF on 2018-5-2.
 */
@Component
@PropertySource({"classpath:test.properties"})
public class BaseValueInject {
    @Value("normal")
    private String normal; // 注入普通字符串

    @Value("${testname.str}")
    private String systemPropertiesName; // 注入操作系统属性

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber; //注入表达式结果

    @Value("#{beanInject.another}")
    private String fromAnotherBean; // 注入其他Bean属性：注入beanInject对象的属性another，类具体定义见下面

    @Override
    public String toString() {
        return "BaseValueInject{" +
                "normal='" + normal + '\'' +
                ", systemPropertiesName='" + systemPropertiesName + '\'' +
                ", randomNumber=" + randomNumber +
                ", fromAnotherBean='" + fromAnotherBean + '\'' +
                '}';
    }
/*    @Value("http://www.baidu.com")
    private Resource testUrl; // 注入URL资源*/
}
