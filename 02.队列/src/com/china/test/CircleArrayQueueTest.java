package com.china.test;

import com.china.queue.ArrayQueue;
import com.china.queue.CircleArrayQueue;

import java.util.Scanner;

/**
 * @Author: china wu
 * @Description: 测试基于数组的环形队列
 * @Date: 2020/6/8 0:22
 */
public class CircleArrayQueueTest {
    public static void main(String[] args) {
        // 创建一个容量为4的环形队列，最多存放3个数据
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        char ch;
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("s(show)：展示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取数据");
            System.out.println("h(head)：查看队列第一个数据");
            System.out.println("e(exit)：退出");
            System.out.println("请选择以上一个指令");
            ch = scanner.next().charAt(0);
            switch (ch) {
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个整数");
                    int val = scanner.nextInt();
                    circleArrayQueue.addEle(val);
                    break;
                case 'g':
                    try {
                        int result = circleArrayQueue.getEle();
                        System.out.printf("取出的数据为：%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = circleArrayQueue.headQueue();
                        System.out.printf("队列头数据为：%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}
