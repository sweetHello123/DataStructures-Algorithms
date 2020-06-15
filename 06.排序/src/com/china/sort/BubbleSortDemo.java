package com.china.sort;

import java.util.Arrays;

/**
 * @Author: china wu
 * @Description: 冒泡排序算法
 * @Date: 2020/6/15 12:10
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 9, 4, 7, 0, 0, 10};
        System.out.println("排序前的数组：" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序思想：从第一个数开始，相邻两个比较并将数字大的放后面，每趟比较下来最大数都会置于最后
     * 下一趟则比较除最大数之外的数，总共需比较的趟数等于数组长度-1。
     * 优化：可能在某一趟比较过程中，数组已经有序了则无需下面的比较，因此可以在每趟排序过程中判断数组元素是否交换过
     * 时间复杂度：O(n²)
     *
     * @param arr 待排序的数组
     */
    public static void bubbleSort(int[] arr) {
        // 用于交换位置的变量
        int temp;
        // flag标识每趟过程是否进行过元素位置交换
        boolean flag = false;
        // 外循环控制的是第几趟比较，内循环控制的是该趟数组中剩余待排序的数
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 前一个数大于后面的数则交换位置
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序的数组为：" + Arrays.toString(arr));
            // 如果flag值为false，表示此时数组已经有序则退出循环
            if (!flag) {
                break;
            } else {
                // 注意每趟排序比较后要将flag重置为false
                flag = false;
            }
        }
    }
}