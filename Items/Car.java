package Items;

public class Car extends Item {
    private String fuel;

    public Car(){}

    public Car(String brand, String name, double priceDay, String fuel){
        super(brand, name, priceDay);
        this.fuel = fuel;
    }



    public String getFuel() {
        return fuel;
    }
    public void setFuel(String fuel){
        this.fuel = fuel;
    }

    @Override
    public void ShowInfo() {

    }
    @Override
    public String toString(){
        return getBrand() + ";" + getName() + ";" + getPriceDay() + ";" + fuel;
    }
}
