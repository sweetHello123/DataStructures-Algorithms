package main.java.com.china.dp;

/**
 * @Author: china wu
 * @Description: 01背包问题 - 动态规划
 * @Date: 2020/9/20 22:34
 */
public class KnapsackProblem {

    /**
     * 01背包问题的思想：每次遍历到第i个物品，根据w[i]和v[i]来确定物品是否放入背包中，即对于给定的n个物品
     * 设w[i]和v[i]分别表示第i个物品的重量和价值，再使vx[i][j]表示前i的物品能够装入容量为j的背包中的
     * 最大价值，则有以下结论：
     * 1.vx[i][0]=vx[0][j]=0; 容量为0时与不装入物品时的价值
     * 2.当w[i]>j时，vx[i][j]=vx[i-1][j]; 当放入第i个物品时的重量大于当前背包的重量时，采用上一个单元格的装入策略
     * 3.当w[i]<=j时，vx[i][j]=max{vx[i-1][j],vx[i-1][j-w[i]]+v[i]}; 考虑有剩余空间的情况，vx[i-1][j]表示上一个单
     * 元格的装入策略，vx[i-1][j-w[i]]+v[i]表示前i-1的物品能够放入到剩余空间时的价值与装入第i个物品时的价值之和。
     * 最后取两个表达式的最大值作为最大价值。
     */
    public static void main(String[] args) {
        // 每个物品的重量
        int w[] = {1, 4, 3};
        // 每个物品的价值
        int v[] = {1500, 3000, 2000};
        // 给定背包的容量
        int c = 4;
        // 物品的个数
        int n = v.length;
        // 定义一个最大价值的二维数组
        int[][] vx = new int[n + 1][c + 1];

        // 定义一个二维数组记录最优解的情况
        int[][] path = new int[n + 1][c + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                if (w[i - 1] > j) {
                    vx[i][j] = vx[i - 1][j];
                } else {
                    // i从1开始，w[i]与v[i]要替换成w[i-1]和v[i-1]
                    if (vx[i - 1][j] < vx[i - 1][j - w[i - 1]] + v[i - 1]) {
                        vx[i][j] = vx[i - 1][j - w[i - 1]] + v[i - 1];
                        path[i][j] = 1;
                    } else {
                        vx[i][j] = vx[i - 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < vx.length; i++) {
            for (int j = 0; j < vx[i].length; j++) {
                System.out.print(vx[i][j] + " ");
            }
            System.out.println();
        }

        int k = path.length - 1;
        int h = path[0].length - 1;
        while (k > 0 && h > 0) {
            if (path[k][h] == 1) {
                System.out.printf("第%d个物品放入背包\n-+", k);
                h -= w[k - 1];
            }
            k--;
        }
    }
}
