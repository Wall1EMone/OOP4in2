package Items;


import java.util.List;

public abstract class Item {
    private String brand;
    private String name;
    private double priceDay;


    public Item(){

    }
    public Item(String brand,String name, double priceDay){
        this.brand = brand;
        this.name = name;
        this.priceDay = priceDay;

    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPriceDay(){
        return priceDay;
    }
    public void setPriceDay(double priceDay){
        this.priceDay = priceDay;
    }
//    public List<String> getCars(){
//        return cars;
//    }
//    public void setCars(List<String> cars) {
//        this.cars = cars;
//    }

    public abstract void ShowInfo();
}
