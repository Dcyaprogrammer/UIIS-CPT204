package model;

import java.util.List;
import java.util.ArrayList;

public class PathResult {
    private List<String> path;
    private int totalCost;
    private boolean reachable;

    private PathResult(List<String> path, int totalCost, boolean reachable) {
        if (path == null) {
            throw new IllegalArgumentException("Path cannot be null");
        }

        if (reachable && totalCost < 0) {
            throw new IllegalArgumentException("Total cost must be non-negative");
        }
        
        this.path = path;
        this.totalCost = totalCost;
        this.reachable = reachable;
    }

    public static PathResult getReachableResult(List<String> path, int totalCost) {
        return new PathResult(path, totalCost, true);
    }

    public static PathResult getUnreachableResult() {
        return new PathResult(null, 0, false);
    }

    public static PathResult getSelfResult(String node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        
        List<String> path = new ArrayList<>();
        path.add(node);
        return new PathResult(path, 0, true);
    }

    public List<String> getPath() {
        return path;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isReachable() {
        return reachable;
    }

    public String getPathString() {
        if (!reachable) {
            return "Unreachable";
        }
        
        return String.join(" -> ", path);
    }

    @Override
    public String toString() {
        if (!reachable) {
            return "This path is unreachable";
        }
        return "Path Result: {" + getPathString() + "} (Cost: " + totalCost + ")";
    }


}