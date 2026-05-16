package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class UnweightedGraph implements Graph {
    protected Map<String, List<Edge>> adjacencyList;

    public UnweightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public void addNode(String node) {
        if (!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new ArrayList<>());
        }
    }

    @Override
    public boolean containsNode(String node) {
        return adjacencyList.containsKey(node);
    }

    @Override
    public Set<String> getAllNodes() {
        return new HashSet<>(adjacencyList.keySet());
    }

    @Override
    public List<Edge> getEdges(String node) {
        return adjacencyList.get(node);
    }

    public void addDirectedEdge(String source, String target) {
        addNode(source);
        addNode(target);
        adjacencyList.get(source).add(new Edge(source, target));
    }

    public void addDirectedEdge(Edge edge) {
        addNode(edge.getSource());
        addNode(edge.getTarget());
        adjacencyList.get(edge.getSource()).add(edge);
    }

    public void addUndirectedEdge(String source, String target) {
        addDirectedEdge(source, target);
        addDirectedEdge(target, source);
    }

    public void addUndirectedEdge(Edge edge) {
        addUndirectedEdge(edge.getSource(), edge.getTarget());
        addUndirectedEdge(edge.getTarget(), edge.getSource());
    }

    @Override
    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }

    @Override
    public String toString() {
        return adjacencyList.toString();
    }
}