package org.sang.demo.test;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Created by CJF on 2019/8/12.
 */
public class JTreeDemo extends Frame {
    public JTreeDemo() throws HeadlessException {
        super();

        //根结点
        DefaultMutableTreeNode courseNode = new DefaultMutableTreeNode("课程");
        //第一层结点
        DefaultMutableTreeNode firstNode = new DefaultMutableTreeNode("第一阶段");
        DefaultMutableTreeNode secondNode = new DefaultMutableTreeNode("第二阶段");
        //第二层结点
        DefaultMutableTreeNode mathNode = new DefaultMutableTreeNode("高数");
        DefaultMutableTreeNode englishNode = new DefaultMutableTreeNode("英语");
        DefaultMutableTreeNode literatureNode = new DefaultMutableTreeNode("文学");
        DefaultMutableTreeNode computerNode = new DefaultMutableTreeNode("计算机");

        //给根结点添加子结点
        courseNode.add(firstNode);
        courseNode.add(secondNode);
        //给第一层结点添加子结点
        firstNode.add(mathNode);
        firstNode.add(englishNode);
        secondNode.add(literatureNode);
        secondNode.add(computerNode);

        //设置窗口大小
        setSize(800, 800);

        //用树生成JTree组件
        JTree jTree = new JTree(courseNode);
        //添加JTree组件到窗口
        add(jTree);
        //设置窗口可见
        setVisible(true);
        System.out.println("deep1=" + courseNode.getDepth());
    }

    public static void main(String[] args) {
        JTreeDemo test = new JTreeDemo();
    }

}
