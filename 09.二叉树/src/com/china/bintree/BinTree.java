package com.china.bintree;

/**
 * @Author: china wu
 * @Description: 二叉树
 * @Date: 2020/9/5 21:17
 */
public class BinTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     *
     * @param root 根节点
     */
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root + "\t");
            if (root.getLeft() != null) {
                preOrder(root.getLeft());
            }
            if (root.getRight() != null) {
                preOrder(root.getRight());
            }
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public void midOrder(TreeNode root) {
        if (root != null) {
            if (root.getLeft() != null) {
                midOrder(root.getLeft());
            }
            System.out.print(root + "\t");
            if (root.getRight() != null) {
                midOrder(root.getRight());
            }
        } else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     */
    public void lastOrder(TreeNode root) {
        if (root != null) {
            if (root.getLeft() != null) {
                lastOrder(root.getLeft());
            }
            if (root.getRight() != null) {
                lastOrder(root.getRight());
            }
            System.out.print(root + "\t");
        } else {
            System.out.println("二叉树为空");
        }
    }
}

/**
 * 树的节点结构
 */
class TreeNode {

    private int no;

    private String name;

    /**
     * 定义一个左指针(默认为空)
     */
    private TreeNode left;

    /**
     * 定义一个右指针(默认为空)
     */
    private TreeNode right;

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
