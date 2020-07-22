package com.china.search;

/**
 * @Author: china wu
 * @Description: 二分查找算法
 * @Date: 2020/7/22 16:26
 */
public class HalfSearchDemo {
    public static void main(String[] args) {
        int[] arr = {0, 3, 5, 16, 33};
        int index = halfSearch(arr, 0, arr.length - 1, 0);
        System.out.println("下标为：" + index);
    }

    /**
     * 二分查找思想：前提数组必须是有序的，先确定数组中间的下标mid，然后让待查找的值val与arr[mid]比较
     * 如果val>arr[mid]，说明待查找的数在mid右边则向右递归查找
     * 如果val<arr[mid]，说明待查找的数在mid左边则向左递归查找
     *
     * @param arr   待查找的数组
     * @param left  左索引
     * @param right 右索引
     * @param val   待查找的值
     * @return 如果找到了就返回下标，否则返回-1
     */
    public static int halfSearch(int[] arr, int left, int right, int val) {
        int mid = (left + right) / 2;
        // left比right大说明递归完整个数组，但是没找到
        if (left > right) {
            return -1;
        }
        if (val > arr[mid]) {
            return halfSearch(arr, mid + 1, right, val);
        } else if (val < arr[mid]) {
            return halfSearch(arr, left, mid - 1, val);
        } else {
            return mid;
        }
    }
}