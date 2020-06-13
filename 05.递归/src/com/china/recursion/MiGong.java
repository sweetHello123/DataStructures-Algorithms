package com.china.recursion;

/**
 * @Author: china wu
 * @Description: 递归应用：使用递归算法解决迷宫问题
 * @Date: 2020/6/13 14:13
 */
public class MiGong {
    public static void main(String[] args) {
        // 创建一个8行7列的二维数组表示迷宫地图
        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        // 遍历数组：1表示围墙，0表示可走点
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        findWay(map, 1, 1);

        System.out.println("找到通路后的迷宫:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路，如果小球能到map[6][5]位置则说明通路找到。
     * 规定：0表示未走点，1表示此点是围墙，2表示走通的点，3表示已走过但走不通的点
     * 要求：小球移动时的自定义策略 - 下->右->上->左，如果走不通再回溯
     *
     * @param map 迷宫地图
     * @param i   小球起始所在行
     * @param j   小球起始所在列
     * @return 如果找到通路则返回true，否则返回false
     */
    public static boolean findWay(int[][] map, int i, int j) {
        // 如果末点位置为2表示通路已找到
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                // 假设该点可以走通
                map[i][j] = 2;
                // 在该点基础上向下递归找通路
                if (findWay(map, i + 1, j)) {
                    return true;
                }
                // 在该点基础上向右递归找通路
                else if (findWay(map, i, j + 1)) {
                    return true;
                }
                // 在该点基础上向上递归找通路
                else if (findWay(map, i - 1, j)) {
                    return true;
                }
                // 在该点基础上向上递归找通路
                else if (findWay(map, i, j - 1)) {
                    return true;
                }
                // 下右上左的策略都走不通，则表示该点走不通是死路
                else {
                    map[i][j] = 3;
                    return false;
                }
            }
            // 如果该点不是0，则可能是1,2,3，直接返回false
            else {
                return false;
            }
        }
    }
}