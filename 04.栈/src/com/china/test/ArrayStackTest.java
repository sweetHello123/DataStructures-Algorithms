package com.china.test;

import com.china.stack.ArrayStack;
import org.junit.Test;

/**
 * @Author: china wu
 * @Description: 测试基于数组的栈
 * @Date: 2020/6/12 23:46
 */
public class ArrayStackTest {

    private ArrayStack arrayStack = new ArrayStack(3);

    /**
     * 测试入栈
     */
    @Test
    public void testPush() {
        arrayStack.list();
        System.out.println("-----------");
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.list();
//        arrayStack.push(4);
    }

    /**
     * 测试出栈
     */
    @Test
    public void testPop() {
        testPush();
        for (int i = 0; i < 3; i++) {
            int val = arrayStack.pop();
            System.out.println("出栈的元素为：" + val);
        }
//        arrayStack.pop();
    }
}
