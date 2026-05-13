package sorting;

import model.Location;
import java.util.Comparator;
import java.util.List;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public String name() {
        return "Bubble";
    }

    @Override
    public void sort(List<Location> data, Comparator<Location> comparator) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(data.get(j), data.get(j + 1)) > 0) {
                    Location tmp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, tmp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
