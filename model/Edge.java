package model;

public class Edge {
    private String source;
    private String target;

    public Edge(String source, String target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public String toString(){
        return source + "->" + target;
    }
    
    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }
} 
