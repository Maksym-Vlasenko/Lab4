package sample;

public class DoubleUtils {
    private static final double EPS = 0.000001;

    public static boolean equals(double a, double b) {
        return Math.abs(a - b) < EPS;
    }

    public static boolean greaterOrEqual(double a, double b) {
        return greaterThan(a, b) || equals(a, b);
    }

    public static boolean lessOrEqual(double a, double b) {
        return lessThan(a, b) || equals(a, b);
    }

    public static boolean greaterThan(double a, double b) {
        return a - b > EPS;
    }

    public static boolean lessThan(double a, double b) {
        return a - b < EPS;
    }
}
