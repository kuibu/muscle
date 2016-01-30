package jacoTools.java;
import edu.princeton.cs.introcs.In;
/**
 * Created by Jaco on 15-11-14.
 * Graph 使用一个表示每个顶点所连接顶点的数组（即邻接表）表示，核心方法是返回一个顶点相连的其他顶点。
 * 这种结构也影响了使用这种结构的算法（如DFS、DFPaths）。
 */
public class Graph {
    private Bag<Integer>[] adj;
    private final int V;
    private int E;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Object[V];
        for(int i = 0; i < V; i++) adj[i] = new Bag<Integer>();
    }
    public Graph(In in){
        this(in.readInt());
        int inE = in.readInt();       //计数，为了知道读到哪里停
        for(int i = 0; i < inE; i++){
            int w = in.readInt();
            int v = in.readInt();
            addEdge(v,w);
        }
    }
    public int E(){return E;}
    public int V(){return V;}
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);   //无向图中，为了直接找出相邻点，把连接信息存了两遍
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}
