import Inventory.Inventory;
import Items.Car;
import Items.Trailer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SearchButtonTrailer {
    Inventory inventory = new Inventory();

    public void searchTrailer(){
        Stage window = new Stage();
        window.setTitle("Sök");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);

        //Name label, namn på kolumn 0 och rad 0
        Label nameLabel = new Label("Namn/model");
        GridPane.setConstraints(nameLabel,0,0);

        //Namn input,textfält, fält där det skrivrs in namn.
        TextField nameInput = new TextField();
        nameInput.setPromptText("Namn/model");
        GridPane.setConstraints(nameInput,1,0);

        //Label som visar om bil finns
        Label trailerInfo = new Label();
        GridPane.setConstraints(trailerInfo,1,1);


        //Hyr knapp
        Button button = new Button("Sök");
        GridPane.setConstraints(button, 0,1);
        button.setOnAction(e->{
            String inputName = nameInput.getText();
            Trailer found = search(inputName);

            if(found != null){
                trailerInfo.setText(found.getName() + " finns.");
            }else{
                trailerInfo.setText("Släpvagn finns inte!");
            }
        });


        grid.getChildren().addAll(nameLabel, nameInput, button, trailerInfo);

        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();
    }
    public Trailer search(String name){
        for(Trailer t : inventory.getTrailers()){
            if(t.getName().equalsIgnoreCase(name)){
                return t;
            }
        }
        return null;

    }

}
