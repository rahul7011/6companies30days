class Solution {
    public static class Pair{
        int v;
        int w;
        Pair(int v,int w)
        {
            this.v=v;
            this.w=w;
        }
    }
    public static int solve(ArrayList<Pair>[] graph,int src,int dst,int k)
    {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        pq.add(new int[]{src,0,0});
        boolean[][] visited=new boolean[graph.length][k+2];
        while(pq.size()!=0)
        {
            int[] rm=pq.remove();
            if(visited[rm[0]][rm[2]]==true)
            {
                continue;
            }
            if(rm[0]==dst)
            {
                return rm[1];
            }
            visited[rm[0]][rm[2]]=true;
            for(Pair p:graph[rm[0]])
            {
                if(rm[2]<=k && visited[p.v][rm[2]+1]==false)
                {
                    pq.add(new int[]{p.v,rm[1]+p.w,rm[2]+1});
                }
            }
        }
        return -1;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Pair>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++)
        {
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            graph[u].add(new Pair(v,w));
        }
        return solve(graph,src,dst,k);
    }
}