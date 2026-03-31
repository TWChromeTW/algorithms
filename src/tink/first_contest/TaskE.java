package tink.first_contest;

import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;

public class TaskE {

    private static double a;
    private static double b;
    private static double c;
    private static double d;

    public static void help() {
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        d = sc.nextDouble();
    }

    public static double bisection(
            Function<Double, Double> function,
            double a, double b,
            double tolerance,
            int maxIter
    ){
        double fa = function.apply(a);
        double fb = function.apply(b);

        if (fa * fb >= 0) {
            return -9999.0;
        }

        double c = a;

        for (int i = 0; i < maxIter; i++) {
            c = a + (b - a) / 2.0;
            double fc = function.apply(c);

            if (Math.abs(fc) < 1e-15 || (b - a) / 2.0 < tolerance) {
                return c;
            }

            if (fc * fa < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }

        return c;
    }

    public static double func(double x) {
        return a*Math.pow(x,3) + b*Math.pow(x,2) + c*x + d;
    }

    public static void main(String[] args) {
        help();
        double result = bisection(TaskE::func, -1000.0, 1000.0, 1e-20, 1000);

        System.out.printf(Locale.US, "%.10f\n",result);
    }

}
