import java.util.ArrayList;
import java.util.List;

public class GeneticTravellingSalesman {
    private List<List> list = new ArrayList<>();

    public void firstPopulation(){
        for(int i = 0; i <100; i++) {
            TravellingSalesManRandom randomway = new TravellingSalesManRandom("Waszyngton");
            randomway.way();
            list.add(randomway.getFinalLIst());
        }
        System.out.println(list);
    }

    public List<List> getList() {
        return list;
    }
}
