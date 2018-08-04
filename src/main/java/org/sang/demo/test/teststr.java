package org.sang.demo.test;

import org.springframework.beans.factory.annotation.Autowired;

public class teststr {
    public static int cnt=6;
    static{
        cnt+=9;
    }

    public teststr(){
        cnt ++;
    }

    @Autowired
    private org.sang.demo.test.Person person;

    public static void main(String[] args) {
//        System.out.println(cnt);
//        System.out.println(new teststr().cnt);

        for (int i = 0; i <5 ; i++) {
            if(i == 3){
                continue;
            }
            System.out.println(i);
        }
    }
    static{
        cnt/=3;
    }

}
