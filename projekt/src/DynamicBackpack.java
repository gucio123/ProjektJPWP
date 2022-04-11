import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicBackpack {
    private List<Items> finalList = new ArrayList<>();
    public List<Items> listOfItems = new ArrayList<Items>(Arrays.asList(
//            new Items("koszula", 7, 75), new Items("spodnie", 8, 150), new Items("sweter", 6, 250)
//            , new Items("czapka", 4, 35), new Items("kapielowki", 3, 10), new Items("buty", 9, 100)
            new Items("Skarpety",1, 2),
            new Items("taśmy",2, 5),
            new Items("Tank-top",2, 8),
            new Items("Pas",2, 5),
            new Items("rekawice",1, 1),
            new Items("Białko",4, 8),
            new Items("Trenbolon",6, 18),
            new Items("Kreatyna",5, 10),
            new Items("tygrys bubblegum",4, 6)
            ));
    private int capacity = 20;
    private int[][] pij = new int[listOfItems.toArray().length][capacity];
    private int[][] qij = new int[listOfItems.toArray().length][capacity];
    private int[][] load = new int[listOfItems.toArray().length][capacity];
    public void dynamic(){
        for(int j = 0; j < capacity; j++) {
            if (listOfItems.get(0).getWeight() <= j + 1) {
                pij[0][j] = listOfItems.get(0).getValue();
                load[0][j] = listOfItems.get(0).getWeight();
                qij[0][j] = 1;
            }
            else{
                pij[0][j] = 0;
                qij[0][j] = 0;
            }
        }
        for (int i = 1; i < listOfItems.toArray().length; i++){
            for(int j = 0; j < capacity; j++){
                pij[i][j] = pij[i-1][j];
                load[i][j] = load[i-1][j];
                qij[i][j] = qij[i-1][j];
                if(load[i-1][j] + listOfItems.get(i).getWeight() <= j + 1){
                    pij[i][j] += listOfItems.get(i).getValue();
                    load[i][j] += listOfItems.get(i).getWeight();
                    qij[i][j] = i+1;
                }
                if(listOfItems.get(i).getWeight() <= j+1){
                    if((pij[i-1][j] < listOfItems.get(i).getValue())) {
                        pij[i][j] = listOfItems.get(i).getValue();
                        load[i][j] = listOfItems.get(i).getWeight();
                        qij[i][j] = i+1;
                    }
                }
            }
        }
    }
    public void whichItems(){
        int actualCap = this.capacity;
        while(actualCap > 0){
            finalList.add(listOfItems.get(qij[listOfItems.toArray().length-1][actualCap - 1] - 1));
            actualCap -= listOfItems.get(qij[listOfItems.toArray().length-1][actualCap - 1] - 1).getWeight();
        }
    }
    public static void main(String[] args) {
        DynamicBackpack back = new DynamicBackpack();
        back.dynamic();
        back.whichItems();
        for(int i = 0; i < back.listOfItems.toArray().length; i++) {
            for (int j = 0; j < back.capacity; j++) {
                System.out.print(back.pij[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i < back.listOfItems.toArray().length; i++) {
            for (int j = 0; j < back.capacity; j++) {
                System.out.print(back.qij[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i < back.finalList.toArray().length; i++)
            System.out.print(back.finalList.get(i).getName() + " ");
    }

}
