#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 0-1 背包问题
int knapsack(int W, const vector<int>& weights, const vector<int>& values, int n) {
    // 创建 DP 表，dp[i][j] 表示前 i 个物品在容量 j 下的最大价值
    vector<vector<int>> dp(n + 1, vector<int>(W + 1, 0));

    // 填充 DP 表
    for (int i = 1; i <= n; ++i) {
        for (int w = 1; w <= W; ++w) {
            if (weights[i - 1] <= w) {
                // 选择当前物品或不选择
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
            } else {
                // 当前物品不能放入背包
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    return dp[n][W]; // 返回最大价值
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