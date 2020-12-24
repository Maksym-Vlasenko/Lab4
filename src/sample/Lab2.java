package sample;

public class Lab2 {

    public double calculateY(double x) {
        double y;
        double a = 2.4;
        if (Double.compare(x, a) > 0) {
            y = x * Math.sqrt(x - a);
        } else if (Double.compare(x, a) == 0) {
            y = x * Math.sin(a * x);
        } else {
            y = Math.pow(Math.E, -(a * x)) * Math.cos(a * x);
        }
        return y;
    }

    public int countSteps(double leftBound, double rightBound, double step) {
        int stepsCount = 0;
        for (double counter = leftBound; Double.compare(counter, rightBound) <= 0; counter += step) {
            stepsCount++;
        }
        return stepsCount;
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
        for (double counter = leftBound, i = 0; Double.compare(counter, rightBound) <= 0; counter += step, i++) {
            results[(int) i] = counter;
        }
        return results;
    }

    public double findMaxY(double[] yValues) {
        double max = yValues[0];
        for (double actualYValue : yValues) {
            if (Double.compare(actualYValue, max) > 0) {
                max = actualYValue;
            }
        }
        return max;
    }

    public int findElementOrdinal(double[] yValues, double targetY) {
        int ordinal = -1;
        for (int i = 0; i < yValues.length; i++) {
            if (Double.compare(yValues[i], targetY) == 0) {
                ordinal = i;
            }
        }
        return ordinal;
    }

    public double findMinY(double[] yValues) {
        double min = yValues[0];
        for (double actualYValue : yValues) {
            if (Double.compare(actualYValue, min) < 0) {
                min = actualYValue;
            }
        }
        return min;
    }

    public double sum(double[] yValues) {
        double sum = 0;
        for (double y : yValues) {
            sum += y;
        }
        return sum;
    }
}
