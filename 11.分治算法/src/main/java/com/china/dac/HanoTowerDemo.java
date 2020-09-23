package main.java.com.china.dac;

/**
 * @Author: china wu
 * @Description: 汉诺塔问题 - 分治算法(将大问题分解为小问题求解)
 * @Date: 2020/9/19 22:13
 */
public class HanoTowerDemo {
    public static void main(String[] args) {
        // 移动次数为2的n次方减一
        move(3, 'A', 'B', 'C');
    }

    /**
     * 移动大小盘的方法
     *
     * @param num 盘的数量
     * @param a   第一个塔
     * @param b   第二个塔
     * @param c   第三个塔
     */
    public static void move(int num, char a, char b, char c) {
        // 只有一个盘的情况
        if (num == 1) {
            System.out.println("移动第1个盘从" + a + "->" + c);
        }
        // 盘子数量大于等于2时，将盘子看做两部分处理：1.底下最大的盘子，2.最大盘子的以上部分
        else {
            // 将大盘以上的部分从第一个塔移动到第二个塔，中间过程借助了第三个塔
            move(num - 1, a, c, b);
            System.out.println("移动第" + num + "个盘从" + a + "->" + c);
            // 将第二个塔的所有盘子移动到第三个塔，中间过程借助了第一个塔
            move(num - 1, b, a, c);
        }
    }
}