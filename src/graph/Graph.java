package graph;

import java.util.*;

/**
 * Clase que representa un grafo simple
 * y no dirigido creada para facilitar
 * el reto.
 *
 * @param <V> el tipo de dato que contienen los vértices del grafo
 */
public class Graph<V> {
    /**
     * Vértices del grafo
     * 
     * @param <V> el tipo de dato que contienen los vértices del grafo
     */
    private final Set<V> vertex;

    /**
     * Aristas del grafo
     * 
     * @param <V> el tipo de dato que contienen los vértices del grafo
     */
    private final Map<V, Set<V>> Edges;

    /**
     * Crea un grafo vacío
     */
    public Graph() {
        this.vertex = new HashSet<>();
        this.Edges = new HashMap<V, Set<V>>();
    }

    /**
     * Crea un grafo ya lleno
     *
     * @param vertex los ejes del grafo
     * @param edges  las aristas del grafo
     */
    public Graph(Set<V> vertex, Map<V, Set<V>> edges) {
        this.vertex = vertex;
        Edges = edges;
    }

    /**
     * Añade un nuevo vértice al grafo
     * 
     * @param vertex el nuevo vértice en cuestión
     */
    public void addVertex(V vertex) {
        this.vertex.add(vertex);
    }

    /**
     * Añade una arista de forma unidireccional
     * de un vértica a otro
     *
     * @param source      el vértice al que se asignará la arista
     * @param destination el vértice al cual apuntará la arista
     * @throws NoSuchElementException
     */
    private void addDiEdge(V source, V destination) {
        if (!(vertex.contains(source) && vertex.contains(destination))) {
            throw new NoSuchElementException("Source or destination doesn't exist in the vertex Set");
        }
        Set<V> sourceEdge = Edges.get(source);
        if (sourceEdge == null) {
            sourceEdge = new HashSet<>();
            Edges.put(source, sourceEdge);
        }
        sourceEdge.add(destination);
    }

    /**
     * Añade una arista de forma bilateral
     * (ambos vértices se conectan el uno
     * al otro)
     *
     */
    public void addEdge(V vertex1, V vertex2) {
        addDiEdge(vertex1, vertex2);
        addDiEdge(vertex2, vertex1);
    }

    /**
     * Borra una arista en sólo uno de los sentidos
     * si la relación era bilateral sólo se afectará
     * en el sentido de la fuente al destino
     *
     * @param source      el vértice al que le será removida la relación
     * @param destination es al vértice al que apuntaba dicha relación
     */
    private void deleteDiEdge(V source, V destination) {
        if (Edges.containsKey(source) && Edges.get(source).contains(destination)) {
            Edges.get(source).remove(destination);
        }
    }

    /**
     * Elimina una arista de forma bidireccional
     */
    public void deleteEdge(V vertex1, V vertex2) {
        deleteDiEdge(vertex1, vertex2);
        deleteDiEdge(vertex2, vertex1);
    }

    /**
     * Elimina un vértice y a todas las aristas relacionadas con el mismo
     */
    public void deleteVertex(V vertex) {
        if (this.vertex.contains(vertex)) {
            this.vertex.forEach(
                    vert -> deleteEdge(vert, vertex));
            this.vertex.remove(vertex);
        }
    }

    /**
     * Muestra el número de vértices que contiene el grafo
     */
    public int numerOfVertex() {
        return this.vertex.size();
    }

    /**
     * Muestra el número de aristas que contiene el grafo
     */
    public int numberofEdges() {
        int count = 0;
        for (Set<V> nei : Edges.values()) {
            count = nei.size();
        }
        return count / 2;
    }

    /**
     * Muestra las conexiones de un vértice dado
     *
     * @param vertex el vértice del que se quieren ver las aristas
     * @return un Set con todos los vértcices a donde está conectado
     */
    public Set<V> connections(V vertex) {
        return Edges.getOrDefault(vertex, new HashSet<>());
    }

    /**
     * Muestra el grado de un vértice
     *
     * @param vertex el vértice en cuestión
     * @return la cantidad de vértices a los que está conectado
     */
    public int degree(V vertex) {
        return connections(vertex).size();
    }

    /**
     * Método a implementar, tiene que calcular el número cromatico del grafo.
     * El número cromático de un grafo es la cantidad mínima de "colores"
     * (pueden ser cualquier tipo de dato que sea diferenciable) que pueden tener
     * los vértices de un grafo de manera tal que dos vértices adyacentes no
     * compartan el mimso color.
     *
     * @return el número cromático del grafo
     */
    public int ChromaticNumber() {
        throw new RuntimeException("A implementar");
    }

}
