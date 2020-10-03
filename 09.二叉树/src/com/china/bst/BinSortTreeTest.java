package com.china.bst;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/9/22 23:57
 */
public class BinSortTreeTest {
    public static void main(String[] args) {
        BinSortTree sortTree = new BinSortTree();

        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            sortTree.addNode2Tree(new TreeNode(arr[i]));
        }
        sortTree.midOrder(new TreeNode(arr[0]));
    }
}