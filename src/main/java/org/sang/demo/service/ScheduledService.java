package org.sang.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.sang.demo.util.SpringUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by CJF on 2018-9-11.
 */
//@EnableScheduling
@Configuration
@Slf4j
public class ScheduledService {
    ExecutorService executorService = Executors.newScheduledThreadPool(5);

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled() {
        executorService.submit(() -> {
            log.info("=====>>>>>使用cron  {}", System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("延迟结束：" + Thread.currentThread().getName());
        });

    }

    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
        executorService.submit(() -> {
            log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
        });
//        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
    }

    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        executorService.submit(() -> {
            log.info("=====>>>>>fixedDelay{}", System.currentTimeMillis());
        });
//        log.info("=====>>>>>fixedDelay{}", System.currentTimeMillis());
    }

    public static void main(String[] args) {
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();

        int num = 9;
        int center = num / 2 + 1;
        for (int i = 0; i < center; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = i + 1; j < center; j++) {
                str.append(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                if (j == 0 || j == i * 2) {
                    str.append("*");
                } else {
                    str.append(" ");
                }

            }
            System.out.println(str);
        }
        for (int i = center; i < num; i++) {
            StringBuilder str = new StringBuilder();
            int sub = num - i;

            for (int j = sub; j < center; j++) {
                str.append(" ");
            }
            for (int j = 0; j < sub * 2 - 1; j++) {
                if (j == 0 || j == sub * 2 - 2) {
                    str.append("*");
                } else {
                    str.append(" ");
                }

            }
            System.out.println(str);
        }
    }
}
