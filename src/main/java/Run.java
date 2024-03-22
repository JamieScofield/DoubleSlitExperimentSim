import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Run extends Application {

    private ArrayList<Double> xPositions;
    private ArrayList<Double> yPositions;
    @Override
    public void start(Stage stage) throws Exception {
        GeneratingData data = new GeneratingData(new Simulation());
        this.xPositions = data.getXPositions();
        this.yPositions = data.getYPositions();

        stage.setTitle("Double Slit experiment Plot");
        NumberAxis xAxis = new NumberAxis(-0.001, 0.001, 0.0005);
        NumberAxis yAxis = new NumberAxis(0, 1, 0.05);
        ScatterChart<Number, Number> plot = new ScatterChart<>(xAxis, yAxis);
        xAxis.setLabel("location on the screen on the x axis");
        yAxis.setLabel("Location on the screen on the y axis");
        plot.setTitle("Double Slit Experiment Plot");

        XYChart.Series series1 = new XYChart.Series();

        for(int i=0; i <= this.xPositions.size()-1; i++) {
            series1.getData().add(new XYChart.Data(this.xPositions.get(i), this.yPositions.get(i)));

        }

        plot.getData().addAll(series1);

        Scene scene = new Scene(plot, 700, 700);
        stage.setScene(scene);
        stage.show();
    }
}

