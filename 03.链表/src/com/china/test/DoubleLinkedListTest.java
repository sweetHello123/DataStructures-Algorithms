package com.china.test;

import com.china.linkedlist.DoubleLinkedList;
import org.junit.Test;

/**
 * @Author: china wu
 * @Description: 双向链表测试
 * @Date: 2020/6/10 13:50
 */
public class DoubleLinkedListTest {

    private DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

    private DoubleLinkedList.HeroNode node1 = doubleLinkedList.getNodeInstance(1, "宋江", "及时雨");
    private DoubleLinkedList.HeroNode node2 = doubleLinkedList.getNodeInstance(2, "卢俊义", "玉麒麟");
    private DoubleLinkedList.HeroNode node3 = doubleLinkedList.getNodeInstance(3, "吴用", "智多星");
    private DoubleLinkedList.HeroNode node4 = doubleLinkedList.getNodeInstance(4, "林冲", "豹子头");

    @Test
    public void testAdd() {
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node2);

        doubleLinkedList.list();
    }

    @Test
    public void testAddByNoOrder() {
        doubleLinkedList.addByNoOrder(node2);
        doubleLinkedList.addByNoOrder(node1);
        doubleLinkedList.addByNoOrder(node4);
        doubleLinkedList.addByNoOrder(node3);

        doubleLinkedList.list();
    }

    @Test
    public void testUpdate() {
        testAdd();
        System.out.println("--------------");
        DoubleLinkedList.HeroNode node = doubleLinkedList.getNodeInstance(2, "小卢", "玉麒麟");
        doubleLinkedList.update(node);
        doubleLinkedList.list();
    }

    @Test
    public void testDelete() {
        testAdd();
        System.out.println("--------------");
        doubleLinkedList.deleteByNo(2);
        doubleLinkedList.deleteByNo(4);
        doubleLinkedList.deleteByNo(1);
        doubleLinkedList.deleteByNo(3);

        doubleLinkedList.list();
    }
}