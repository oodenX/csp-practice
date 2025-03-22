#include <iostream>
#include <vector>
#include <stack>

using namespace std;

// 深度优先搜索函数
void DFS(int startNode, const vector<vector<int>>& graph, vector<bool>& visited) {
    stack<int> s;
    s.push(startNode);

    while (!s.empty()) {
        int currentNode = s.top();
        s.pop();

        if (!visited[currentNode]) {
            cout << "Visited node: " << currentNode << endl;
            visited[currentNode] = true;
        }

        // 遍历当前节点的邻居节点
        for (int neighbor : graph[currentNode]) {
            if (!visited[neighbor]) {
                s.push(neighbor);
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(false), cout.tie(false);
    // 示例图的邻接表表示
    vector<vector<int>> graph = {
        {1, 2},    // 节点 0 的邻居
        {0, 3, 4}, // 节点 1 的邻居
        {0, 4},    // 节点 2 的邻居
        {1, 5},    // 节点 3 的邻居
        {1, 2, 5}, // 节点 4 的邻居
        {3, 4}     // 节点 5 的邻居
    };

    int numNodes = graph.size();
    vector<bool> visited(numNodes, false);

    // 从节点 0 开始进行 DFS
    DFS(0, graph, visited);

    return 0;
}