import java.util.ArrayList;
import java.util.Random;

public class GeneratingData {

    Simulation simulation;
    double numOfParticles = Math.pow(10, 6);
    ArrayList<Double> xPositions = new ArrayList<>();
    ArrayList<Double> yPositions = new ArrayList<>();
    public GeneratingData(Simulation simulation) {
        this.simulation = simulation;
        plotXPositions();
        plotYPositions();
        normalisingLengthOfDataArrays();
    }

    private void plotXPositions () {
        for (int i = 0; i <= numOfParticles; i++){
            double x_position = simulation.calculateMonteCarloSimulation();
            if (x_position != 0){
                xPositions.add(x_position);
            }
        }
    }

    private void plotYPositions () {
        Random rand = new Random();
        for (int i = 0; i <= numOfParticles; i++){
            yPositions.add(rand.nextDouble(1));
        }
    }
    private void normalisingLengthOfDataArrays() {
        int lengthOfXPositionsWithIndex = this.xPositions.size();
        int lengthOfYPositionsWithIndex = this.yPositions.size()-1;
        for (int i=lengthOfYPositionsWithIndex; i >= lengthOfXPositionsWithIndex; i--) {
            this.yPositions.remove(i);
        }
    }

    public ArrayList<Double> getXPositions(){
        return xPositions;
    }

    public ArrayList<Double> getYPositions(){
        return yPositions;
    }

}
