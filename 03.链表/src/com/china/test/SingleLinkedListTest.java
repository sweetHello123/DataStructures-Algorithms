package com.china.test;

import com.china.linkedlist.SingleLinkedList;
import org.junit.Test;

/**
 * @Author: china wu
 * @Description: 单链表测试
 * @Date: 2020/6/8 13:40
 */
public class SingleLinkedListTest {

    private SingleLinkedList singleLinkedList = new SingleLinkedList();

    private SingleLinkedList.HeroNode node1 = singleLinkedList.getNodeInstance(1, "宋江", "及时雨");
    private SingleLinkedList.HeroNode node2 = singleLinkedList.getNodeInstance(2, "卢俊义", "玉麒麟");
    private SingleLinkedList.HeroNode node3 = singleLinkedList.getNodeInstance(3, "吴用", "智多星");
    private SingleLinkedList.HeroNode node4 = singleLinkedList.getNodeInstance(4, "林冲", "豹子头");

    /**
     * 测试依次从尾部添加节点
     */
    @Test
    public void testAdd() {
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
        singleLinkedList.addByNoOrder(node4);
        singleLinkedList.addByNoOrder(node2);
        singleLinkedList.addByNoOrder(node1);
        singleLinkedList.addByNoOrder(node3);
        singleLinkedList.list();
    }

    /**
     * 测试根据no修改节点属性
     */
    @Test
    public void testUpdate() {
        testAddByNoOrder();
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
        testAddByNoOrder();
        System.out.println("-----------------");
        singleLinkedList.deleteByNo(1);
        singleLinkedList.deleteByNo(2);
        singleLinkedList.deleteByNo(4);
        singleLinkedList.list();
    }

    /**
     * 测试获取有效节点个数
     */
    @Test
    public void testGetNodesNum() {
        testAddByNoOrder();
        int nodesNum = singleLinkedList.getNodesNum();
        System.out.println("有效节点个数：" + nodesNum);
    }

    /**
     * 测试查询倒数第k个节点
     */
    @Test
    public void testGetLastIndexNode() {
        testAddByNoOrder();
        int k = 2;
        SingleLinkedList.HeroNode node = singleLinkedList.getLastIndexNode(k);
        System.out.println("倒数第" + k + "个节点为：" + node);
    }

    /**
     * 测试反转单链表
     */
    @Test
    public void testReverseNode() {
        System.out.println("原链表：");
        testAddByNoOrder();
        singleLinkedList.reverseNode();
        System.out.println("反转后的链表：");
        singleLinkedList.list();
    }

    /**
     * 测试逆序输出链表节点
     */
    @Test
    public void testReversePrintNode() {
        System.out.println("原链表：");
        testAddByNoOrder();
        System.out.println("逆序输出：");
        singleLinkedList.reversePrintNode();
    }
}