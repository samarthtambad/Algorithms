package graph;

import java.util.*;

public class Graph {

    class Vertex{
        int label;
        int color; // 0 -> white, 1 -> gray, 2 -> black
        int d; // distance from source
        Vertex p;
        public Vertex(int label){
            this.label = label;
            this.color = 0;
            this.d = 0;
            this.p = null;
        }
    }

    private int numVertices;
    private int numEdges;
    private HashMap<Integer, Vertex> vertexMap;
    private HashMap<Integer, ArrayList<Vertex>> adjListMap;

    public Graph(){
        this.numVertices = 0;
        this.numEdges = 0;
        this.vertexMap = new HashMap<>();
        this.adjListMap = new HashMap<>();
    }

    public void addVertex(int label){
        Vertex v = new Vertex(label);
        this.numVertices++;
        vertexMap.put(label, v);
        adjListMap.put(label, new ArrayList<>());
    }

    public void addEdge(int v1, int v2){
        this.numEdges++;
        (adjListMap.get(v1)).add(vertexMap.get(v2));
    }

    public Vertex getVertex(int key){
        return vertexMap.get(key);
    }

    public ArrayList<Vertex> getAdjList(int key){
        return new ArrayList<>(adjListMap.get(key));
    }

    public void printGraph(){
        Iterator<Integer> vertexIterator = vertexMap.keySet().iterator();
        while(vertexIterator.hasNext()){
            int key = vertexIterator.next();
            System.out.print("( " + key + " ) -> { ");
            Iterator<Vertex> adjList = adjListMap.get(key).iterator();
            while(adjList.hasNext()){
                System.out.print(adjList.next().label + " ");
            }
            System.out.println("}");
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

}
