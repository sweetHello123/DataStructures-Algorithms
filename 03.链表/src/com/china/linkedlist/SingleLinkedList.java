package com.china.linkedlist;

/**
 * @Author: china wu
 * @Description: 单链表实现案例
 * @Date: 2020/6/8 12:52
 */
public class SingleLinkedList {

    /**
     * 初始化一个头结点，不放任何数据，不能移动
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 从链表最后添加节点，不考虑no编号
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 定义一个辅助节点用于遍历链表
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        //
        temp.next = heroNode;
    }

    /**
     * 展示链表所有数据
     */
    public void list() {
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 获取节点对象的方法
     *
     * @param no
     * @param name
     * @param nickname
     * @return
     */
    public HeroNode getNodeInstance(int no, String name, String nickname) {
        return new HeroNode(no, name, nickname);
    }

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
         * 下个节点指针域
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
