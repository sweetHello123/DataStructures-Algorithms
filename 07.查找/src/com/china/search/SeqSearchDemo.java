package com.china.search;

/**
 * @Author: china wu
 * @Description: 线性查找算法
 * @Date: 2020/7/20 18:15
 */
public class SeqSearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 29, -3, 43, 18};
        int result = seqSearch(arr, -3);
        if (result == -1) {
            System.out.println("未找到改值的元素");
        } else {
            System.out.println("找到了，下标为" + result);
        }
    }

    /**
     * 线性查找：对数组遍历逐一比较，找到一个与给定值相同的元素即返回下标位置
     *
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}