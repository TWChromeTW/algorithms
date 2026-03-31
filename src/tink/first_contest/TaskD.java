package tink.first_contest;

import java.util.Scanner;
import java.util.Locale;

public class TaskD {

    public static double newthonMethod(double c) {
//        Scanner in = new Scanner(System.in);
//        double c =  in.nextDouble();
        double x = c/2;
        double tolerance = 1e-6;

        //f = x^2 + (x+1)^0.5 - c
        //f` = 2x + 1/(2(x+1)^0.5)

        for (int i = 1; i <= 100000; i++) {
            if (x <= -1.0) x = -0.99;

            double fx = x*x + Math.sqrt(x+1) - c;
            double fxx = 2*x + 1/(2*Math.sqrt(x+1));

            double nextX = x - fx/fxx;

            if (Math.abs(nextX - x) <= tolerance) {
                return nextX;
            }

            x = nextX;
        }

        return x;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);;
//        double c = scan.nextDouble();
//        double result = newthonMethod(c);
//        System.out.println(result);

        if (scan.hasNextDouble()) {
            double c = scan.nextDouble();
            double result = newthonMethod(c);
            // Вывод с большой точностью (часто требуется в задачах)
            System.out.printf(Locale.US, "%.20f\n", result);
        }
    }

}
