package com.china.sort;

import java.util.Arrays;

/**
 * @Author: china wu
 * @Description: 快速排序
 * @Date: 2020/6/15 17:46
 */
public class FastSortDemo {
    public static void main(String[] args) {
        int[] arr = {-1, 3, 9, 4, 7, 0, 0, 10};
        System.out.println("排序前的数组：" + Arrays.toString(arr));
        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }

    /**
     * 快速排序原理：从数组中选出最小的数，将它与第一个数交换位置，再从剩余数中在选最小的数与第二个数交换，一次类推
     *
     * @param arr
     */
    public void fastSort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
            }
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < arr[1]) {
                temp = arr[i];
                arr[i] = arr[1];
                arr[1] = temp;
            }
        }
        for (int i = 3; i < arr.length; i++) {
            if (arr[i] < arr[2]) {
                temp = arr[i];
                arr[i] = arr[2];
                arr[2] = temp;
            }
        }

    }
}
