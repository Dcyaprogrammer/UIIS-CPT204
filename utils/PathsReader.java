package utils;

import model.WeightedGraph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PathsReader implements DataReader<WeightedGraph> {

    @Override
    public WeightedGraph read(String filePath) throws IOException {
        WeightedGraph graph = new WeightedGraph();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (isHeader(line)) {
                    continue;
                }
                String[] parts = line.split(",");

                if (parts.length != 3) {
                    throw new IOException("Invalid line format at line " + lineNumber);
                }

                String source = parts[0].trim();
                String target = parts[1].trim();
                int weight;

                try {
                    weight = Integer.parseInt(parts[2].trim());
                } catch (NumberFormatException e) {
                    throw new IOException("Invalid weight format at line " + lineNumber);
                }

                graph.addWeightedUndirectedEdge(source, target, weight);
            }
        }
        return graph;
    }

    private boolean isHeader(String line) {
        String lowerLine = line.toLowerCase();
        return lowerLine.contains("from_location") || lowerLine.contains("to_location") || lowerLine.contains("weight");
    }
    
}
