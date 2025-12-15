package PricePolicy;

public class Student implements PricePolicy{
    @Override
    public double calculatePrice(double Price) {
        return Price * 0.80;
    }
}
