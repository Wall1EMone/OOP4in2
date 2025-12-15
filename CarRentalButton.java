import PricePolicy.Pension;
import PricePolicy.Student;
import Rental.Rental;
import Rental.RentalRegistry;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CarRentalButton {
    Pension pension = new Pension();
    Student student = new Student();
    RentalRegistry rentalRegistry;

    //Måste göra konstruktor och attribut för att jag ska kunna ha samma lista för att räkna intäkter
    public CarRentalButton(RentalRegistry rentalRegistry){
        this.rentalRegistry = rentalRegistry;
    }


    public void rentalCar(String title){
        Stage window = new Stage();
        window.setTitle("Hyra");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);

        //Name label, namn på kolumn 0 och rad 0
        Label nameLabel = new Label("Förnamn:");
        GridPane.setConstraints(nameLabel,0,0);

        //Namn input,textfält, fält där det skrivrs in namn.
        TextField nameInput = new TextField();
        nameInput.setPromptText("Förnamn");
        GridPane.setConstraints(nameInput,1,0);

        //Efternamn label,
        Label lastName = new Label("Efternamn:");
        GridPane.setConstraints(lastName,0,1);

        //Efternamn textfält
        TextField lastnameInput = new TextField();
        lastnameInput.setPromptText("Efternamn");
        GridPane.setConstraints(lastnameInput,1,1);

        //Label för bil
        Label carName = new Label("Namn/model på bilen");
        GridPane.setConstraints(carName,0,2);

        //Textfield för bil
        TextField carNameInput = new TextField();
        carNameInput.setPromptText("namn/model på bilen");
        GridPane.setConstraints(carNameInput,1,2);

        //Label för antal dagar
        Label days = new Label("Antal dagar");
        GridPane.setConstraints(days, 0, 3);

        //TextField för antal dagar
        TextField daysInput =  new TextField();
        daysInput.setPromptText("antal dagar");
        GridPane.setConstraints(daysInput, 1 ,3);

        //Label för mail
        Label mail = new Label("Mail");
        GridPane.setConstraints(mail,0,4);

        //Textfield för mail
        TextField mailInput = new TextField();
        mailInput.setPromptText("mail");
        GridPane.setConstraints(mailInput,1,4);

        //Checkbox
        CheckBox box1 = new CheckBox();
        GridPane.setConstraints(box1, 1,5);

        Label checkBox = new Label("Student eller pensionär");
        GridPane.setConstraints(checkBox, 0, 5);



        //Label som visar det sparade
        Label savedInfo = new Label();
        GridPane.setConstraints(savedInfo,1,6);

        //Knappar
        Button saveButton = new Button("Hyr");
        GridPane.setConstraints(saveButton,0,6);
        saveButton.setOnAction(e ->{
            //skapar variable här och kalla på metod
            int daysRented = Integer.parseInt(daysInput.getText());
            String carType = carNameInput.getText();
            boolean discount = box1.isSelected();
            double totalPrice = price(daysRented,carType,discount);
            Rental newRental = new Rental(totalPrice);
            rentalRegistry.addRental(newRental);

            savedInfo.setText(nameInput.getText() +", " +
                    lastnameInput.getText() + ", " + mailInput.getText() + " har hyrt " +  carNameInput.getText() + ". Pris: " + totalPrice + " kr.");
        });


        grid.getChildren().addAll(nameLabel, nameInput, lastName, lastnameInput, carName, carNameInput, days, daysInput, box1, checkBox, mail, mailInput,
                saveButton,savedInfo);

        Scene scene = new Scene(grid,600,400);
        window.setScene(scene);
        window.show();

    }
    public double price(int days, String carType, boolean discount){
        double pricePerDay;
        if(carType.equalsIgnoreCase("XC60")){
            pricePerDay = 600;
        }else{
            pricePerDay = 900;
        }
        double total = days * pricePerDay;
        if(discount){
            total = student.calculatePrice(total);
        }
        return total;

    }

}
