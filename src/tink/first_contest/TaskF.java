package tink.first_contest;

import java.util.Scanner;

public class TaskF {

    private static long inversionCount = 0;

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0, k = 0;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                result[k++] = left[l++];
            }  else {
                inversionCount += (left.length - l);
                result[k++] = right[r++];
            }
        }

        while (l < left.length) result[k++] = left[l++];
        while (r < right.length) result[k++] = right[r++];

        return result;
    }

    public static int[] sort(int[] array) {
        if (array == null || array.length < 2) return array;

        int mid = array.length / 2;

        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr =  new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        arr = sort(arr);

        System.out.println(inversionCount);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
