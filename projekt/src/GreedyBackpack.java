import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyBackpack {

    public List<Items> listOfItems = new ArrayList<Items>(Arrays.asList(new Items(1, 1), new Items(2, 5), new Items(3, 9),
            new Items(2, 5), new Items(1, 2), new Items(4, 8),
            new Items(6, 13), new Items(5, 10), new Items(4, 6)));


    private List<Items> backpack = new ArrayList<>();
    private List<Items> items = listOfItems;

    public List<Items> getBackpack() {
        return backpack;
    }

    public List<Items> getItems() {
        return items;
    }

    public void greedyBackpack() {
        GreedyBackpack items = new GreedyBackpack();
        for(int i=0;i<items.getItems().toArray().length;i++){

        }
    }
}
