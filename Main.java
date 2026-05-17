import utils.DataReader;
import utils.PathsReader;
import model.WeightedGraph;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DataReader<WeightedGraph> reader = new PathsReader();

        try {
            WeightedGraph graph = reader.read("Datasets/paths.csv");

            System.out.println("Graph loaded successfully.");
            System.out.println("Is empty: " + graph.isEmpty());
            System.out.println("Contains L0001: " + graph.containsNode("L0001"));
            System.out.println(graph.getEdges("L0001"));

        } catch (IOException e) {
            System.out.println("Failed to read paths.csv: " + e.getMessage());
        }
    }
}