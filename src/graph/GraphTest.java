package graph;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    /*limiting case*/
    @Test
    void Shouldreturn0(){
        Graph grafo = new Graph();
        assertEquals(0,grafo.ChromaticNumber());
    }
    @Test
    void Shouldreturn1(){
        Graph grafo = new Graph();
        assertEquals(1,grafo.ChromaticNumber());
    }

    @Test
    void Shouldreturn3() {
        Graph grafo = new Graph<Integer>();
        grafo.addVertex(1);
        grafo.addVertex(2);
        grafo.addVertex(3);
        grafo.addVertex(4);

        grafo.addEdge(1,2);
        grafo.addEdge(2,3);
        grafo.addEdge(3,1);
        grafo.addEdge(3,4);
        assertEquals(3,grafo.ChromaticNumber());
    }

    @Test
    void Shouldreturn4(){
        Graph grafo = new Graph<Integer>();
        grafo.addVertex(1);
        grafo.addVertex(2);
        grafo.addVertex(3);
        grafo.addVertex(4);

        grafo.addEdge(1,2);
        grafo.addEdge(1,3);
        grafo.addEdge(1,4);
        grafo.addEdge(2,3);
        grafo.addEdge(2,4);
        grafo.addEdge(3,4);
        assertEquals(4,grafo.ChromaticNumber());
    }
}