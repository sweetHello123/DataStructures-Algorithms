package com.china.search;

/**
 * @Author: china wu
 * @Description: 斐波那契查找算法
 * @Date: 2020/7/22 18:34
 */
public class FibSearchDemo {

    public static int maxSize = 20;

    public static void main(String[] args) {

    }

    /**
     * 生成斐波那契数列
     * @return
     */
    public static int[] fibArray() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static void fibSearch() {

    }
}
