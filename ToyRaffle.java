
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToyRaffle {
    private Toy[] Toys;
    private int TotalWeight;
    private int NumberofToys;

    public ToyRaffle() {
        NumberofToys = 0;
        Toys = new Toy[10];
        TotalWeight = 0;
    }

    public void addToy(int id, String name, int weight) {
        Toys[NumberofToys] = new Toy(id, name, weight);
        TotalWeight += weight;
        NumberofToys++;
    }

    public void runRaffle() {
        try (FileWriter fileWriter = new FileWriter("result.txt", false)){
            int indx = 0;
            for (double r = Math.random() * TotalWeight; indx < Toys.length - 1; ++indx) {
                r -= Toys[indx].getWeight();
                if (r <= 0.0) break;
            }
            Toy RandomToy = Toys[indx];
            fileWriter.write(RandomToy.getName() + "\n");
            fileWriter.close();
            System.out.println("Inside");
        } catch (IOException e) {
            e.printStackTrace();
            
            System.out.println("Outside");
        }
    }

    public static void main(String[] args) {
        ToyRaffle raffle = new ToyRaffle();
        raffle.addToy(1, "Toy 1", 3);
        raffle.addToy(2, "Toy 2", 2);
        raffle.addToy(3, "Toy 3", 4);
        raffle.runRaffle();
    }
}
