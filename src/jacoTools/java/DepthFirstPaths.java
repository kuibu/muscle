package jacoTools.java;

/**
 * Created by Jaco on 15-11-17.
 * 一张确定的图上，求某1个确定顶点和其他几个顶点的路径(找到一条路径即可，不保证是最短的)。如求顶点2，3，4到顶点0的路径。
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for (int v : G.adj(s))
            if (!marked[v]) {
                dfs(G, v);        // 交换下与下面一行的位置，可以变成尾递归。
                edgeTo[v] = s;
            }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(hasPathTo(v)) {
            Stack<Integer> path = new Stack<>();
            for(int i = v ; i != s ; i = edgeTo[i])
                path.push(i);
            path.push(s);
            return path;
        }
        else return null;
    }

}
