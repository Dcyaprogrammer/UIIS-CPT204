package model;

public class WeightedEdge extends Edge {
    private int weight;

    public WeightedEdge(String source, String target, int weight) {
        super(source, target);
        this.weight = weight;
        if (weight < 0)
        {
            throw new IllegalArgumentException("Weight must be non-negative");
        }
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        return super.toString() + " " + weight;
    }

}
