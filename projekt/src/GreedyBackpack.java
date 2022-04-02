import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyBackpack {

    public List<Items> listOfItems = new ArrayList<Items>(Arrays.asList(new Items("Skarpety",1, 2), new Items("taśmy",2, 5), new Items("Tank-top",2, 8),
            new Items("Pas",2, 5), new Items("rekawice",1, 1), new Items("Białko",4, 8),
            new Items("Trenbolon",6, 18), new Items("Kreatyna",5, 10), new Items("tygrys bubblegum",4, 6)));


    private List<Items> backpack = new ArrayList<>();
    private List<Items> items = listOfItems;
    private double wage;
    private int bkpkMaxCapacity = 20;
    private int bkpkCapacity = 0;
    private int temp = 0;

    public List<Items> getBackpack() {
        return backpack;
    }

    public List<Items> getItems() {
        return items;
    }

    public void greedyBackpack() {
        GreedyBackpack items = new GreedyBackpack();
        for (int k = 0; k < items.getItems().toArray().length; k++) {
            double maxi = 0;
            int index = 0;
            int bkpkMaxCapacity = 20;
            for (int i = 0; i < items.getItems().toArray().length; i++) {
                if(items.backpack.contains(items.getItems().get(i))){
                    continue;
                }
                wage = items.getItems().get(i).getValue() / items.getItems().get(i).getWeight();
                if (wage > maxi) {
                    maxi = wage;
                    index = i;
                }
                if (i == items.getItems().toArray().length - 1) {
                    if (bkpkCapacity + items.getItems().get(i).getWeight() < 20) {
                        items.backpack.add(items.getItems().get(index));
                        bkpkCapacity += items.backpack.get(temp).getWeight();
                        temp++;
                    }
                }
            }
        }
        for(int m=0;m <items.backpack.toArray().length;m++){
            System.out.println(items.backpack.get(m).getName());
        }
    }
    public static void main(String[] args) {
        GreedyBackpack backpack = new GreedyBackpack();
        backpack.greedyBackpack();
    }
}
