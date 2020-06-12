package com.china.queue;

/**
 * @Author: china wu
 * @Description: 基于数组模拟环形队列
 * @Date: 2020/6/6 23:57
 */
public class CircleArrayQueue {

    /**
     * 数组最大容量
     */
    private int maxSize;

    /**
     * 队列头(front指向队列的第一个元素，初始值为0)
     */
    private int front;

    /**
     * 队列尾(rear指向队列最后一个元素的后一个位置，约定队列要空出一个位且该位置无元素，初始值为0)
     */
    private int rear;

    /**
     * 存放数据的数组
     */
    private int[] elements;

    /**
     * 构造方法
     *
     * @param size
     */
    public CircleArrayQueue(int size) {
        maxSize = size;
        elements = new int[maxSize];
    }

    /**
     * 判断循环队列是否已满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断循环队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
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
        elements[rear] = element;
        // 环形队列考虑rear不能超过数组下标
        rear = (rear + 1) % maxSize;
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
        int ele = elements[front];
        front = (front + 1) % maxSize;
        return ele;
    }

    /**
     * 展示环形队列中的数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        // 从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("elements[%d]=%d\n", i % maxSize, elements[i % maxSize]);
        }
    }

    /**
     * 计算环形队列中有效数据的个数
     *
     * @return
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 查看队头元素（只查不取）
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return elements[front];
    }
}
