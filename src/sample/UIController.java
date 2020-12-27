package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UIController {
    @FXML
    private TextField leftBoundTextField;

    @FXML
    private TextField rightBoundTextField;

    @FXML
    private TextField stepTextField;

    @FXML
    private TextArea resultsTextArea;

    @FXML
    private LineChart<String, Double> chart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private final Lab2 lab2 = new Lab2();

    @FXML
    private void calculate() {
        try {
            resultsTextArea.clear();
            double leftBound = getDoubleFromTextField(leftBoundTextField);
            double rightBound = getDoubleFromTextField(rightBoundTextField);
            double step = getDoubleFromTextField(stepTextField);

            int stepsCount = lab2.countSteps(leftBound, rightBound, step);
            double[] xValues = lab2.calculateXValues(leftBound, rightBound, step);
            double[] yValues = lab2.calculateYValues(xValues);
            appendTextToTextArea(String.format("Steps count: %d%n", stepsCount));
            appendTextToTextArea(String.format("Y count: %d%n", yValues.length));
            appendTextToTextArea(String.format("X count: %d%n%n", xValues.length));

            int maxYOrdinal = lab2.findMaxElementOrdinal(yValues);
            double maxY = yValues[maxYOrdinal];
            double maxYXValue = xValues[maxYOrdinal];
            appendTextToTextArea(String.format("Max Y = %.3f%n", maxY));
            appendTextToTextArea(String.format("Max Y argument (X) = %.3f%n", maxYXValue));
            appendTextToTextArea(String.format("Max Y ordinal = %d%n%n", maxYOrdinal));

            int minYOrdinal = lab2.findMinElementOrdinal(yValues);
            double minY = yValues[minYOrdinal];
            double minYXValue = xValues[minYOrdinal];
            appendTextToTextArea(String.format("Min Y = %.3f%n", minY));
            appendTextToTextArea(String.format("Min Y argument (X) = %.3f%n", minYXValue));
            appendTextToTextArea(String.format("Min Y ordinal = %d%n%n", minYOrdinal));

            double sumY = lab2.sum(yValues);
            double averageY = sumY / yValues.length;
            appendTextToTextArea(String.format("sum(Y) = %.3f%n", sumY));
            appendTextToTextArea(String.format("avg(Y) = %.3f%n", averageY));

            buildChart(xValues, yValues);
        } catch (NumberFormatException e) {
            showErrorAlert();
        }
    }

    private void buildChart(double[] xValues, double[] yValues) {
        chart.getData().clear();
        XYChart.Series<String, Double> dataSeries = new XYChart.Series<>();
        for (int i = 0; i < xValues.length; i++) {
            String x = String.format("%.1f", xValues[i]);
            Double y = yValues[i];
            XYChart.Data<String, Double> record = new XYChart.Data<>(x, y);
            dataSeries.getData().add(record);
        }
        chart.getData().add(dataSeries);
    }

    private void appendTextToTextArea(String text) {
        resultsTextArea.appendText(text);
    }

    private double getDoubleFromTextField(TextField textField) {
        return Double.parseDouble(textField.getText());
    }

    private void showErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Input error");
        alert.setContentText("Input error - check the entered data");
        alert.showAndWait();
    }
}
