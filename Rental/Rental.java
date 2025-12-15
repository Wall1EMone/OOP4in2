package Rental;

import Items.Item;
import Members.Member;

import java.time.LocalDateTime;
import java.util.List;

public class Rental {
    private Item item;
    private double totalPrice;

    public Rental(double totalPrice){

        this.totalPrice = totalPrice;
    }
    public Item getItem(){
        return item;
    }
    public double getTotalPrice(){
        return totalPrice;
    }


}
