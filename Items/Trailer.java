package Items;

public class Trailer extends Item{
    private String brake;

    public Trailer(){}

    public Trailer(String brand, String name, double priceDay, String brake){
        super(brand,name,priceDay);
        this.brake = brake;

    }
    public String getBrake(){
        return brake;
    }
    public void setBrake(String brake){
        this.brake = brake;
    }
    @Override
    public void ShowInfo() {

    }
    @Override
    public String toString(){
        return getBrand() + ";" + getName() + ";" + getPriceDay() + ";" + brake;
    }
}
