import Items.Car;
import Members.Member;
import Members.MemberRegistry;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SearchButtonMember {
    Member member = new Member();
    MemberRegistry memberRegistry = new MemberRegistry();

    public void searchMember(){
        Stage window = new Stage();
        window.setTitle("Sök");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);

        //Name label, namn på kolumn 0 och rad 0
        Label nameLabel = new Label("Namn");
        GridPane.setConstraints(nameLabel,0,0);

        //Namn input,textfält, fält där det skrivrs in namn.
        TextField nameInput = new TextField();
        nameInput.setPromptText("Namn");
        GridPane.setConstraints(nameInput,1,0);

        //Label som visar om bil finns
        Label memberInfo = new Label();
        GridPane.setConstraints(memberInfo,1,1);


        //Hyr knapp
        Button button = new Button("Sök");
        GridPane.setConstraints(button, 0,1);
        button.setOnAction(e->{
            String inputName = nameInput.getText();
            Member found = search(inputName);

            if(found != null){
                memberInfo.setText(found.getName() + " finns.");
            }else{
                memberInfo.setText( nameInput.getText() + " är finns inte!");
            }
        });


        grid.getChildren().addAll(nameLabel, nameInput, button, memberInfo);

        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();
    }
    public Member search(String name){
        for(Member m : memberRegistry.all()){
            if(m.getName().equalsIgnoreCase(name)){
                return m;
            }
        }
        return null;
    }
}
