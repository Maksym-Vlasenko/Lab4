package sample;

public class Lab2 {

    public double calculateY(double x) {
        double y;
        double a = 2.4;
        if (DoubleUtils.greaterThan(x, a)) {
            y = x * Math.sqrt(x - a);
        } else if (DoubleUtils.equals(x, a)) {
            y = x * Math.sin(a * x);
        } else {
            y = Math.exp(-(a * x)) * Math.cos(a * x);
        }
        return y;
    }

    public int countSteps(double leftBound, double rightBound, double step) {
        return (int) ((rightBound - leftBound) / step) + 1;
    }

    public double[] calculateYValues(double[] xValues) {
        double[] yValues = new double[xValues.length];
        for (int i = 0; i < xValues.length; i++) {
            yValues[i] = calculateY(xValues[i]);
        }
        return yValues;
    }

    public double[] calculateXValues(double leftBound, double rightBound, double step) {
        int stepsCount = countSteps(leftBound, rightBound, step);
        double[] results = new double[stepsCount];
        for (int i = 0; i < stepsCount; i++) {
            results[i] = leftBound + (i * step);
        }
        return results;
    }

    public int findMaxElementOrdinal(double[] yValues) {
        double max = yValues[0];
        int maxElementOrdinal = 0;
        for (int i = 0; i < yValues.length; i++) {
            double actualYValue = yValues[i];
            if (DoubleUtils.greaterThan(actualYValue, max)) {
                max = actualYValue;
                maxElementOrdinal = i;
            }
        }
        return maxElementOrdinal;
    }

    public int findMinElementOrdinal(double[] yValues) {
        double min = yValues[0];
        int minElementOrdinal = 0;
        for (int i = 0; i < yValues.length; i++) {
            double actualYValue = yValues[i];
            if (DoubleUtils.lessThan(actualYValue, min)) {
                min = actualYValue;
                minElementOrdinal = i;
            }
        }
        return minElementOrdinal;
    }

    public double sum(double[] yValues) {
        double sum = 0;
        for (double y : yValues) {
            sum += y;
        }
        return sum;
    }
}
