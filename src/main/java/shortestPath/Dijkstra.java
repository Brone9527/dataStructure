package shortestPath;

import com.sun.org.apache.regexp.internal.RE;
import heapAndPriorityQueue.IndexMaxHeap;
import minimumSpanTree.*;
import sun.awt.windows.WEmbeddedFrame;

import javax.print.attribute.standard.NumberUp;
import java.util.Stack;
import java.util.Vector;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2022/4/9 9:30
 */


// Dijkstra算法求最短路径
public class Dijkstra <Weight extends Number & Comparable>{

    private WeightedGraph G;            // 图的引用
    private int s;                      // 起始点
    private Number[] distTo;            // distTo[i]存储从起始点s到i的最短路径长度
    private boolean[] marked;           // 标记数组, 在算法运行过程中标记节点i是否被访问
    private Edge<Weight>[] form;        // from[i]记录最短路径中, 到达i点的边是哪一条
                                        // 可以用来恢复整个最短路径

    // 构造函数, 使用Dijkstra算法求最短路径
    public Dijkstra(WeightedGraph graph, int s){
        //算法初始化
        G = graph;
        assert s >= 0 && s < G.V();
        this.s = s;
        distTo = new Number[G.V()];
        marked = new boolean[G.V()];
        form = new Edge[G.V()];
        for (int i = 0; i < G.V(); i++){
            distTo[i] = 0.0;
            marked[i] = false;
            form[i] = null;
        }
        // 使用索引堆记录当前找到的到达每个顶点的最短距离
        IndexMinHeap<Weight> ipq = new IndexMinHeap<>(G.V());

        //对起始点s进行初始化
        distTo[s] = 0.0;
        form[s] = new Edge<>(s, s, (Weight)(Number)(0.0));
        ipq.insert(s, (Weight)distTo[s]);
        marked[s] = true;
        while (!ipq.isEmpty()){
            int v = ipq.extractMinIndex();

            //distTo[v] 就是s到v的最短距离
            marked[v] = true;
            //对v所有相邻节点进行更新
            for (Object item:G.adj(v)){
                Edge<Weight> e = (Edge<Weight>)item;
                int w = e.other(v);

                //如果s点到w点的最短路径还没找到
                if(!marked[w]){
                    //如果w以前没有被访问过
                    //或者访问过，但是通过当前的v到w的距离更短，则进行更新
                    if(form[w] == null || distTo[v].doubleValue() + e.wt().doubleValue() < distTo[w].doubleValue()){
                        distTo[w] = distTo[v].doubleValue() + e.wt().doubleValue();
                        form[w] = e;
                        if(ipq.contain(w))
                            ipq.change(w,(Weight)distTo[w] );
                        else
                            ipq.insert(w,(Weight)distTo[w] );
                    }

                }
            }
        }
    }

    //返回从s点到w点的最短路径长度
    Number shortestPathTo(int w){
        assert w >= 0 && w < G.V();
        assert hasPathTo(w);
        return distTo[w];
    }

    //判断s点到w点是否连通
    public boolean hasPathTo(int w){
        assert w >= 0 && w < G.V();
        return marked[w];
    }

    //寻找从s到w的最短路径，将整个路径经过的边放在vec中
    Vector<Edge<Weight>> shortestPath(int w){

        assert w >= 0 && w < G.V();
        assert hasPathTo(w);

        //通过form数组逆向查从s到w的路径，放到栈中
        Stack<Edge<Weight>> s = new Stack<>();
        Edge<Weight> e = form[w];
        while (e.v() != this.s){
            s.push(e);
            e = form[e.v()];
        }
        s.push(e);
        //从栈中依次取出元素。获得顺序的从s到w的路径
        Vector<Edge<Weight>> res = new Vector<>();
        while (!s.empty()){
            e = s.pop();
            res.add(e);
        }
        return res;

    }

    // 打印出从s点到w点的路径
    public void showPath(int w){
        assert w >= 0 && w < G.V();
        assert hasPathTo(w);
        Vector<Edge<Weight>> path = shortestPath(w);
        for (int i = 0; i < path.size();i++){
            System.out.print(path.elementAt(i).v() + "->");
            if (i == path.size() -1)
                System.out.println(path.elementAt(i).w());
        }
    }

    // 测试我们的Dijkstra最短路径算法
    public static void main(String[] args) {
        String filename = "C:\\Users\\Nicholas\\IdeaProjects\\dataStructure\\src\\main\\java\\shortestPath\\testG1.txt";
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);

        // Dijkstra最短路径算法同样适用于有向图
        //SparseGraph<int> g = SparseGraph<int>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        System.out.println("Test Dijkstra:\n");
        Dijkstra<Integer> dijkstra = new Dijkstra<>(g, 0);
        for (int i = 0; i < V; i++) {
            if(dijkstra.hasPathTo(i)){
                System.out.println("Shortest Path to " + i + " : " + dijkstra.shortestPathTo(i));
                dijkstra.showPath(i);
            }else
                System.out.println("No Path to " + i );
            System.out.println("---------------------");
        }
    }
}
