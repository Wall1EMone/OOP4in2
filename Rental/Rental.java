package Rental;

import Items.Item;
import Members.Member;

import java.time.LocalDateTime;
import java.util.List;

public class Rental {
    private Member member;
    private Item item;
    private LocalDateTime start;
    private LocalDateTime end;
    private boolean active;
    private double totalPrice;

    public Rental(Member member, Item item, LocalDateTime start, LocalDateTime end, boolean active, double totalPrice){
        this.member = member;
        this.item = item;
        this.start = start;
        this.end = end;
        this.active = true;
        this.totalPrice = totalPrice;
    }
    public Member getMember(){
        return member;
    }
    public Item getItem(){
        return item;
    }
    public LocalDateTime getStart(){
        return start;
    }
    public LocalDateTime getEnd(){
        return end;
    }
    public boolean isActive(){
        return active;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    public void startRental(){
        this.active = true;
        this.start = LocalDateTime.now();
    }
    public void endRental(){
        this.active = false;
        this.end = LocalDateTime.now();
    }

}
