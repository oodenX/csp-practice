package algorithms;

import java.util.*;

public class BFS {
    // 邻接表表示的图
    private List<List<Integer>> adj;

    public BFS(int vertices) {
        adj = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // 添加边
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // 从给定顶点开始进行BFS
    public void bfs(int startVertex) {
        // 标记数组，记录节点是否被访问过
        boolean[] visited = new boolean[adj.size()];

        // 创建队列用于BFS
        Queue<Integer> queue = new LinkedList<>();

        // 标记起始节点为已访问
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            // 出队一个顶点并打印
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            // 获取所有未访问的邻接顶点并将它们加入队列
            for (Integer neighbor : adj.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // 对整个图进行BFS遍历（处理非连通图）
    public void bfsTraversal() {
        boolean[] visited = new boolean[adj.size()];

        // 对每个未访问的顶点进行BFS
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                // 创建队列用于BFS
                Queue<Integer> queue = new LinkedList<>();

                // 标记起始节点为已访问
                visited[i] = true;
                queue.add(i);

                while (!queue.isEmpty()) {
                    // 出队一个顶点并打印
                    int vertex = queue.poll();
                    System.out.print(vertex + " ");

                    // 获取所有未访问的邻接顶点并将它们加入队列
                    for (Integer neighbor : adj.get(vertex)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
    }
}
