package PricePolicy;

public class Guld implements PricePolicy {
    @Override
    public double calculatePrice(double basePrice){
        return basePrice * 0.8;
    }
    @Override
    public String getLevelName(){
        return "Guld";
    }
}
