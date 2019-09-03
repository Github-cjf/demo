package org.sang.demo.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by CJF on 2019/8/13.
 */
public class showMessageDialog extends JFrame {
    JTextField inputText;
    JTextArea showText;
    String regex="[a-zA-Z]+";

    showMessageDialog(){
        setLayout(new FlowLayout());
        inputText=new JTextField(10);
        showText=new JTextArea(9,20);
        inputText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=inputText.getText();
                if(str.matches(regex)){
                    showText.append(str+",");
                }else {
                    JOptionPane.showMessageDialog(showMessageDialog.this,"输入非法字符","消息对话框",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        add(inputText,BorderLayout.EAST);
        add(showText,BorderLayout.CENTER);
        setVisible(true);
        setBounds(100,100,400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        showMessageDialog showMessageDialog=new showMessageDialog();
    }
}
