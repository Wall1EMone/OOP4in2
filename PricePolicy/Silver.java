package PricePolicy;

public class Silver implements PricePolicy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.90;
    }
    @Override
    public String getLevelName(){
        return "Silver";
    }
}
