package Items;


import java.util.List;

public abstract class Item {
    private String name;
    private double price;
    private List<String> clubs;

    public Item(){

    }
    public Item(String name, double price, List<String> clubs){
        this.name = name;
        this.price = price;
        this.clubs = clubs;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public List<String> getClubs(){
        return clubs;
    }
    public void setClubs(List<String> clubs) {
        this.clubs = clubs;
    }

    public abstract void ShowInfo();
}
