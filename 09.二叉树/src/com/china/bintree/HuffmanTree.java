package com.china.bintree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: china wu
 * @Description: 哈夫曼树
 * @Date: 2020/9/16 13:28
 */
public class HuffmanTree {

    /**
     * 构建哈夫曼树
     *
     * @param arr 数组
     */
    public static Node createHuffManTree(int[] arr) {
        // 构建一个集合保存树节点
        ArrayList<Node> nodes = new ArrayList<>();
        // 用数组的每个值构建节点并保存到集合里
        for (int val : arr) {
            nodes.add(new Node(val));
        }
        System.out.println("原集合：" + nodes);

        while (nodes.size() > 1) {
            // 每次先将集合排好序
            Collections.sort(nodes);

            // 将集合中最小的两个数拿出来作为左右子节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            // 将它们之和构建父节点
            Node parentNode = new Node(leftNode.getVal() + rightNode.getVal());
            // 将左右子节点传给父节点
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);

            // 删除集合中的前两个节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 并加入新的节点
            nodes.add(parentNode);

            System.out.println(nodes);
        }
        // 返回哈夫曼树的根节点
        return nodes.get(0);
    }

    /**
     * 前序遍历
     *
     * @param root 根节点
     */
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root + " ");
            if (root.getLeft() != null) {
                preOrder(root.getLeft());
            }
            if (root.getRight() != null) {
                preOrder(root.getRight());
            }
        } else {
            System.out.println("树为空");
        }
    }
}

/**
 * 树节点 - 实现Comparable接口使得节点可排序
 */
class Node implements Comparable<Node> {

    private int val;

    private Node left;

    private Node right;

    public Node(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.val - o.val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
