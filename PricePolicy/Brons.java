package PricePolicy;

public class Brons implements PricePolicy {
    @Override
    public double calculatePrice(double basePrice){
        return basePrice * 0.95;
    }
    @Override
    public String getLevelName(){
        return "brons";
    }

}
