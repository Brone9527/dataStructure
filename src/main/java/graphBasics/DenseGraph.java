package graphBasics;

import java.util.Vector;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2022/3/26 18:08
 */

//稠密图 - 邻接矩阵
public class DenseGraph implements Graph{

    private int n;  //节点数
    private int m;  //边数
    private boolean directed;  //是否为有向图
    private boolean[][] g;  //图的具体数据

    //构造函数
    public DenseGraph(int n, boolean directed){
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }

    public int V(){return n;}  //返回节点个数
    public int E(){return m;}  //返回边个数

    //向图中添加一个边
    public void addEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if(hasEdge(v, w))
            return;
        g[v][w] = true;

        if(!directed)
            g[w][v] = true;

        m++;
    }

    //验证图中是否有v到w的边
    public boolean hasEdge(int v, int w){

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];

    }

    //显示图的信息
    public void show(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(g[i][j]+"\t");
            }
            System.out.println();

        }
    }

    //返回图中一个顶点所有临边
    //由于java使用引用机制，返回一个Vector不会带来额外的开销
    public Iterable<Integer> adj(int v){
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < n; i++) {
            if(g[v][i])
                adjV.add(i);
        }
        return adjV;
    }
}
