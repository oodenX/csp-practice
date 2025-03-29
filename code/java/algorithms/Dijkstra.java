package algorithms;

import java.util.*;

public class Dijkstra {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Dijkstra算法实现
    public static int[] dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] distance = new int[n]; // 存储从起点到每个点的最短距离
        boolean[] visited = new boolean[n]; // 标记节点是否已访问

        // 初始化距离数组
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        // 使用优先队列优化，存储(节点, 距离)对
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];

            // 如果节点已访问，跳过
            if (visited[u]) {
                continue;
            }

            visited[u] = true;

            // 遍历当前节点的所有邻接节点
            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                // 松弛操作
                if (!visited[v] && distance[u] != Integer.MAX_VALUE &&
                        distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    pq.offer(new int[]{v, distance[v]});
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int n = 6; // 节点数
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 添加边 (u, v, weight)
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 2, 4);
        addEdge(graph, 1, 2, 1);
        addEdge(graph, 1, 3, 7);
        addEdge(graph, 2, 4, 3);
        addEdge(graph, 3, 5, 1);
        addEdge(graph, 4, 3, 2);
        addEdge(graph, 4, 5, 5);

        int start = 0;
        int[] distances = dijkstra(graph, start);

        System.out.println("从节点" + start + "到各节点的最短距离：");
        for (int i = 0; i < n; i++) {
            System.out.println("到节点" + i + "的距离: " +
                    (distances[i] == Integer.MAX_VALUE ? "不可达" : distances[i]));
        }
    }

    // 辅助方法：向图中添加边
    private static void addEdge(List<List<Edge>> graph, int from, int to, int weight) {
        graph.get(from).add(new Edge(to, weight));
    }
}