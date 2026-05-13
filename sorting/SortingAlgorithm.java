package sorting;
import java.util.Comparator;
import java.util.List;
import model.Location;

public interface  SortingAlgorithm {
    String name();
    void sort(List<Location> data, Comparator<Location> comparator);
    
}
