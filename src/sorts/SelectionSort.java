package sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {

    private static int findSmallest(List<Integer> arr) {
        int smallest = arr.get(0);
        int smallest_index = 0;

        for (int i = 1; i < arr.size(); i++) {
            if (smallest > arr.get(i)) {
                smallest = arr.get(i);
                smallest_index = i;
            }
        }

        return smallest_index;
    }

    public static int[] selectionSort(int[] arr) {

        List<Integer> list = new ArrayList<Integer>();
        for (int num : arr) list.add(num);

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int smallest_index = findSmallest(list);
            result[i] = list.remove(smallest_index);
        }

        return result;
    }

    static void main() {
        int[] arr = {5, 2, 4, 3, 1, 10, 6, 8, 7, 9};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

}
