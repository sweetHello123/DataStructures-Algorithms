package com.china.bintree;

/**
 * @Author: china wu
 * @Description: 测试二叉树遍历方式
 * @Date: 2020/9/5 21:57
 */
public class BinTreeDemo {
    public static void main(String[] args) {
        // 创建二叉树对象
        BinTree binTree = new BinTree();

        // 创建树节点
        TreeNode root = new TreeNode(1, "A");
        TreeNode node2 = new TreeNode(2, "B");
        TreeNode node3 = new TreeNode(3, "C");
        TreeNode node4 = new TreeNode(4, "D");

        // 构建二叉树结构
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        binTree.setRoot(root);

        System.out.println("前序遍历：");
        binTree.preOrder(root);

        System.out.println();

        System.out.println("中序遍历：");
        binTree.midOrder(root);

        System.out.println();

        System.out.println("后序遍历：");
        binTree.lastOrder(root);
        System.out.println();

        TreeNode treeNode1 = binTree.preSearch(root, 1);
        TreeNode treeNode2 = binTree.midSearch(root, 1);
        TreeNode treeNode3 = binTree.lastSearch(root, 1);

        System.out.println("前序查找：" + treeNode1 + "，查找次数：" + binTree.getPreSearchTime());
        System.out.println("中序查找：" + treeNode2 + "，查找次数：" + binTree.getMidSearchTime());
        System.out.println("后序查找：" + treeNode3 + "，查找次数：" + binTree.getLastSearchTime());
    }
}
