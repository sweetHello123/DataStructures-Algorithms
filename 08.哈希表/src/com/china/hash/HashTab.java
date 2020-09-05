package com.china.hash;

/**
 * @Author: china wu
 * @Description: 基于数组与单链表来实现哈希表(散列表)
 * @Date: 2020/8/1 13:53
 */
public class HashTab {

    private EleList[] nodes;

    /**
     * 哈希表大小
     */
    private int size;

    /**
     * 存放元素的链表结构
     */
    public class EleList {

        private Ele e;

        private EleList next;

        public EleList(Ele e) {
            this.e = e;
        }

        public void add(int id) {

        }
    }

    /**
     * 元素对象
     */
    public class Ele {

        private int id;

        private String name;

        public Ele(int id) {
            this.id = id;
            this.name = id + "号元素";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}