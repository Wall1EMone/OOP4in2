import CancelButton.CancelCarButton;
import CancelButton.CancelTrailerButton;
import Income.IncomeButton;
import Inventory.Inventory;
import Items.CarButton;
import Items.TrailerButton;
import Members.MemberButton;
import Rental.RentalRegistry;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.geometry.Insets;


public class Main extends Application {
    RentalRegistry rentalRegistry = new RentalRegistry();//gör så att har samma lista, rentalRegistry så att det kan räkna ut intäkter
    Inventory inventory = new Inventory();
    IncomeButton incomeButton = new IncomeButton(rentalRegistry);
    CarButton carbutton = new CarButton(rentalRegistry, inventory);
    MemberButton memberbutton = new MemberButton();
    TrailerButton trailerButton = new TrailerButton(rentalRegistry, inventory);

    CancelCarButton cancelCarButton = new CancelCarButton();
    CancelTrailerButton cancelTrailerButton = new CancelTrailerButton();
    Stage window;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Mones biluthyrning");


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label info = new Label("Välkommen till Mones bil och släp uthyrning");
        info.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        GridPane.setConstraints(info,5,0);

        Label choice = new Label("Välj vad du vill göra");
        choice.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        GridPane.setConstraints(choice,5,1);


        Button button = new Button("Medlemmar");
        GridPane.setConstraints(button,5,3);
        button.setOnAction(e -> memberbutton.members("Medlemmar"));

        Button button1 = new Button("Bilar");
        GridPane.setConstraints(button1,5,4);
        button1.setOnAction(e -> carbutton.carButton("Bilar"));

        Button button2 = new Button("Släpp vagnar");
        GridPane.setConstraints(button2,5,5);
        button2.setOnAction(e -> trailerButton.trailerButton("Släpvagnar"));

        Button button3 = new Button("Intäkter");
        GridPane.setConstraints(button3,5,6);
        button3.setOnAction(e -> incomeButton.income());

        Button button4 = new Button("Avboka bil");
        GridPane.setConstraints(button4,5,7);
        button4.setOnAction(e -> cancelCarButton.cancelCar());

        Button button5 = new Button("Avboka släpvagn");
        GridPane.setConstraints(button5, 5,8);
        button5.setOnAction(e-> cancelTrailerButton.cancelTrailer());

        gridPane.getChildren().addAll(info, choice,button,button1,button2,button3, button4, button5);




        Scene scene = new Scene(gridPane,500,300);
        window.setScene(scene);
        window.show();

    }
}