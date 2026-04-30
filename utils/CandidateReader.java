package utils;
import model.Location;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

public class CandidateReader implements DataReader<List<Location>> {
    
    @Override
    public List<Location> read(String filePath) throws IOException {
        List<Location> locations = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        boolean isFirstLine = true;

        while ((line = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                if (line.toLowerCase().contains("location_id")) {
                    continue;
                }
            }

            String[] features = line.split(",");
            String location_id = features[0].trim();
            int priority_score = Integer.parseInt(features[1].trim());
            
            Location location = new Location(location_id, priority_score);
            locations.add(location);
        }
        reader.close();

        return locations;
    }
}
