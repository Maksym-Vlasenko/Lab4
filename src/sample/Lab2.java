package sample;

public class Lab2 {
    /*public static void main(String[] args) {
        Lab2 lab2 = new Lab2();
        double leftBound = 1;
        double rightBound = 5;
        double step = 0.01;
        System.out.printf("Left bound = %.0f%nRight bound = %.0f%nStep = %.2f%n%n", leftBound, rightBound, step);

        double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
        double[] yValues = lab2.calculateYValues(xValues);
        System.out.println("X count: " + xValues.length);
        System.out.println("Y count: " + yValues.length);
        System.out.println();

        double maxY = lab2.findMaxY(yValues);
        int maxYOrdinal = lab2.findElementOrdinal(yValues, maxY);
        System.out.printf("Max Y = %.3f%n", maxY);
        System.out.println("Max Y ordinal = " + maxYOrdinal);
        System.out.println();

        double minY = lab2.findMinY(yValues);
        int minYOrdinal = lab2.findElementOrdinal(yValues, minY);
        System.out.printf("Min Y = %.3f%n", minY);
        System.out.println("Min Y ordinal = " + minYOrdinal);
        System.out.println();

        double sumY = lab2.sum(yValues);
        double averageY = sumY / yValues.length;
        System.out.printf("Sum Y = %.3f%n", sumY);
        System.out.printf("Average Y = %.3f%n", averageY);
    }*/

    public double calculateY(double x) {
        double y;
        double a = 2.4;
        if (x > a) {
            y = x * Math.sqrt(x - a);
        } else if (x == a) {
            y = x * Math.sin(a * x);
        } else {
            y = Math.pow(Math.E, -(a * x)) * Math.cos(a * x);
        }
        return y;
    }

    public int countSteps(double leftBound, double rightBound, double step) {
        int stepsCount = 0;
        for (double counter = leftBound; counter <= rightBound; counter += step) {
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
        for (double counter = leftBound, i = 0; counter <= rightBound; counter += step, i++) {
            results[(int) i] = counter;
        }
        return results;
    }

    public double findMaxY(double[] yValues) {
        double max = yValues[0];
        for (double actualYValue : yValues) {
            if (actualYValue > max) {
                max = actualYValue;
            }
        }
        return max;
    }

    public int findElementOrdinal(double[] yValues, double targetY) {
        int ordinal = -1;
        for (int i = 0; i < yValues.length; i++) {
            if (yValues[i] == targetY) {
                ordinal = i;
            }
        }
        return ordinal;
    }

    public double findMinY(double[] yValues) {
        double min = yValues[0];
        for (double actualYValue : yValues) {
            if (actualYValue < min) {
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
