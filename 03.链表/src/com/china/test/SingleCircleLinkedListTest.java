package com.china.test;

import com.china.linkedlist.SingleCircleLinkedList;
import org.junit.Test;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/6/10 22:20
 */
public class SingleCircleLinkedListTest {

    @Test
    public void testCreate() {
        SingleCircleLinkedList circleLinkedList = new SingleCircleLinkedList();
        circleLinkedList.createNodes(1);
        circleLinkedList.list();
    }
}
