package com.china.sort;

import java.util.Arrays;

/**
 * @Author: china wu
 * @Description: 选择排序算法
 * @Date: 2020/6/15 17:46
 */
public class SelectSortDemo {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 9, 4, 7, 0, -4, 10};
        System.out.println("排序前的数组：" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }

    /**
     * 选择排序思想：从数组中选出最小的数，将它与数组第一个数交换位置，再从剩余数中再选最小的数与数组第二个数交换，
     * 每轮下来最小数都置于前，总共要经历的轮数等于数组长度-1
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        // 外循环控制的是轮数,内循环控制的是该轮中待确定的最小数
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一轮比较都假定当前起始位置为最小数
            int min = arr[i];
            // 获取最小数的下标位置
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 依次判断后续数中有无比min更小的，如果有则重新赋值
                if (arr[j] < arr[i]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 找出最小数后应判断最小数下标是否重新赋值过，再与数组起始位置交换
            if (minIndex != i) {
                // 最小值位置应该放第一个数
                arr[minIndex] = arr[i];
                // 第一个数位置放最小值
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "轮排序后数组为：" + Arrays.toString(arr));
        }
    }
}