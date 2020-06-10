package com.china.test;

import com.china.linkedlist.SingleLinkedList;
import org.junit.Test;

/**
 * @Author: china wu
 * @Description: 单链表测试
 * @Date: 2020/6/8 13:40
 */
public class SingleLinkedListTest {

    /**
     * 测试依次从尾部添加节点
     */
    @Test
    public void testAdd() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        SingleLinkedList.HeroNode node1 = singleLinkedList.getNodeInstance(1, "宋江", "及时雨");
        SingleLinkedList.HeroNode node2 = singleLinkedList.getNodeInstance(2, "卢俊义", "玉麒麟");
        SingleLinkedList.HeroNode node3 = singleLinkedList.getNodeInstance(3, "吴用", "智多星");
        SingleLinkedList.HeroNode node4 = singleLinkedList.getNodeInstance(4, "林冲", "豹子头");

        // 依次从尾部添加元素
        singleLinkedList.add(node2);
        singleLinkedList.add(node1);
        singleLinkedList.add(node4);
        singleLinkedList.add(node3);

        singleLinkedList.list();
    }

    /**
     * 测试按编号顺序添加节点
     */
    @Test
    public void testAddByNoOrder() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        SingleLinkedList.HeroNode node1 = singleLinkedList.getNodeInstance(1, "宋江", "及时雨");
        SingleLinkedList.HeroNode node2 = singleLinkedList.getNodeInstance(2, "卢俊义", "玉麒麟");
        SingleLinkedList.HeroNode node3 = singleLinkedList.getNodeInstance(3, "吴用", "智多星");
        SingleLinkedList.HeroNode node4 = singleLinkedList.getNodeInstance(4, "林冲", "豹子头");

        // 根据编号顺序添加节点
        singleLinkedList.addByNoOrder(node2);
        singleLinkedList.addByNoOrder(node1);
        singleLinkedList.addByNoOrder(node4);
        singleLinkedList.addByNoOrder(node3);
        singleLinkedList.list();
    }

    /**
     * 测试根据no修改节点属性
     */
    @Test
    public void testUpdate() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        SingleLinkedList.HeroNode node1 = singleLinkedList.getNodeInstance(1, "宋江", "及时雨");
        SingleLinkedList.HeroNode node2 = singleLinkedList.getNodeInstance(2, "卢俊义", "玉麒麟");
        SingleLinkedList.HeroNode node3 = singleLinkedList.getNodeInstance(3, "吴用", "智多星");

        // 根据编号顺序添加节点
        singleLinkedList.addByNoOrder(node2);
        singleLinkedList.addByNoOrder(node1);
        singleLinkedList.addByNoOrder(node3);
        singleLinkedList.list();
        System.out.println("-------------------");

        SingleLinkedList.HeroNode node = singleLinkedList.getNodeInstance(1, "宋江", "呼保义");
        singleLinkedList.updateByNo(node);
        singleLinkedList.list();
    }

    /**
     * 测试根据no来删除节点
     */
    @Test
    public void testDelete() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        SingleLinkedList.HeroNode node1 = singleLinkedList.getNodeInstance(1, "宋江", "及时雨");
        SingleLinkedList.HeroNode node2 = singleLinkedList.getNodeInstance(2, "卢俊义", "玉麒麟");
        SingleLinkedList.HeroNode node3 = singleLinkedList.getNodeInstance(3, "吴用", "智多星");

        singleLinkedList.addByNoOrder(node1);
        singleLinkedList.addByNoOrder(node2);
        singleLinkedList.addByNoOrder(node3);

        singleLinkedList.list();

        System.out.println("-----------------");
        singleLinkedList.deleteByNo(1);
        singleLinkedList.deleteByNo(2);
        singleLinkedList.deleteByNo(4);
        singleLinkedList.list();
    }
}