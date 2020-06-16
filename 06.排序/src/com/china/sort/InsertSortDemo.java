package com.china.sort;

import java.util.Arrays;

/**
 * @Author: china wu
 * @Description: 插入排序算法
 * @Date: 2020/6/16 15:10
 */
public class InsertSortDemo {
    public static void main(String[] args) {
        int[] arr = {-1, -2, 4, 8, 0, -5};
        System.out.println("排序前的数组：" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }

    /**
     * 插入排序思想：第一轮选择数组第二个数与数组第一个数比较插入形成一个有序的子数组，
     * 下一轮选数组第三个数比较插入到子数组的某个位置形成新的有序子数组，经过多轮插入后
     * 直到最后一个数为止，整个数组就有序了，总共要经历的轮数等于数组长度-1
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int insertValue = 0;
        int subArrIndex = 0;
        // 表示第几轮
        for (int i = 1; i < arr.length; i++) {
            // 每轮待插入的数
            insertValue = arr[i];
            // 待插入数的前一个位置，即有序子数组最后一个下标位置
            subArrIndex = i - 1;
            // 待插入的数与前面形成的子数组中的每个数比较，如果有比自己大的，则将这些大的数都后移一位
            while (subArrIndex >= 0 && insertValue < arr[subArrIndex]) {
                arr[subArrIndex + 1] = arr[subArrIndex];
                subArrIndex--;
            }
            // 退出循环后，待插入数在子数组中的位置就在subArrIndex后一个
            if (subArrIndex != i - 1) {
                arr[subArrIndex + 1] = insertValue;
            }
            System.out.println("第" + i + "轮排序：" + Arrays.toString(arr));
        }
    }
}