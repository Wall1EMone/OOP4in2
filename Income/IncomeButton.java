package Income;

import Rental.RentalRegistry;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IncomeButton {
    RentalRegistry rentalRegistry;

    //Måste göra konstruktor och attribut för att jag ska kunna ha samma lista för att räkna intäkter
    public IncomeButton(RentalRegistry rentalRegistry){
        this.rentalRegistry = rentalRegistry;
    }

    public void income(){
        Stage window = new Stage();
        window.setTitle("Intäkter");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);


        //Label som intäkter finns
        Label incomeInfo = new Label();
        GridPane.setConstraints(incomeInfo,1,1);


        //Intäkt knapp
        Button button = new Button("Visa Intäkter");
        GridPane.setConstraints(button, 0,1);
        button.setOnAction(e->{
            incomeInfo.setText("Total intäkt: " + rentalRegistry.getTotalIncome() + " kr");
        });


        grid.getChildren().addAll(button, incomeInfo);

        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();

    }
}
