package stepikALGS;

import java.util.Scanner;

public class Nod {

    public static int nod(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        if (a >= b) return nod(a % b, b);
        return nod(a, b % a);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        System.out.println(nod(n, m));
    }
}
