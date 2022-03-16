import java.util.*;

public class TravellingSalesManRandom {
    private String firstCity;
    private List<City> list = TravellingSalesman.cities;
    private List<City> finalLIst = new ArrayList<City>();
    public TravellingSalesManRandom(String firstCity) {
        this.firstCity = firstCity;
    }
    private int wayLenght = 0;
    public void way(){
        int index;
        for(int i = 0 ; i < list.toArray().length; i++){
            if(list.get(i).getName().equals(firstCity)) {
                index = i;
                finalLIst.add(list.get(index));
                list.remove(list.get(index));
                break;
            }
        }
        while(!list.isEmpty()){
            int random = new Random().nextInt(list.toArray().length);
            finalLIst.add(list.get(random));
            list.remove(list.get(random));
        }

        for(int i = 0 ; i < finalLIst.toArray().length - 1; i++) {
            System.out.println(finalLIst.get(i).getName());
            int neighbourDistance = (int) Math.sqrt(Math.pow(finalLIst.get(0).getX()- finalLIst.get(i+1).getX(), 2)
                    + Math.pow(finalLIst.get(0).getY()- finalLIst.get(i+1).getY(), 2));
            wayLenght += neighbourDistance;
        }
    }

    public int getWayLenght() {
        return wayLenght;
    }

    public List<City> getFinalLIst() {
        return finalLIst;
    }
}
