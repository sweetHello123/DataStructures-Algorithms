package com.china;

/**
 * @Author: china wu
 * @Description: 基于数组实现队列
 * @Date: 2020/6/5 17:19
 */
public class ArrayQueue {

    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 队列头
     */
    private int front;

    /**
     * 队列尾
     */
    private int rear;

    /**
     * 存放数据的数组
     */
    private int[] elements;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[this.maxSize];
        // 初始时队列头和队列尾指向-1，取值时front后移，添加时rear后移
        // front指向的是队头元素的前一个位置，rear指向队尾最后一个元素
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return rear == this.maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 往队列尾加元素
     *
     * @param element
     */
    public void addEle(int element) {
        if (isFull()) {
            System.out.println("队列已满，无法添加");
            return;
        }
        elements[++rear] = element;
    }

    /**
     * 从队列头取元素
     *
     * @return
     */
    public int getEle() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取值");
        }
        return elements[++front];
    }

    /**
     * 展示队列中的数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }

    /**
     * 查看队头元素
     */
    public void queueHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        System.out.println(elements[front + 1]);
    }
}
