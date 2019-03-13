package org.sang.demo.test;

import java.util.concurrent.*;

/**
 * Created by CJF on 2018-7-24.
 */
public class Message {
    static ExecutorService executors = Executors.newFixedThreadPool(10);

    private static Message message;

    private Message(){

    }

    public static Message getInstance(){
        if(message == null) {
            synchronized (Message.class) {
                if(message == null) {
                    message = new Message();
                }
            }

        }
        return message;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 0;
        Callable<Integer> call = () -> (int) (Math.random()*100);

        for (int i = 0; i < 10000; i++) {
            Future<Integer> fu = executors.submit(call);
            System.out.println(fu.get());

            FutureTask<Integer> fu2 = new FutureTask<>(call);
            new Thread(fu2).start();

            new Thread(()->{}).start();

            x++;
        }
        executors.shutdown();
        System.out.println("x=="+x);
    }
}
