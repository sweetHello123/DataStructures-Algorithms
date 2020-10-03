package com.china.avltree;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/9/28 15:53
 */
public class AvlTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 加入节点至二叉排序树
     *
     * @param node 待插入的节点
     */
    public void addNode2Tree(TreeNode node) {
        // 待插入的节点值比根节点值小
        if (node.val < root.val) {
            // 根节点无左子节点
            if (root.left == null) {
                root.left = node;
            } else {
                // 递归添加
                addNode2Tree(root.left);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                addNode2Tree(root.right);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public void midOrder(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                midOrder(root.left);
            }
            System.out.println(root);
            if (root.right != null) {
                midOrder(root.right);
            }
        }
    }
}

class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * 以某一节点作为根节点的树的高度
     *
     * @return
     */
    public int height() {
        return 1 + Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height());
    }
}