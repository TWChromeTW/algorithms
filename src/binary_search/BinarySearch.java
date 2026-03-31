package binary_search;

public class BinarySearch {

    public static int binary_search(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = arr[mid];
            
            if (guess ==  item) {
                return mid;
            }
            else if (guess > item) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

    static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binary_search(arr, 6));
        System.out.println(binary_search(arr, 10));
    }

}
