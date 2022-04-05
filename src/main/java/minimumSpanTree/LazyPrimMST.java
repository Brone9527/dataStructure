package minimumSpanTree;

import java.util.Vector;

/**
 * @Author zeroback13
 * @Date 2022/4/4 21:56
 * @Version 1.0
 */

//使用prim算法求图的最小生成树
public class LazyPrimMST<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> G;  //图的引用
    private MinHeap<Edge<Weight>> pq; //最小堆，算法辅助数据结构
    private boolean[] marked;         //标记数组，在算法运行过程中标记i是否被访问过
    private Vector<Edge<Weight>> mst; //最下生成树包含的所有边
    private Number mstWeight;         //最小生成树的权值
}
