package com.china.test;

import com.china.linkedlist.SingleCircleLinkedList;
import org.junit.Test;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/6/10 22:20
 */
public class SingleCircleLinkedListTest {

    /**
     * 测试创建循环链表
     */
    @Test
    public void testCreate() {
        SingleCircleLinkedList circleLinkedList = new SingleCircleLinkedList();
        circleLinkedList.createNodes(1);
        circleLinkedList.list();
    }

    /**
     * 测试约瑟夫问题
     */
    @Test
    public void testJoseph() {
        SingleCircleLinkedList circleLinkedList = new SingleCircleLinkedList();
        circleLinkedList.createNodes(5);
        circleLinkedList.list();
        circleLinkedList.joseph(5, 1, 2);
    }
}
