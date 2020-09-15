package com.china.stack;

/**
 * @Author: china wu
 * @Description: 基于数组模拟栈
 * @Date: 2020/6/12 22:50
 */
public class ArrayStack {

    /**
     * 栈的容量
     */
    private int size;

    /**
     * 存放数据的数组
     */
    private int[] elements;

    /**
     * 栈顶，初始化为-1表示没有数据
     */
    private int top = -1;

    /**
     * 栈的构造器
     *
     * @param size
     */
    public ArrayStack(int size) {
        this.size = size;
        elements = new int[this.size];
    }

    /**
     * 判断栈是否已满
     *
     * @return
     */
    public boolean isFull() {
        return top == size - 1;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param ele
     */
    public void push(int ele) {
        if (isFull()) {
            System.out.println("栈已满，无法加入元素");
            return;
        }
        elements[++top] = ele;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int val = elements[top];
        top--;
        return val;
    }

    /**
     * 显示栈数据
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("当前栈为空");
            return;
        }
        //
        for (int i = top; i >= 0; i--) {
            System.out.printf("elements[%d]=%d\n", i, elements[i]);
        }
    }
}
