import java.util.ArrayList;
import java.util.Random;

public class GeneratingData {

    Simulation simulation;
    double numOfParticles = Math.pow(10, 6);
    ArrayList<Double> x_positions = new ArrayList<>();
    ArrayList<Double> y_positions = new ArrayList<>();
    public GeneratingData(Simulation simulation) {
        this.simulation = simulation;
        plotXPositions();
        plotYPositions();
    }

    private void plotXPositions () {
        for (int i = 0; i <= numOfParticles; i++){
            double x_position = simulation.calculateMonteCarloSimulation();
            if (x_position != 0){
                x_positions.add(x_position);
            }
        }
    }

    private void plotYPositions () {
        Random rand = new Random();
        for (int i = 0; i <= numOfParticles; i++){
            y_positions.add(rand.nextDouble(1));
        }
    }

    public ArrayList<Double> getX_positions(){
        return x_positions;
    }

    public ArrayList<Double> getY_positions(){
        return y_positions;
    }

}
