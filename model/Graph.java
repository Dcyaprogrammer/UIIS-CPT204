package model;

import java.util.List;
import java.util.Set;


public interface Graph {
    void addNode(String node);

    boolean containsNode(String node);

    Set<String> getAllNodes();
    List<Edge> getEdges(String node);

    boolean isEmpty();

}

// public class Graph {
//     private Map<String, List<Edge>> adjacencyList;
    
//     public Graph() {
//         this.adjacencyList = new HashMap<>();
//     }

//     public void addNode(String node) {
//         if (!adjacencyList.containsKey(node)) {
//             adjacencyList.put(node, new ArrayList<>());
//         }
//     }

//     public void addEdge(String source, String target, int weight) {
//         if (weight < 0)
//         {
//             throw new IllegalArgumentException("Weight must be non-negative");
//         }

//         addNode(source);
//         addNode(target);

//         // add edges with both directions
//         adjacencyList.get(source).add(new WeightedEdge(source, target, weight));
//         adjacencyList.get(target).add(new WeightedEdge(target, source, weight));
//     }

//     public void addEdge(WeightedEdge edge) {
//         addEdge(edge.getSource(), edge.getTarget(), edge.getWeight());
//     }

//     @Override
//     public String toString() {
//         return adjacencyList.toString();
//     }
        
// }
