package main.java;

/**
 * @Author: china wu
 * @Description: 字符串匹配问题 - 暴力匹配算法
 * @Date: 2020/9/22 17:26
 */
public class ViolenceMatchDemo {
    public static void main(String[] args) {
        String str1 = "hello world";
        String str2 = "orl";
        int index = violenceMatch(str1, str2);
        System.out.println(index);
    }

    /**
     * 暴力匹配算法
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 字符串2在字符串1中的索引
     */
    public static int violenceMatch(String str1, String str2) {
        // 将字符串转为字符数组
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int length1 = c1.length;
        int length2 = c2.length;

        // 定义i指向c1，j指向c2
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            // 从第一个字符开始匹配，相等则让指针后移
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                // i指向下一个未参与匹配的字符
                i = i - j + 1;
                // j指向开始
                j = 0;
            }
            if (j == length2) {
                return i - j;
            }
        }
        return -1;
    }
}
