package com.china;

public class SparseArray {
    public static void main(String[] args) {

        // 1.创建一个原始的二维数组
        int[][] chessArr = new int[11][11];
        // 0代表没有棋子，1代表黑子，2代表蓝子
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("原始二维数组：");
        // 输出原始的二维数组
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("-----------------------");

        // 遍历数组，统计非0的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("非0数有" + sum + "个");

        System.out.println("-----------------------");

        // 2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 给稀疏数组第一行赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // count表示为第几个非0数
        int count = 0;
        // 给稀疏数组其余行赋值
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("稀疏数组：");
        for (int i = 0; i < sum + 1; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }

        System.out.println("-----------------------");

        // 3.恢复原始的二维数组（稀疏数组[0][0]与[0][1]位置的数字表示原始数组的行与列）
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 从稀疏数组第二行开始读数，并赋给原始数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组：");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
