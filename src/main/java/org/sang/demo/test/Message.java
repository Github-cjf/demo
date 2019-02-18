package org.sang.demo.test;

import lombok.Data;
import sun.security.jca.GetInstance;

/**
 * Created by CJF on 2018-7-24.
 */
public class Message {
    private static Message message;

    private Message(){

    }

    public static Message getInstance(){
        if(message == null) {
            synchronized (Message.class) {
                if(message == null) {
                    try {
                        Thread.sleep(1000);
                        message = new Message();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return message;
    }
}
