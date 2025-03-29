package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Knapsack {
    // 01背包问题的动态规划解法（空间优化）
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        // dp数组，dp[w]表示容量为w的情况下的最大总价值
        int[] dp = new int[capacity + 1];

        // 初始化dp数组
        Arrays.fill(dp, 0);

        // 动态规划填表
        for (int i = 0; i < n; i++) {
            for (int w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }

        // 返回最大总价值
        return dp[capacity];
    }

    // 测试01背包问题
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("背包的最大总价值: " + maxValue);
    }
}