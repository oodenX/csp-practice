#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 广度优先搜索函数
void BFS(int startNode, const vector<vector<int>>& graph, vector<bool>& visited) {
    queue<int> q;
    q.push(startNode);
    visited[startNode] = true;

    while (!q.empty()) {
        int currentNode = q.front();
        q.pop();

        cout << "Visited node: " << currentNode << endl;

        // 遍历当前节点的邻居节点
        for (int neighbor : graph[currentNode]) {
            if (!visited[neighbor]) {
                q.push(neighbor);
                visited[neighbor] = true;
            }
        }
    }
}

int main() {
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

    // 从节点 0 开始进行 BFS
    BFS(0, graph, visited);

    return 0;
}