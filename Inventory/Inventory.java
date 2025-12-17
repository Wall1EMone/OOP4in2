package Inventory;

import Items.*;
import Rental.RentalRegistry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
//    private List<Car> cars;
//    private List<Trailer> trailers;
    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<Trailer> trailers = FXCollections.observableArrayList();

    public Inventory(){
        cars = FXCollections.observableArrayList();
        trailers = FXCollections.observableArrayList();

        if(cars.isEmpty()){
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
        }
        if(trailers.isEmpty()){
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



    }
    public ObservableList<Car> getCars(){
        return cars;
    }
    public void setCars(ObservableList<Car> cars){
        this.cars = cars;
    }
    public ObservableList<Trailer> getTrailers(){
        return trailers;
    }
    public void setTrailers(ObservableList<Trailer> trailers){
        this.trailers = trailers;
    }


}
