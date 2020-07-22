package com.china.search;

/**
 * @Author: china wu
 * @Description: 插值查找算法
 * @Date: 2020/7/22 17:32
 */
public class InsertSearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 8};
        int index = insertSearch(arr, 0, arr.length - 1, 5);
        System.out.println(index);
    }

    /**
     * 插值查找思想：在二分查找的基础上，将中间值mid优化，使其快速定位待查找数的位置
     *
     * @param arr   待查找的数组
     * @param left  左索引
     * @param right 右索引
     * @param val   待查找的值
     * @return 如果找到了就返回下标，否则返回-1
     */
    public static int insertSearch(int[] arr, int left, int right, int val) {
        // 自适应mid
        int mid = left + (right - left) * (val - arr[left]) / (arr[right] - arr[left]);
        if (left > right || val < arr[0] || val > arr[arr.length - 1]) {
            return -1;
        }
        if (val > arr[mid]) {
            return insertSearch(arr, mid + 1, right, val);
        } else if (val < arr[mid]) {
            return insertSearch(arr, left, mid - 1, val);
        } else {
            return mid;
        }
    }
}