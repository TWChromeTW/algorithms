package tink.first_contest;

import java.util.Scanner;

public class TaskB {

    public static int binary_search(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = arr[mid];

            if (guess ==  item) {
                return guess;
            }
            else if (guess > item) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        if (high < 0) return arr[0];
        if (low >= arr.length) return arr[arr.length - 1];

        if (Math.abs(arr[low] - item) < Math.abs(arr[high] - item)) {
            return arr[low];
        }
        return arr[high];
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = binary_search(arr, sc.nextInt());
        }

        for (int i = 0; i < k; i++) System.out.println(res[i]);

    }

}
