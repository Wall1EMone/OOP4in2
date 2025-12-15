import Inventory.Inventory;
import Items.Car;
import Items.Trailer;
import Members.Member;
import Rental.RentalRegistry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CarButton {
    Inventory inventory = new Inventory();
    SearchButtonCar searchButtonCar = new SearchButtonCar();

    RentalRegistry rentalRegistry;
    CarRentalButton carRentalButton;

    TableView<Car> carTable = new TableView<>();
    TextField brandInput, nameInput, priceInput, fuelInput;

    //Måste göra konstruktor och attribut för att jag ska kunna ha samma lista för att räkna intäkter
    public CarButton(RentalRegistry rentalRegistry){
        this.rentalRegistry = rentalRegistry;
        this.carRentalButton = new CarRentalButton(rentalRegistry);
    }
    public void carButton(String title){
        Stage window = new Stage();
        window.setTitle("Mones biluthyrning");


        Label carLabel = new Label("BILAR");
        carLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

        //Tableview för Car
        TableColumn<Car, String> carBrand = new TableColumn<>("Märke");
        carBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Car, String> carName = new TableColumn<>("Namn");
        carName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Car, Double> carPrice = new TableColumn<>("Pris/dag");
        carPrice.setCellValueFactory(new PropertyValueFactory<>("priceDay"));

        TableColumn<Car, String> carFuel = new TableColumn<>("Bränsle");
        carFuel.setCellValueFactory(new PropertyValueFactory<>("fuel"));

        carTable.getColumns().addAll(carBrand, carName, carPrice, carFuel);
        carTable.setItems(FXCollections.observableArrayList(inventory.getCars()));
        carTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);//Har detta så att det kan radera flera

        //Kod för input
        brandInput = new TextField();
        brandInput.setPromptText("Märke");

        nameInput = new TextField();
        nameInput.setPromptText("Namn");

        priceInput = new TextField();
        priceInput.setPromptText("Pris");

        fuelInput = new TextField();
        fuelInput.setPromptText("Bränsle");

        //Knappar
        Button button = new Button("Lägga till");
        button.setOnAction(e -> addButton());

        Button button1 = new Button("Delete");
        button1.setOnAction(e -> deleteButton());

        Button button2 = new Button("Hyra");
        button2.setOnAction(e-> carRentalButton.rentalCar("Hyra"));

        Button button3 = new Button("Sök");
        button3.setOnAction(e -> searchButtonCar.searchCar());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(brandInput, nameInput, priceInput, fuelInput, button, button1, button2,button3);





        VBox carBox = new VBox(10);
        carBox.getChildren().addAll(carLabel,carTable,hBox);


        Scene scene = new Scene(carBox,900,400);
        window.setScene(scene);
        window.show();

    }
    public void addButton(){
        Car newCar = new Car();
        newCar.setBrand(brandInput.getText());
        newCar.setName(nameInput.getText());
        newCar.setPriceDay(Double.parseDouble(priceInput.getText()));
        newCar.setFuel(fuelInput.getText());

        //Lägga till det nya i lista och table
        carTable.getItems().addAll(newCar);
        //Rensa textfält
        brandInput.clear();
        nameInput.clear();
        priceInput.clear();
        fuelInput.clear();
    }
    public void deleteButton(){
        ObservableList<Car> carsSelected = carTable.getSelectionModel().getSelectedItems();
        ObservableList<Car> allCars = carTable.getItems();

        //Måste skapa en kopia lista annars kaster JavaFX ConcurrentModificationException.
        ObservableList<Car> selectedCopy = FXCollections.observableArrayList(carsSelected);

        selectedCopy.forEach(allCars::remove);
    }



}
