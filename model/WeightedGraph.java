package model;

public class WeightedGraph extends UnweightedGraph {
    
    public WeightedGraph() {
        super();
    }

    public void addWeightedDirectedEdge(String source, String target, int weight) {
        validateWeight(weight);
        addNode(source);
        addNode(target);
        adjacencyList.get(source).add(new WeightedEdge(source, target, weight));
    }

    public void addWeightedDirectedEdge(WeightedEdge edge) {
        addWeightedDirectedEdge(edge.getSource(), edge.getTarget(), edge.getWeight());
    }

    public void addWeightedUndirectedEdge(String source, String target, int weight) {
        validateWeight(weight);
        addWeightedDirectedEdge(source, target, weight);
        addWeightedDirectedEdge(target, source, weight);
    }

    public void addWeightedUndirectedEdge(WeightedEdge edge) {
        addWeightedUndirectedEdge(edge.getSource(), edge.getTarget(), edge.getWeight());
    }

    @Override
    public void addDirectedEdge(String source, String target) {
        throw new UnsupportedOperationException(
            "Use addWeightedDirectedEdge() for WeightedGraph."
        );
    }

    @Override
    public void addUndirectedEdge(String source, String target) {
        throw new UnsupportedOperationException(
            "Use addWeightedUndirectedEdge() for WeightedGraph."
        );
    }

    private void validateWeight(int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight must be non-negative");
        }
    }
}
