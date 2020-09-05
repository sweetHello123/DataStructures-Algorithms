package com.china.linkedlist;

/**
 * @Author: china wu
 * @Description: 双向链表实现案例
 * @Date: 2020/6/10 12:37
 */
@SuppressWarnings("all")
public class DoubleLinkedList {

    /**
     * 初始化头结点
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 从链表最后添加结点，不考虑no编号
     *
     * @param node
     */
    public void add(HeroNode node) {
        // 定义一个辅助结点用于遍历链表
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 将最后一个结点的后指针指向新结点，将新结点的前指针指向最后一个结点
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 根据编号顺序添加结点
     *
     * @param node
     */
    public void addByNoOrder(HeroNode node) {
        // 定义一个辅助结点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            // temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            // temp下一个结点比添加结点的no大，则说明temp的no小于添加结点的no
            if (temp.next.no > node.no) {
                break;
            }
            // 该结点已经存在不能添加
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("该结点的编号%d已经存在，不能添加\n", node.no);
        } else {
            if (temp.next != null) {
                node.next = temp.next;
                temp.next.pre = node;
            }
            temp.next = node;
            node.pre = temp;
        }
    }

    /**
     * 根据编号修改结点属性
     *
     * @param node 新结点
     */
    public void update(HeroNode node) {
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else {
            System.out.printf("编号为%d的结点不存在，无法更新\n", node.no);
        }
    }

    /**
     * 根据编号来删除结点(思路:直接找到待删除的结点，修改前后指针来自我删除)
     *
     * @param no
     */
    public void deleteByNo(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            // 要判断删除的是否为尾结点，否则会报空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
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
     * 获取节点对象
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
     * 双向链表结点结构
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
         * 前一个结点指针域(默认为null)
         */
        private HeroNode pre;

        /**
         * 下一个结点指针域(默认为null)
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