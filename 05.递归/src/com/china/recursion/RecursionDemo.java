package com.china.recursion;

/**
 * @Author: china wu
 * @Description: 递归案例
 * @Date: 2020/6/13 13:06
 */
public class RecursionDemo {
    public static void main(String[] args) {
        // 通过打印问题，回顾递归调用机制
        // 递归调用规则：当程序执行一个方法时，就会在栈中开辟一个新的空间，每个空间的数据(局部变量)是独立的
        print(4);
        int result = factorial(3);
        System.out.println(result);
    }

    /**
     * 打印问题
     *
     * @param n
     */
    private static void print(int n) {
        if (n > 2) {
            print(n - 1);
        }
        System.out.println("n=" + n);
    }

    /**
     * 阶乘问题
     *
     * @param n
     * @return
     */
    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}