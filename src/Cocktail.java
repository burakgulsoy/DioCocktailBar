import java.io.Serializable;
import java.util.ArrayList;

public class Cocktail implements Serializable {

    private String name;
    private boolean containsAlcohol;
    private int alcoholRate;
    private ArrayList<String> fruits;
    private FLAVOR flavor;
    private double price;

    public Cocktail(String name, boolean containsAlcohol, int alcoholRate, ArrayList<String> fruits, FLAVOR flavor, double price) {
        this.name = name;
        this.containsAlcohol = containsAlcohol;
        this.alcoholRate = alcoholRate;
        this.fruits = fruits;
        this.flavor = flavor;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContainsAlcohol() {
        return containsAlcohol;
    }

    public void setContainsAlcohol(boolean containsAlcohol) {
        this.containsAlcohol = containsAlcohol;
    }

    public int getAlcoholRate() {
        return alcoholRate;
    }

    public void setAlcoholRate(int alcoholRate) {
        this.alcoholRate = alcoholRate;
    }

    public ArrayList<String> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<String> fruits) {
        this.fruits = fruits;
    }

    public FLAVOR getFlavor() {
        return flavor;
    }

    public void setFlavor(FLAVOR flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String string = name + " " + containsAlcohol + " " + alcoholRate + " ";

        for (int i = 0; i < fruits.size(); i++) {
            if (i != fruits.size() - 1) {
                string += fruits.get(i) + "-";
            } else {
                string += fruits.get(i);
            }
        }

        string +=  " " + flavor.toString() + " " + price;
        return string;
    }
}
