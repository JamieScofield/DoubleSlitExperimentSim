import java.util.Random;

public class Simulation {
    // for an electron at a rest mass of 0.511 MeV with a KE of 1eV
    private double deBrogieWavelength = Math.pow(1.23, -9);
    private double slitDistance = Math.pow(600, -6);
    private int distanceToScreen = 10;
    private double slitWidth = Math.pow(150, -6);

    public double calculateMonteCarloSimulation() {
        Random rand = new Random();
        double result = rand.nextDouble(0.003) - 0.001;
        double probability = calculateDiffractionProbability(result);
        double testProb = rand.nextDouble(1);

        if (probability >= testProb){
            return probability;
        }

        return 0;
    }

    private double calculateDiffractionProbability(double x) {
        double c = (Math.PI * slitDistance) / (deBrogieWavelength * distanceToScreen);
        double k = (Math.PI * slitWidth) / (deBrogieWavelength * distanceToScreen);

        return Math.pow(Math.cos(c), 2) * (Math.sin(k * x) / Math.pow((k * x), 2));
    }

}
