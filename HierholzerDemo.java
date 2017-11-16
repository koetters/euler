import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.Multigraph;
import org.jgrapht.graph.Pseudograph;
import java.util.LinkedList;

public class HierholzerDemo {
    public static void main(String[] args) {
        UndirectedGraph<String,DefaultEdge> G = new Pseudograph<String,DefaultEdge>(DefaultEdge.class);

        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";
        String v5 = "v5";
        String v6 = "v6";
        String v7 = "v7";
        String v8 = "v8";
        String v9 = "v9";
        String v10 = "v10";
        String v11 = "v11";
        String v12 = "v12";
        String v13 = "v13";
        String v14 = "v14";
        String v15 = "v15";

        G.addVertex(v1);
        G.addVertex(v2);
        G.addVertex(v3);
        G.addVertex(v4);
        G.addVertex(v5);
        G.addVertex(v6);
        G.addVertex(v7);
        G.addVertex(v8);
        G.addVertex(v9);
        G.addVertex(v10);
        G.addVertex(v11);
        G.addVertex(v12);
        G.addVertex(v13);
        G.addVertex(v14);
        G.addVertex(v15);

        G.addEdge(v1,v2);
        G.addEdge(v2,v3);
        G.addEdge(v3,v4);
        G.addEdge(v4,v5);
        G.addEdge(v5,v1);
        G.addEdge(v1,v6);
        G.addEdge(v6,v7);
        G.addEdge(v7,v8);
        G.addEdge(v8,v1);
        G.addEdge(v7,v9);
        G.addEdge(v9,v10);
        G.addEdge(v10,v7);
        G.addEdge(v3,v11);
        G.addEdge(v11,v12);
        G.addEdge(v12,v13);
        G.addEdge(v13,v14);
        G.addEdge(v14,v15);
        G.addEdge(v15,v4);
        G.addEdge(v3,v13);
        G.addEdge(v4,v13);

        HierholzerDemo demo = new HierholzerDemo();
        System.out.println(demo.euler(G,v1));
    }

    public LinkedList<String> euler(UndirectedGraph<String,DefaultEdge> G,
                                    String start_vertex) {
        String u = start_vertex;
        LinkedList<String> base_circuit = new LinkedList<String>();
        base_circuit.addFirst(u);

        do { DefaultEdge e = G.edgesOf(u).iterator().next();
             u = G.getEdgeSource(e)!=u ? G.getEdgeSource(e) : G.getEdgeTarget(e);
             G.removeEdge(e);
             base_circuit.addLast(u); }
        while (!u.equals(start_vertex));

        LinkedList<String> euler_circuit = new LinkedList<String>();
        for(String v: base_circuit) {
            if(G.degreeOf(v)!=0) { euler_circuit.addAll(euler(G,v)); }
            else { euler_circuit.addLast(v); }}
        return euler_circuit; }

}
