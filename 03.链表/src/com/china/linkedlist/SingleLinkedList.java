package com.china.linkedlist;

import java.util.Stack;

/**
 * @Author: china wu
 * @Description: 单链表实现案例
 * @Date: 2020/6/8 12:52
 */
@SuppressWarnings("all")
public class SingleLinkedList {

    /**
     * 初始化一个头结点，不放任何数据，不能移动
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 从链表最后添加结点，不考虑no编号
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 定义一个辅助结点用于遍历链表
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 将最后一个结点的next指向新结点
        temp.next = heroNode;
    }

    /**
     * 根据编号顺序添加结点
     *
     * @param heroNode
     */
    public void addByNoOrder(HeroNode heroNode) {
        // 定义一个辅助结点
        HeroNode temp = head;
        // flag标识是否找到添加结点所在的位置
        boolean flag = false;
        while (true) {
            // temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果temp下一个结点的no大于添加结点的no，则添加结点的位置就是temp之后
            if (temp.next.no > heroNode.no) {
                break;
            }
            // 该结点已经存在不能添加
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("该结点的编号%d已经存在，不能添加\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 根据编号修改结点属性
     *
     * @param newHeroNode 新结点
     */
    public void updateByNo(HeroNode newHeroNode) {
        // 定义辅助结点并指向第一个元素结点
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("编号为%d的结点不存在，无法更新\n", newHeroNode.no);
        }
    }

    /**
     * 根据编号来删除结点(思路:找到要删除结点的前一个结点位置)
     *
     * @param no
     */
    public void deleteByNo(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("编号为%d的结点不存在，无法删除\n", no);
        }
    }

    /**
     * 展示链表所有数据
     */
    public void list() {
        HeroNode temp = head.next;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 反转单链表 - 头插法
     */
    public void reverseNode() {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        // 定义一个节点变量用于保存当前cur的下一个对象
        HeroNode temp;
        // 构造一个新链表的头节点，reverse指向该新链表
        HeroNode reverse = new HeroNode(0, "", "");
        while (cur != null) {
            temp = cur.next;
            // 将当前对象的next指向新链表的第一个真实节点，第一次为null，后面每一次都指向新加入的节点
            cur.next = reverse.next;
            // 将新链表头节点的next指向当前对象，完成头插
            reverse.next = cur;
            // cur后移
            cur = temp;
        }
        // 将head的next指向反转后的链表
        head.next = reverse.next;
    }

    /**
     * 逆序输出链表的各个节点 - 利用栈实现
     */
    public void reversePrintNode() {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        // 遍历节点并压栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 不停的弹栈知道栈为空
        while (stack.size() != 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 获取单链表有效节点的个数
     *
     * @return
     */
    public int getNodesNum() {
        HeroNode temp = head.next;
        int num = 0;
        while (temp != null) {
            num++;
            temp = temp.next;
        }
        return num;
    }

    /**
     * 查找链表倒数第k个节点
     *
     * @param k 倒数第k个节点
     */
    public HeroNode getLastIndexNode(int k) {
        // 遍历链表得到长度
        int size = getNodesNum();
        if (size <= 0 || k <= 0 || k > size) {
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 获取结点对象
     *
     * @param no
     * @param name
     * @param nickname
     * @return
     */
    public HeroNode getNodeInstance(int no, String name, String nickname) {
        return new HeroNode(no, name, nickname);
    }

    /**
     * 单链表结点结构
     */
    public class HeroNode {

        /**
         * 编号
         */
        private int no;

        /**
         * 姓名
         */
        private String name;

        /**
         * 昵称
         */
        private String nickname;

        /**
         * 下个结点指针域
         */
        private HeroNode next;

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}