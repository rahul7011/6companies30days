class Solution {
    private static boolean kahnsAlgo(int n, int[][] pre)
    {
        ArrayList<Integer>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        int[] indegree=new int[n];
        for(int i=0;i<pre.length;i++)
        {
            indegree[pre[i][1]]++;
            graph[pre[i][0]].add(pre[i][1]);
        }
        LinkedList<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
                q.addLast(i);
        }
        List<Integer>ans=new ArrayList<>();
        while(q.size()!=0)
        {
            int size=q.size();
            while(size-- > 0)
            {
                int rm=q.removeFirst();
                ans.add(rm);
                for(int v:graph[rm])
                {
                    if(--indegree[v]==0)
                    {
                        q.addLast(v);
                    }
                }
            }
        }
        return ans.size()==n?true:false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //pure form of kahns algo a.k.a topolical sort
        return kahnsAlgo(numCourses,prerequisites);
    }
}