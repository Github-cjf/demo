package org.sang.demo.test;

import java.io.*;

/**
 * Created by CJF on 2018-7-25.
 */
public class BufferRead {
    public static void main(String[] args) throws IOException {
        File f = new File("E:\\a.txt");
        String str = "123";
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);
        FileOutputStream fos = new FileOutputStream(f);
        BufferedOutputStream bof = new BufferedOutputStream(fos);
        fw.write("ssss");
        bw.newLine();
        bw.write("aaaa");
        bw.flush();
        int j = 'h';
        fos.close();
        bw.flush();
        bw.close();
    }
}
