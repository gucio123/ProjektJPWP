import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulatedAnnealingTSM {
    private int numberOfIterations;
    private float startingTemperature;
    private float temperatureRate;
    private List<List> finalList;
    private List currentPath;
    private int currentLength;
    private int bestLength;
    private List previousPath;
    private float temperature;
    public SimulatedAnnealingTSM(int numberOfIterations, float startingTemperature, float temperatureRate) {
        this.numberOfIterations = numberOfIterations;
        this.startingTemperature = startingTemperature;
        this.temperatureRate = temperatureRate;
        this.finalList = new ArrayList<>();
        TravellingSalesManRandom firstPath = new TravellingSalesManRandom("Waszyngton");
        firstPath.way();
        this.currentPath = firstPath.getFinalLIst();
    }
    public int calculatePath(List<City> lista){
        int wayLenght = 0;
        for(int i = 0 ; i < lista.toArray().length - 1; i++) {
            int neighbourDistance = (int) Math.sqrt(Math.pow(lista.get(i).getX()- lista.get(i+1).getX(), 2)
                    + Math.pow(lista.get(i).getY()- lista.get(i+1).getY(), 2));
            wayLenght += neighbourDistance;
        }
        return wayLenght;
    }
    public void swap(List<City> lista){
        Random r = new Random();
        int index1 = r.nextInt(16);
        int index2 = r.nextInt(16);
        previousPath = new ArrayList(lista);
        Collections.swap(lista, index1, index2);
        this.currentLength = this.calculatePath(lista);
    }
    public void unDoSwap(){
        currentPath = previousPath;
        this.currentLength = this.calculatePath(currentPath);
    }
    public void algorithm(){
//        SimulatedAnnealingTSM object = new SimulatedAnnealingTSM(100, 2000, (float) 0.98);
        this.bestLength = this.calculatePath(this.currentPath);
        this.currentLength = this.calculatePath(this.currentPath);
        this.temperature = this.startingTemperature;
        for(int i = 0; i < 1000000; i++){
            if(temperature > 0.01) {
                System.out.println("Droga przed swapem" + this.currentPath + " " + this.currentLength);
                this.swap(this.currentPath);
                System.out.println("Droga po swapie" + this.currentPath + " " + this.currentLength);
                if (this.currentLength < this.bestLength)
                    this.bestLength = this.currentLength;
                else if (Math.exp((this.bestLength - this.currentLength) / temperature) < Math.random())
                    this.unDoSwap();
                System.out.println("Droga po warunku odwrotu" + this.currentPath + " " + this.currentLength);
                System.out.println(i);
            }
            this.temperature *= this.temperatureRate;
            this.finalList.add(this.currentPath);
        }
    }

    public List<List> getFinalList() {
        return finalList;
    }

    public int getCurrentLength() {
        return currentLength;
    }

    public float getTemperature() {
        return temperature;
    }
}
