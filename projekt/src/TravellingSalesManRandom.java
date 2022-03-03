import java.util.*;

public class TravellingSalesManRandom {
    private String firstCity;
    private List<City> list = Arrays.stream(TravellingSalesman.cities).toList();
    private List<City> finalLIst = new ArrayList<City>();
    public TravellingSalesManRandom(String firstCity) {
        this.firstCity = firstCity;
    }

    public void way(){
        int index;
        for(int i = 0 ; i < list.toArray().length; i++){
            if(list.get(i).getName() == firstCity) {
                index = i;
                finalLIst.add(list.get(index));
                System.out.println(finalLIst.toString());
                list.remove(list.get(index));
            }
        }
        while(!list.isEmpty()){
            int random = new Random().nextInt(list.toArray().length);
            finalLIst.add(list.get(random));
            list.remove(list.get(random));
        }
        System.out.println(finalLIst);
    }
}
