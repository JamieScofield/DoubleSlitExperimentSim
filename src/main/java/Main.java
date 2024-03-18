import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        GeneratingData plottingData = new GeneratingData(new Simulation());
        ArrayList<Double> x_positions = plottingData.getX_positions();
        for (int i=0; i <= x_positions.size()-1; i++){
            System.out.println(x_positions.get(i));
        }
    }
}
