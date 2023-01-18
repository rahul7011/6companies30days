class Solution {
    public static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    void dijkstra(int n, ArrayList<Edge>[] graph, int[] dist, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[] { src, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[0];
            int du = cur[1];
            if (du > dist[u]) {
                continue;
            }

            for (Edge nb : graph[u]) {
                int v = nb.v;
                int duv = nb.w;
                if (dist[v] > du + duv) {
                    dist[v] = du + duv;
                    pq.add(new int[] { v, dist[v] });
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
        // creating a distance arr[i][j] where i is from and j is to
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
            dist[i][i] = 0; // khud se khud ka distance(0)
        }
        for (int i = 0; i < n; i++) {
            dijkstra(n, graph, dist[i], i);
        }
        int minCitys = (int) 1e9;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int currCity = 0;
            // for each node find the no. of cities you can visit in given distanceThreshold
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (dist[i][j] <= distanceThreshold) {
                    currCity++;
                }
            }
            if (currCity <= minCitys) {
                minCitys = currCity;
                ans = i;
            }
        }
        return ans;
    }
}