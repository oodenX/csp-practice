package algorithms;

public class FloydWarshall {
    private static final int INF = Integer.MAX_VALUE;

    // Floyd-Warshall算法实现
    public static int[][] floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        // 初始化距离矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // 核心算法：对于每一对顶点(i,j)，尝试所有中间顶点k
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 检测负权环（如果对角线上出现负值）
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("图中存在负权环！");
                return null;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] graph = {
                {0, 3, INF, 5},
                {2, 0, INF, 4},
                {INF, 1, 0, INF},
                {INF, INF, 2, 0}
        };

        int[][] distances = floydWarshall(graph);

        if (distances != null) {
            System.out.println("所有节点对之间的最短距离：");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][j] == INF) {
                        System.out.print("INF ");
                    } else {
                        System.out.print(distances[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}