import Inventory.Inventory;
import Items.Car;
import Items.Trailer;
import Members.MemberRegistry;
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

public class TrailerButton {
    Inventory inventory = new Inventory();
    SearchButtonTrailer searchButtonTrailer = new SearchButtonTrailer();

    TrailerRentalButton trailerRentalButton;
    RentalRegistry rentalRegistry;

    TableView<Trailer> trailerTable = new TableView<>();
    TextField brandInput, nameInput, priceInput, brakeInput;
    //Måste göra konstruktor och attribut för att jag ska kunna ha samma lista för att räkna intäkter
    public TrailerButton(RentalRegistry rentalRegistry){
        this.rentalRegistry = rentalRegistry;
        this.trailerRentalButton = new TrailerRentalButton(rentalRegistry);
    }

    public void trailerButton(String title){
        Stage window = new Stage();
        window.setTitle("Mones biluthyrning");


        Label trailerLabel = new Label("SLÄPVAGNAR");
        trailerLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

        //Tableview för släppvagn
        TableColumn<Trailer, String> trailerBrand = new TableColumn<>("Märke");
        trailerBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Trailer, String> trailerName = new TableColumn<>("Namn");
        trailerName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Trailer, Double> trailerPrice = new TableColumn<>("Pris/dag");
        trailerPrice.setCellValueFactory(new PropertyValueFactory<>("priceDay"));

        TableColumn<Trailer, String> trailerBrake = new TableColumn<>("Bromsar");
        trailerBrake.setCellValueFactory(new PropertyValueFactory<>("brake"));

        //Input
        brandInput = new TextField();
        brandInput.setPromptText("Märke");

        nameInput = new TextField();
        nameInput.setPromptText("Name");

        priceInput = new TextField();
        priceInput.setPromptText("Pris/dag");

        brakeInput = new TextField();
        brakeInput.setPromptText("Bromsar");

        //Knappar
        Button button = new Button("Lägga till");
        button.setOnAction(e -> addButton());

        Button button1 = new Button("Delete");
        button1.setOnAction(e -> deleteButton());

        Button button2 = new Button("Hyra");
        button2.setOnAction(e-> trailerRentalButton.rentalTrailer("Hyra"));

        Button button3 = new Button("Sök");
        button3.setOnAction(e -> searchButtonTrailer.searchTrailer());


        trailerTable.getColumns().addAll(trailerBrand, trailerName,trailerPrice, trailerBrake);
        trailerTable.setItems(FXCollections.observableArrayList(inventory.getTrailers()));
        trailerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);//Ha detta för att radera flera

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(brandInput, nameInput, priceInput, brakeInput,button, button1,button2, button3);


        VBox carBox = new VBox(10);
        carBox.getChildren().addAll(trailerLabel,trailerTable,hBox);


        Scene scene = new Scene(carBox,900,400);
        window.setScene(scene);
        window.show();

    }
    public void addButton(){
        Trailer newTrailers =new Trailer();
        newTrailers.setBrand(brandInput.getText());
        newTrailers.setName(nameInput.getText());
        newTrailers.setPriceDay(Double.parseDouble(priceInput.getText()));
        newTrailers.setBrake(brakeInput.getText());

        //Lägga till det nya i lista och table
        trailerTable.getItems().addAll(newTrailers);
        //Rensa textfält
        brandInput.clear();
        nameInput.clear();
        priceInput.clear();
        brakeInput.clear();
    }
    public void deleteButton(){
        ObservableList<Trailer> trailerSelected = trailerTable.getSelectionModel().getSelectedItems();
        ObservableList<Trailer> allTrailer = trailerTable.getItems();

        //Måste skapa en kopia lista annars kaster JavaFX ConcurrentModificationException.
        ObservableList<Trailer> selectedCopy = FXCollections.observableArrayList(trailerSelected);

        selectedCopy.forEach(allTrailer::remove);
    }

}
