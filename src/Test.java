import graph.Graph;
import graph.api;

public class Test {
    public static void main(String args[]){
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1,  2);
        graph.addEdge(1,  5);
        graph.addEdge(2,  1);
        graph.addEdge(2,  5);
        graph.addEdge(2,  3);
        graph.addEdge(2,  4);
        graph.addEdge(3,  2);
        graph.addEdge(3,  4);
        graph.addEdge(4,  2);
        graph.addEdge(4,  5);
        graph.addEdge(4,  3);
        graph.addEdge(5,  4);
        graph.addEdge(5,  1);
        graph.addEdge(5,  2);
        Graph bfs = api.BFS(graph, 1);
        api.printPath(bfs, 1, 3);
    }
}
