package stepikALGS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonachi {

    //classic fib
    public static int fib(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    //last digit of fib
    public static int fib2(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10;
        }

        return arr[n];
    }

    //rest fib for m
    public static Long fib3(Long n, int m) {
        List<Long> arr = new ArrayList<>();
        arr.add(0l);
        arr.add(1l);

        long prev2 = 0;
        long prev1 = 1;
        long curr = 1;

        while (true) {
            curr = (prev2 + prev1) % m;
            prev2 = prev1;
            prev1 = curr;
            arr.add(curr);

            if (prev2 == 0 && prev1 == 1 && arr.size() > 2) {
                arr.remove(arr.size() - 1);
                arr.remove(arr.size() - 1);
                break;
            }
        }

        int l = arr.size();
        int indx = (int)(n % l);

        return arr.get(indx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        int m = sc.nextInt();

        System.out.println(fib3(n, m));
    }

}
