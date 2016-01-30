package jacoTools.java;

/**
 * Created by Jaco on 15-11-18.
 * 深度优先遍历来发现最短路径，解决几个点到一个确定顶点的最短路径问题。
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> Q = new Queue<>(); // 队列有两个作用：1.安排顺序  2.空了的时候说明遍历结束
        marked[s] = true;
        Q.enqueue(s);
        while(!Q.isEmputy()){       // 队列空了的时候，说明与s连接的点都已经找完了。
            int v = Q.dequeue();
            for(int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    Q.enqueue(w);
                }

            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        Stack<Integer> path = new Stack<>();
        for(int i = v ; i != s; i = edgeTo[i])
            path.push(i);
        path.push(s);
        return path;

    }
}
