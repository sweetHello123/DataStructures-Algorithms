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
     * 根据编号顺序添加节点
     *
     * @param heroNode
     */
    public void addByNoOrder(HeroNode heroNode) {
        // 定义一个辅助节点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            // temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果temp下一个节点的no大于添加节点的no，则添加节点的位置就是temp所在位置之后
            if (temp.next.no > heroNode.no) {
                break;
            }
            // 该节点已经存在不能添加
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("该节点的编号%d已经存在，不能添加\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 根据编号修改节点属性
     *
     * @param newHeroNode 新节点
     */
    public void updateByNo(HeroNode newHeroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("编号为%d的节点不存在，无法更新\n", newHeroNode.no);
        }
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
