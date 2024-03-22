import java.util.Random;

public class Simulation {
    // for an electron at a rest mass of 0.511 MeV with a KE of 1eV
    private double electronMass = 9.1*Math.pow(10, -31);
    private double electronVelocity = 5*Math.pow(10, 5);
    private double deBrogieWavelength;
    private double slitDistance = 600*Math.pow(10, -6);
    private int distanceToScreen = 10;
    private double slitWidth = 150*Math.pow(10, -6);

    public double calculateMonteCarloSimulation() {
        deBrogieWavelength = 6.62*Math.pow(10, -34) / (electronMass * electronVelocity);
        double screenLeftLimit = -0.001;
        double screenRightLimit = 0.001;
        double screenResult = screenLeftLimit + new Random().nextDouble() * (screenRightLimit - screenLeftLimit);
        double probability = calculateDiffractionProbability(screenResult);
        double testProb = Math.random();

        if (probability >= testProb){
            return screenResult;
        }

        return 0;
    }

    private double calculateDiffractionProbability(double x) {
        double c = (Math.PI * slitDistance) / (deBrogieWavelength * distanceToScreen);
        double k = (Math.PI * slitWidth) / (deBrogieWavelength * distanceToScreen);

        return (Math.pow(Math.cos(c), 2)) * (Math.pow((Math.sin(k * x) / (k * x)), 2));
    }

}
