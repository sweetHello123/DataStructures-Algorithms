package com.china.linkedlist;

/**
 * @Author: china wu
 * @Description: 循环链表实现案例
 * @Date: 2020/6/10 18:17
 */
public class SingleCircleLinkedList {

    /**
     * 第一个数据结点，不能移动
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
     * 约瑟夫问题（小孩报数出圈)
     *
     * @param num     结点总数
     * @param startNo 起始编号
     * @param k       每次报数(1<=k<=num)
     */
    public void joseph(int num, int startNo, int k) {
        if (first == null || startNo < 1 || startNo > num) {
            System.out.println("参数有误,重新输入");
            return;
        }
        // 定义一个辅助结点，先让它指向最后一个结点
        Node helper = first;
        while (true) {
            // 如果helper的next指向第一个结点，表示helper是最后一个结点
            if (helper.next == first) {
                break;
            }
            // helper后移
            helper = helper.next;
        }

        // 将first定位到开始报数的起始结点，并且helper处于first之后
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        // 循环报数并将结点出圈，直到圈内只剩一个结点为止，first指向的始终是要出圈的结点
        while (true) {
            // 如果helper与first指向同一个结点，表示只剩一个结点
            if (helper == first) {
                break;
            }
            // 循环后移
            for (int j = 0; j < k - 1; j++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.printf("出圈的结点编号为%d\n", first.no);

            // 将first指向的结点删除
            first = first.next;
            helper.next = first;
        }
        System.out.printf("最后出圈的结点编号为%d\n", first.no);
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
