package Rental;

import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class RentalRegistry {
    private List<Rental> rentals;

    public RentalRegistry(){
        this.rentals = new ArrayList<>();
    }
    public void addRental(Rental rental){
        rentals.add(rental);
    }
    public List<Rental> getAllRentals(){
        return rentals;
    }
    public List<Item> getRentedItems(){
        List<Item> rented = new ArrayList<>();
        for (Rental r : rentals){
            rented.add(r.getItem());
        }
        return rented;
    }
}
