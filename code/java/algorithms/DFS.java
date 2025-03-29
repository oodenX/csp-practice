package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS {
    // 记录节点是否被访问过
    private boolean[] visited;
    // 邻接表表示的图
    private List<List<Integer>> adj;

    public DFS(int vertices) {
        visited = new boolean[vertices];
        adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // 添加边
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // 从给定顶点开始进行DFS
    public void dfs(int startVertex) {
        // 标记当前顶点为已访问
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        // 递归访问所有未访问的邻接顶点
        for (Integer neighbor : adj.get(startVertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    // 对整个图进行DFS（处理非连通图的情况）
    public void dfsTraversal() {
        // 初始化访问数组
        Arrays.fill(visited, false);

        // 对每个未访问的顶点进行DFS
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
