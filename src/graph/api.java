package graph;

import java.util.ArrayDeque;
import java.util.Iterator;

public class api {

    public static Graph BFS(Graph graph, int key){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Graph.Vertex s = graph.getVertex(key);
        Graph.Vertex f = null;
        s.color = 1;
        s.d = 0;
        s.p = null;
        queue.addLast(key);
        while (!queue.isEmpty()){
            int u = queue.removeFirst();
            Iterator<Graph.Vertex> adjList = graph.getAdjList(u).iterator();
            while (adjList.hasNext()){
                Graph.Vertex v = adjList.next();
                if(v.color == 0){
                    v.color = 1;
                    v.d = graph.getVertex(u).d + 1;
                    v.p = graph.getVertex(u);
                    f = v;
                    queue.addLast(v.label);
                }
                graph.getVertex(u).color = 2;
            }
        }
        return graph;
    }

    public static void printPath(Graph g, int src, int dest){
        Graph.Vertex s = g.getVertex(src);
        Graph.Vertex v = g.getVertex(dest);
        if (v == s)
            System.out.print(s.label + " ");
        else if (v.p == null)
            System.out.println("No Path");
        else{
            printPath(g, s.label, v.p.label);
            System.out.print(v.label + " ");
        }
    }

}
