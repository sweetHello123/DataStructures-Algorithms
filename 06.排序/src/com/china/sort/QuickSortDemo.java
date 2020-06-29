package com.china.sort;

import java.util.Arrays;

/**
 * @Author: china wu
 * @Description: 快速排序算法
 * @Date: 2020/6/28 23:17
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int arr[] = {3, 7, 0, 6, -5, 9, -2, 7, 10};
        System.out.println("排序前的数组：" + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }

    /**
     * 快速排序思想：选取任意一个数作为基准，比基准数小的数放其前面，比基准数大的数放其后面。
     * 至此分成了左右两部分序列，对左右两部分序列使用递归快排
     */

    /**
     * 基准数分区
     *
     * @param arr  待排序的数组
     * @param low  起始位置
     * @param high 结束位置
     * @return 第一轮排序后基准数索引位置
     */
    public static int partition(int arr[], int low, int high) {
        // 将第一个数作为基准数
        int pivot = arr[low];
        // 使用循环实现分区
        while (low < high) {
            // 从右向左移动high，找到第一个小于基准值的值
            while (arr[high] >= pivot && low < high) {
                high--;
            }
            // 将右侧找到小于基准数的值加入到左边的（坑）位置，左指针向右移动一个位置i++
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
            // 从左向右移动low，找到第一个大于基准值的值
            while (arr[low] < pivot && low < high) {
                low++;
            }
            // 将左侧找到的大于基准值的值加入到右边的坑中，右指针向左移动一个位置
            if (low < high) {
                arr[high] = arr[low];
                high--;
            }
        }
        // 退出循环时，low与high指针重合，将pivot值填入
        arr[low] = pivot;
        // 返回此时基准值的索引位置
        return low;
    }

    /**
     * 快速排序
     *
     * @param arr  待排序的数组
     * @param low  起始位置
     * @param high 结束位置
     */
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // 分区操作，将一个数组分成两个分区，返回分区界限索引
            int index = partition(arr, low, high);
            // 对左分区进行快排
            quickSort(arr, low, index - 1);
            // 对右分区进行快排
            quickSort(arr, index + 1, high);
        }
    }

    /**
     * 对整个数组快排
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }
}