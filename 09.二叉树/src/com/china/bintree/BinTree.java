package com.china.bintree;

/**
 * @Author: china wu
 * @Description: 二叉树
 * @Date: 2020/9/5 21:17
 */
@SuppressWarnings("all")
public class BinTree {

    // 树节点
    private TreeNode root;

    // 前序查找比较的次数
    private int preSearchTime = 0;

    // 中序查找比较的次数
    private int midSearchTime = 0;

    // 后序查找比较的次数
    private int lastSearchTime = 0;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getPreSearchTime() {
        return preSearchTime;
    }

    public int getMidSearchTime() {
        return midSearchTime;
    }

    public int getLastSearchTime() {
        return lastSearchTime;
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

    /**
     * 前序查找
     *
     * @param root 根节点
     * @param no   待查找的no
     * @return 节点
     */
    public TreeNode preSearch(TreeNode root, int no) {
        if (root != null) {
            // 比较(查找)次数加1
            preSearchTime++;
            // 先判断根节点值是否等于no
            if (root.getNo() == no) {
                return root;
            }
            // 定义一个节点保存结果
            TreeNode resNode = null;
            // 左子树前序遍历查找
            if (root.getLeft() != null) {
                resNode = preSearch(root.getLeft(), no);
            }
            // 左子树找到值对应的节点则立即返回，不再查找
            if (resNode != null) {
                return resNode;
            }
            // 否则右子树前序遍历查找
            if (root.getRight() != null) {
                resNode = preSearch(root.getRight(), no);
            }
            return resNode;
        }
        return null;
    }


    /**
     * 中序查找
     *
     * @param root
     * @param no
     * @return
     */
    public TreeNode midSearch(TreeNode root, int no) {
        if (root != null) {
            TreeNode resNode = null;
            if (root.getLeft() != null) {
                resNode = midSearch(root.getLeft(), no);
            }
            if (resNode != null) {
                return resNode;
            }
            // 比较(查找)次数加1
            midSearchTime++;
            if (root.getNo() == no) {
                return root;
            }
            if (root.getRight() != null) {
                resNode = midSearch(root.getRight(), no);
            }
            return resNode;
        }
        return null;
    }

    /**
     * 后序查找
     *
     * @param root
     * @param no
     * @return
     */
    public TreeNode lastSearch(TreeNode root, int no) {
        if (root != null) {
            TreeNode resNode = null;
            if (root.getLeft() != null) {
                resNode = lastSearch(root.getLeft(), no);
            }
            // 左子树找到值对应的节点则立即返回，不再查找
            if (resNode != null) {
                return resNode;
            }
            if (root.getRight() != null) {
                resNode = lastSearch(root.getRight(), no);
            }
            // 右子树找到值对应的节点则立即返回，不再查找
            if (resNode != null) {
                return resNode;
            }
            // 比较(查找)次数加1
            lastSearchTime++;
            if (root.getNo() == no) {
                return root;
            }
            return resNode;
        }
        return null;
    }
}

/**
 * 树的节点结构
 */
@SuppressWarnings("all")
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
