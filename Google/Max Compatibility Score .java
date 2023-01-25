class Solution {
    private static int calculate(int[][] students,int[][] mentors,int st,int mt)
    {
        int count=0;
        // System.out.println(st+" "+mt+" "+students.length+" "+mentors.length);
        for(int i=0;i<mentors[0].length;i++)
        {
            if(students[st][i]==mentors[mt][i])
            {
                count++;
            }
        }
        // System.out.println(count);
        return count;
    }
    private static int solve(int[][] students,int[][] mentors,int st,int mt,int count,boolean[] visited)
    {
        if(st==visited.length || mt==visited.length || count==visited.length)
        {
            if(count == visited.length)
            {
                // System.out.println("done");
                return 0;
            }
            return (int)-1e9;
        }
        int c1=(int)-1e9,c2=(int)-1e9;
        if(visited[mt]==false)
        {
            //include
            visited[mt]=true;
            c1=solve(students,mentors,st+1,0,count+1,visited)+calculate(students,mentors,st,mt);
            visited[mt]=false;
        }
        //exclude
        c2=solve(students,mentors,st,mt+1,count,visited);
        return Math.max(c1,c2);
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] visited=new boolean[students.length];
        return solve(students,mentors,0,0,0,visited);
    }
}