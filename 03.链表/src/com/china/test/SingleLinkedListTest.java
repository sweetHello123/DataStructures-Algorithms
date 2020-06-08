package com.china.test;

import com.china.linkedlist.SingleLinkedList;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/6/8 13:40
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        SingleLinkedList.HeroNode node1 = singleLinkedList.getNodeInstance(1, "宋江", "及时雨");
        SingleLinkedList.HeroNode node2 = singleLinkedList.getNodeInstance(2, "卢俊义", "玉麒麟");
        SingleLinkedList.HeroNode node3 = singleLinkedList.getNodeInstance(3, "吴用", "智多星");
        SingleLinkedList.HeroNode node4 = singleLinkedList.getNodeInstance(4, "林冲", "豹子头");

        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);

        singleLinkedList.list();
    }
}
