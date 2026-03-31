package comput_methods;

import java.util.function.Function;

public class Bisection {

    public static double solve(
            Function<Double, Double> function,
            double a, double b,
            double tolerance,
            int maxIter
    ) throws Exception {
        double fa = function.apply(a);
        double fb = function.apply(b);

        if (fa * fb >= 0) {
            throw new Exception("Функция должна иметь разные знаки на концах отрезка");
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

}
