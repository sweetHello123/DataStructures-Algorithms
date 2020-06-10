package com.china.linkedlist;

/**
 * @Author: china wu
 * @Description: 循环链表实现案例
 * @Date: 2020/6/10 18:17
 */
public class SingleCircleLinkedList {

    /**
     * 第一个结点，不能移动
     */
    private Node first;

    /**
     * 创建多个结点并构建出循环链表
     *
     * @param count
     */
    public void createNodes(int count) {
        if (count < 1) {
            System.out.println("count值必须为正整数");
            return;
        }
        // 定义一个结点用于指向新结点
        Node cur = null;
        for (int i = 1; i <= count; i++) {
            Node node = new Node(i);
            // 首结点特殊处理
            if (i == 1) {
                first = node;
                node.next = first;
                cur = first;
            } else {
                cur.next = node;
                node.next = first;
                cur = node;
            }
        }
    }


    /**
     * 约瑟夫问题
     *
     * @param startNo 起始编号
     * @param num 结点总数
     * @param k 每次报数(1<=k<=num)
     */
    public void joseph(int startNo, int num, int k) {
        return;
    }

    /**
     * 展示循环链表所有结点
     */
    public void list() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Node cur = first;
        while (true) {
            System.out.println(cur);
            // cur的next指向first，表示cur已是链表最后一个结点
            if (cur.next == first) {
                break;
            }
            cur = cur.next;
        }
    }

    public class Node {

        /**
         * 编号
         */
        private int no;

        /**
         * next指针域
         */
        private Node next;

        /**
         * 结点构造器
         *
         * @param no
         */
        public Node(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    '}';
        }
    }
}
