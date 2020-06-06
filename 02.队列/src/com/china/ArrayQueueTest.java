package com.china;

import java.util.Scanner;

/**
 * @Author: china wu
 * @Description: 测试基于数组的队列
 * @Date: 2020/6/5 18:53
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个整数");
                    int val = scanner.nextInt();
                    arrayQueue.addEle(val);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getEle();
                        System.out.printf("取出的数据为：%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = arrayQueue.headQueue();
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
