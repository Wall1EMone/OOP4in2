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

public class TrailerRentalButton {
    RentalRegistry rentalRegistry;
    Pension pension = new Pension();
    Student student = new Student();
    //Måste göra konstruktor och attribut för att jag ska kunna ha samma lista för att räkna intäkter
    public TrailerRentalButton(RentalRegistry rentalRegistry){
        this.rentalRegistry = rentalRegistry;
    }

    public void rentalTrailer(String title){
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
        Label trailerName = new Label("Namn/model på släpvagn");
        GridPane.setConstraints(trailerName,0,2);

        //Textfield för bil
        TextField trailerNameInput = new TextField();
        trailerNameInput.setPromptText("namn/model på släpvagn");
        GridPane.setConstraints(trailerNameInput,1,2);

        //Label för antal dagar
        Label days = new Label("Antal dagar");
        GridPane.setConstraints(days,0,3);

        //TextField för antal dagar
        TextField daysInput = new TextField();
        daysInput.setPromptText("antal dagar");
        GridPane.setConstraints(daysInput,1,3);

        //Label för mail
        Label mail = new Label("Mail");
        GridPane.setConstraints(mail,0,4);

        //Textfield för mail
        TextField mailInput = new TextField();
        mailInput.setPromptText("mail");
        GridPane.setConstraints(mailInput,1,4);

        //Checkbox
        CheckBox box1 = new CheckBox();
        GridPane.setConstraints(box1,1,5);

        Label checkBox = new Label("Student eller Pensionär");
        GridPane.setConstraints(checkBox,0,5);



        //Label som visar det sparade
        Label savedInfo = new Label();
        GridPane.setConstraints(savedInfo,1,6);

        //Knappar
        Button rentButton = new Button("Hyr");
        GridPane.setConstraints(rentButton,0,6);
        rentButton.setOnAction(e ->{
            //skapar variabler här och kalla på metod
            int daysRented = Integer.parseInt(daysInput.getText());
            String trailerType = trailerNameInput.getText();
            boolean discount = box1.isSelected();
            double totalPrice = price(daysRented, trailerType, discount);
            Rental newRental = new Rental(totalPrice);
            rentalRegistry.addRental(newRental);

            savedInfo.setText(nameInput.getText() +", " +
                    lastnameInput.getText() + " har hyrt " +  trailerNameInput.getText() + ". Pris: " + totalPrice + " kr.");
        });


        grid.getChildren().addAll(nameLabel, nameInput, lastName, lastnameInput, trailerName, trailerNameInput, days,
                daysInput, mail, mailInput, checkBox, box1,
                rentButton,savedInfo);

        Scene scene = new Scene(grid,600,400);
        window.setScene(scene);
        window.show();

    }
    public double price(int days, String trailerType, boolean discount){
        double pricePerDay;
        if(trailerType.equalsIgnoreCase("mini")){
            pricePerDay = 250;
        }else{
            pricePerDay = 400;
        }
        double total = days * pricePerDay;
        if(discount){
            total = student.calculatePrice(total);
        }
        return total;


    }
}

