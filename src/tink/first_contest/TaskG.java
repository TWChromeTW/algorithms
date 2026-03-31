package tink.first_contest;

import java.util.Scanner;

public class TaskG {

    public static int qsort(int[] arr, int left, int right) {
        if (left >= right) return -1;

        int res = 0;
        int q = arr[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i] < q) {
                i++;
                res++;
            }
            res++;

            while (arr[j] > q) {
                j--;
                res++;
            }
            res++;

            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        if (left < j) {
            res += qsort(arr, left, j);
        }
        if (i < right) {
            res += qsort(arr, i, right);
        }

        return res;
    }

    public static void build1(int[] arr, int l, int r) {
        if (l >= r) return;

        int temp = arr[(l + r) / 2];
        arr[(l + r) / 2] = arr[l];
        arr[l] = temp;

        build1(arr, l + 1, r);
    }

    public static void build2(int[] arr, int l, int r) {
        if (l >= r) return;

        int temp = arr[(l + r) / 2];
        arr[(l + r) / 2] = arr[r];
        arr[r] = temp;

        build2(arr, l, r - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = i + 1;
            arr2[i] = i + 1;
        }

        build1(arr1, 0, n - 1);
        build2(arr2, 0, n - 1);

        int gues1 = qsort(arr1, 0, n - 1);
        int gues2 = qsort(arr2, 0, n - 1);

        System.out.println(gues1);
        System.out.println(gues2);

        int gues3 = qsort(arr1, 0, n - 1);
        System.out.println(gues3);

//        if (gues1 > gues2) {
//            build1(arr1, 0, n - 1);
//            for (int i = 0; i < n; i++) System.out.print(arr1[i] + " ");
//        }
//        else {
//            build2(arr1, 0, n - 1);
//            for (int i = 0; i < n; i++) System.out.print(arr1[i] + " ");
//        }
    }

}
