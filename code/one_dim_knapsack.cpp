#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 0-1 背包问题（空间优化版）
int knapsack(int W, const vector<int>& weights, const vector<int>& values, int n) {
    // 创建一维 DP 数组，dp[j] 表示容量为 j 时的最大价值
    vector<int> dp(W + 1, 0);

    // 填充 DP 数组
    for (int i = 0; i < n; ++i) {
        for (int w = W; w >= weights[i]; --w) {
            dp[w] = max(dp[w], dp[w - weights[i]] + values[i]);
        }
    }

    return dp[W]; // 返回最大价值
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);

    // 示例物品
    vector<int> weights = {1, 2, 3}; // 每个物品的重量
    vector<int> values = {6, 10, 12}; // 每个物品的价值
    int W = 5; // 背包容量
    int n = weights.size(); // 物品数量

    int maxValue = knapsack(W, weights, values, n);
    cout << "Maximum value in knapsack: " << maxValue << endl;

    return 0;
}