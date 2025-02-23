package graph;

import java.util.*;

public class Graph<V>{
    private final Set<V> vertex;
    private final Map<V, Set<V>> Edges;
    public Graph(){
        this.vertex=new HashSet<>();
        this.Edges=new HashMap<V,Set<V>>();
    }
    public Graph(Set<V> vertex, Map<V, Set<V>> edges) {
        this.vertex = vertex;
        Edges = edges;
    }
    public void addVertex(V vertex){
        this.vertex.add(vertex);
    }
    private void addDiEdge(V source, V destination){
        if(!(vertex.contains(source) && vertex.contains(destination))){
            throw new NoSuchElementException("Source or destination doesn't exist in the vertex Set");
        }
        Set<V> sourceEdge = Edges.get(source);
        if(sourceEdge==null){
            sourceEdge = new HashSet<>();
            Edges.put(source,sourceEdge);
        }
        sourceEdge.add(destination);
    }
    public void addEdge(V vertex1, V vertex2){
        addDiEdge(vertex1,vertex2);
        addDiEdge(vertex2,vertex1);
    }

    private void deleteDiEdge(V source, V destination) {
        if(Edges.containsKey(source) && Edges.get(source).contains(destination)){
            Edges.get(source).remove(destination);
        }
    }

    public void deleteEdge(V vertex1, V vertex2) {
        deleteDiEdge(vertex1,vertex2);
        deleteDiEdge(vertex2,vertex1);
    }

    public void deleteVertex(V vertex) {
        if(this.vertex.contains(vertex)){
            this.vertex.forEach(
                    vert->deleteEdge(vert,vertex)
            );
            this.vertex.remove(vertex);
        }
    }

    public int numerOfVertex(){
        return this.vertex.size();
    }

    public int numberofEdges(){
        int count = 0;
        for(Set<V> nei: Edges.values()){
            count = nei.size();
        }
        return count;
    }
    public Set<V> successor(V vertex){
        return Edges.getOrDefault(vertex,new HashSet<>());
    }
    public int degree(V vertex) {
        return successor(vertex).size();
    }


    /**
     * Clase a implementar, tiene que calcular el número cromatico del grafo
     */
    public int ChromaticNumber(){
        throw new RuntimeException("A implementar");
    }

    public static void main(String [] args){
        Graph grafo = new Graph<Integer>();
        grafo.addVertex(1);
        grafo.addVertex(2);
        grafo.addVertex(3);
        grafo.addVertex(4);

        grafo.addEdge(1,2);
        grafo.addEdge(2,3);
        grafo.addEdge(3,1);
        grafo.addEdge(3,4);

        System.out.println(grafo.ChromaticNumber());//debería dar 3
    }
}
