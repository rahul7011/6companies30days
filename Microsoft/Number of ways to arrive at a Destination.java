class Solution {
    private static class Edge{
        int v;
        int w;
        Edge(int v,int w)
        {
            this.v=v;
            this.w=w;
        }
    }
    private static class Pair{
        int src;
        long wsf;
        Pair(int src,long wsf)
        {
            this.src=src;
            this.wsf=wsf;
        }
    }
    private static int dijkstra_btr(ArrayList<Edge>[]graph,int src)
    {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.wsf<=b.wsf)
            {
                return -1;
            }
            return 1;
        });
        int v=graph.length;
        boolean[] visited=new boolean[v];
        long[] dis=new long[v];
        int[] ways=new int[v];
        Arrays.fill(dis,(long)1e13);
        pq.add(new Pair(src,0));
        dis[src]=0;
        ways[src]=1;
        while(pq.size()!=0)
        {
            Pair rm=pq.remove();
            if(visited[rm.src]==true)
            {
                continue;
            }
            visited[rm.src]=true;
            for(Edge e:graph[rm.src])
            {
                if(visited[e.v]==false && dis[e.v]>e.w+rm.wsf)
                {
                    pq.add(new Pair(e.v,e.w+rm.wsf));
                    dis[e.v]=e.w+rm.wsf;
                    ways[e.v]=ways[rm.src];
                }else if(visited[e.v]==false && dis[e.v]==e.w+rm.wsf)
                {
                    ways[e.v]=(ways[e.v]+ways[rm.src])%(int)(1e9+7);
                }
            }
        }
        // System.out.println(Arrays.toString(dis));
        return ways[v-1];
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<Edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++)
        {
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }
        return dijkstra_btr(graph,0);
    }
}