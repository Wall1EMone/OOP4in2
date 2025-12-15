package Inventory;

import Items.*;
import Rental.RentalRegistry;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Car> cars;
    private List<Trailer> trailers;

    public Inventory(){
        this.cars = new ArrayList<>();
        this.trailers = new ArrayList<>();

        cars.add(new Car("Volvo", "XC60", 600, "Diesel"));
        cars.add(new Car("Volvo", "XC60", 600, "Diesel"));
        cars.add(new Car("Volvo", "XC60", 600, "Diesel"));
        cars.add(new Car("Volvo", "XC60", 600, "Diesel"));
        cars.add(new Car("Volvo", "XC60", 600, "Diesel"));

        cars.add(new Car("Volvo", "XC90", 900, "Diesel"));
        cars.add(new Car("Volvo", "XC90", 900, "Diesel"));
        cars.add(new Car("Volvo", "XC90", 900, "Diesel"));
        cars.add(new Car("Volvo", "XC90", 900, "Diesel"));
        cars.add(new Car("Volvo", "XC90", 900, "Diesel"));

        trailers.add(new Trailer("Larssons", "mini", 250, "bromsar"));
        trailers.add(new Trailer("Larssons", "mini", 250, "bromsar"));
        trailers.add(new Trailer("Larssons", "mini", 250, "bromsar"));
        trailers.add(new Trailer("Larssons", "mini", 250, "bromsar"));
        trailers.add(new Trailer("Larssons", "mini", 250, "bromsar"));

        trailers.add(new Trailer("Larssons", "stor", 400, "bromsar"));
        trailers.add(new Trailer("Larssons", "stor", 400, "bromsar"));
        trailers.add(new Trailer("Larssons", "stor", 400, "bromsar"));
        trailers.add(new Trailer("Larssons", "stor", 400, "bromsar"));
        trailers.add(new Trailer("Larssons", "stor", 400, "bromsar"));


    }
    public List<Car> getCars(){
        return cars;
    }
    public void setCars(List<Car> cars){
        this.cars = cars;
    }
    public List<Trailer> getTrailers(){
        return trailers;
    }
    public void setTrailers(List<Trailer> trailers){
        this.trailers = trailers;
    }


}
