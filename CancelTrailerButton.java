import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CancelTrailerButton {

    public void cancelTrailer(){
        Stage window = new Stage();
        window.setTitle("Avboka");


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
        TextField trailerNameInput = new TextField();
        trailerNameInput.setPromptText("namn/model på bilen");
        GridPane.setConstraints(trailerNameInput,1,2);

        //Label för mail
        Label mail = new Label("Mail");
        GridPane.setConstraints(mail,0,4);

        //Textfield för mail
        TextField mailInput = new TextField();
        mailInput.setPromptText("mail");
        GridPane.setConstraints(mailInput,1,4);

        //Label som visar det sparade
        Label cancelInfo = new Label();
        GridPane.setConstraints(cancelInfo,1,6);

        //Knappar
        Button cancelButton = new Button("Avsluta bokning");
        GridPane.setConstraints(cancelButton,0,6);
        cancelButton.setOnAction(e ->{

            cancelInfo.setText(nameInput.getText() +", " +
                    lastnameInput.getText() + ", " + mailInput.getText() + " har avslutat bokning på " +  trailerNameInput.getText() + ". Tack och välkommen åter!");
        });


        grid.getChildren().addAll(nameLabel, nameInput, lastName, lastnameInput, carName, trailerNameInput,
                mail, mailInput, cancelButton,cancelInfo);

        Scene scene = new Scene(grid,600,400);
        window.setScene(scene);
        window.show();
    }
}
