package model;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// only reachable nodes are in distances
public class SingleSourceShortestPathTree {
    private String source;
    private Map<String, Integer> distances;
    private Map<String, String> predecessors;
    private Set<String> allNodes;

    public SingleSourceShortestPathTree() {}
    
    public SingleSourceShortestPathTree(
            String source,
            Map<String, Integer> distances,
            Map<String, String> predecessors,
            Set<String> allNodes
    ) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("Source must be non-empty");
        }
        if (distances == null || distances.isEmpty()) {
            throw new IllegalArgumentException("Distances must be non-empty");
        }
        if (predecessors == null || predecessors.isEmpty()) {
            throw new IllegalArgumentException("Predecessors must be non-empty");
        }
        if (allNodes == null || allNodes.isEmpty()) {
            throw new IllegalArgumentException(" tree must be non-empty");
        }

        this.source = source;
        this.distances = new HashMap<>(distances);
        this.predecessors = new HashMap<>(predecessors);
        this.allNodes = new HashSet<>(allNodes);
    }

    public String getSource() {
        return source;
    }

    public Set<String> getAllNodes() {
        return allNodes;
    }

    public boolean containsNode(String node) {
        return allNodes.contains(node);
    }

    public boolean isReachable(String target) {
        return distances.containsKey(target);
    }

    public int getDistanceTo(String target) {
        if (!isReachable(target)) {
            throw new IllegalArgumentException("Target is not reachable");
        }
        return distances.get(target);
    }

    public PathResult getPathTo(String target) {
        if (!isReachable(target)) {
            return PathResult.getUnreachableResult();
        }

        if (source.equals(target)) {
            return PathResult.getSelfResult(target);
        }

        List<String> path = reconstructPath(target);


        return PathResult.getReachableResult(path, getDistanceTo(target));
    }

    private List<String> reconstructPath(String target) {
        List<String> path = new ArrayList<>();

        String current = target;

        while (current != null) {
            path.add(current);

            if (current.equals(source)) {
                break;
            }

            current = predecessors.get(current);
        }

        Collections.reverse(path);

        if (path.isEmpty() || !path.contains(source)) {
            throw new IllegalArgumentException("Path is not valid");
        }

        return path;
    }
    
    
}
