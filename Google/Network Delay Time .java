class Solution {
    public class Pair{
        int v;
        int w;
        Pair(int v,int w)
        {
            this.v=v;
            this.w=w;
        }
    }
    private static int dijkstra(ArrayList<Pair>[] graph,int k)
    {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        pq.add(new int[] {k-1,0});
        int[] par=new int[graph.length];
        int[] dis=new int[graph.length];
        Arrays.fill(dis,(int)1e9);
        par[k-1]=-1;
        dis[k-1]=0;
        int max=(int)-1e9;
        boolean[] visited=new boolean[graph.length];
        int nodesEncounter=0;
        while(pq.size()!=0)
        {
            int[] rm=pq.remove();
            if(visited[rm[0]]==true)
            {
                continue;
            }
            max=Math.max(max,rm[1]);
            visited[rm[0]]=true;
            nodesEncounter++;
            for(Pair p:graph[rm[0]])
            {
                if(visited[p.v]==false && dis[p.v]>p.w+rm[1])
                {
                    pq.add(new int[] {p.v,p.w+rm[1]});
                    dis[p.v]=p.w+rm[1];
                    par[p.v]=rm[0];
                }
            }
        }
        return nodesEncounter==graph.length?max:-1;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[]graph=new ArrayList[n];
        for(int i=0;i<graph.length;i++)
            graph[i]=new ArrayList<>();
        for(int i=0;i<times.length;i++)
        {
            int u=times[i][0]-1;
            int v=times[i][1]-1;
            int w=times[i][2];
            graph[u].add(new Pair(v,w));
        }
        return dijkstra(graph,k);
    }
}