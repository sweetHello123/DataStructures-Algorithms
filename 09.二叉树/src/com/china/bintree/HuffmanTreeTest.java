package com.china.bintree;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/9/16 16:45
 */
public class HuffmanTreeTest {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node node = HuffmanTree.createHuffManTree(arr);
        System.out.print("前序遍历：");
        HuffmanTree.preOrder(node);
    }
}
