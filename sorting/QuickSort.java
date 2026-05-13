package sorting;

import model.Location;
import java.util.Comparator;
import java.util.List;

public class QuickSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "QuickSort";
    }

    @Override
    public void sort(List<Location> data, Comparator<Location> comparator) {
        if (data == null || data.size() <= 1) return;
        quickSort(data, 0, data.size() - 1, comparator);
    }

    private void quickSort(List<Location> data, int first, int last, Comparator<Location> comparator) {
        if (last > first) {
            int pivotIndex = partition(data, first, last, comparator);
            quickSort(data, first, pivotIndex - 1, comparator);
            quickSort(data, pivotIndex + 1, last, comparator);
        }
    }

    private int partition(List<Location> data, int first, int last, Comparator<Location> comparator) {
        Location pivot = data.get(last);
        int i = first - 1;

        for (int j = first; j < last; j++) {
            if (comparator.compare(data.get(j), pivot) <= 0) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, last);
        return i + 1;
    }

    private void swap(List<Location> data, int i, int j) {
        Location temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}
