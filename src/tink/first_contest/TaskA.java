package tink.first_contest;

import java.util.Scanner;

public class TaskA {

    public static boolean binary_search(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = arr[mid];

            if (guess ==  item) {
                return true;
            }
            else if (guess > item) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return false;
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, k, min, max;
        n = sc.nextInt();
        k = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        min = arr[0];
        max = arr[n-1];

        String res[] = new String[k];

        for (int i = 0; i < k; i++) {
            int q = sc.nextInt();
            if (q > max | q < min){
                res[i] = "NO";
            }
            else {
                if (binary_search(arr, q)) {
                    res[i] = "YES";
                }
                else  {
                    res[i] = "NO";;
                }
            }
        }

        for (int i = 0; i < k; i++) System.out.println(res[i]);
    }

}
