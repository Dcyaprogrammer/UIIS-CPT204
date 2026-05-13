package sorting;

import model.Location;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort implements SortingAlgorithm {

    @Override
    public String name() {
        return "MergeSort";
    }

    @Override
    public void sort(List<Location> data, Comparator<Location> comparator) {
        if (data == null || data.size() <= 1) return;
        mergeSort(data, 0, data.size() - 1, comparator);
    }

    private void mergeSort(List<Location> data, int left, int right, Comparator<Location> comparator) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(data, left, mid, comparator);
        mergeSort(data, mid + 1, right, comparator);
        merge(data, left, mid, right, comparator);
    }

    private void merge(List<Location> data, int left, int mid, int right, Comparator<Location> comparator) {
        ArrayList<Location> temp = new ArrayList<>(right - left + 1);
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (comparator.compare(data.get(i), data.get(j)) <= 0) {
                temp.add(data.get(i));
                i++;
            } else {
                temp.add(data.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(data.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(data.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            data.set(left + k, temp.get(k));
        }
    }
}
