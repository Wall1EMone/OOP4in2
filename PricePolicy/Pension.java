package PricePolicy;

public class Pension implements PricePolicy{
    @Override
    public double calculatePrice(double Price){
        return Price * 0.80;
    }
}
