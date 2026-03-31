package comput_methods;

import java.util.function.Function;

public class Newton {

    public static double newthonMethod(double c, double tolerance, Function<Double, Double> f, Function<Double, Double> fDeriv) {
        double x = c/2;

        for (int i = 1; i <= 100000; i++) {
            if (x <= -1.0) x = -0.99;

            double fx = f.apply(x);
            double fxDeriv = fDeriv.apply(x) ;

            double nextX = x - fx/fxDeriv;

            if (Math.abs(nextX - x) <= tolerance) {
                return nextX;
            }

            x = nextX;
        }

        return x;

    }

    public static void main(String[] args) {
        System.out.println("лень дописывать, метод с примером есть в tink.first_contest.TaskD");
    }

}