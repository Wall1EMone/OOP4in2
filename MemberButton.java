import Inventory.Inventory;
import Items.Car;
import Items.Trailer;
import Members.Member;
import Members.MemberRegistry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class MemberButton {
    MemberRegistry memberRegistry = new MemberRegistry();
    SearchButtonMember searchButtonMember = new SearchButtonMember();
    TextField nameInput, lastnameInput,mailInput;
    TableView<Member> memberTable = new TableView<>();

    public void members(String title){
        Stage window = new Stage();
        window.setTitle("Mones biluthyrning");

        Label memberLabel = new Label("MEDLEMMAR");
        memberLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

        //Tableview för Medlemmar
        TableColumn<Member, String> memberName = new TableColumn<>("Namn");
        memberName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Member, String> lastName = new TableColumn<>("Efternamn");
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastname"));

        TableColumn<Member, String> memberMail = new TableColumn<>("Mail");
        memberMail.setCellValueFactory(new PropertyValueFactory<>("mail"));

        //Namn input
        nameInput = new TextField();
        nameInput.setPromptText("Namn");
        nameInput.setMinWidth(100);

        //Efternamn input
        lastnameInput = new TextField();
        lastnameInput.setPromptText("Efternamn");
        lastnameInput.setMinWidth(100);

        //Mail input
        mailInput = new TextField();
        mailInput.setPromptText("Mail");
        mailInput.setMinWidth(100);

        Button button = new Button("Lägga till");
        button.setOnAction(e -> addButton());
        Button button1 = new Button("Delete");
        button1.setOnAction(e -> deleteButton());

        Button button2 = new Button("Sök");
        button2.setOnAction(e -> searchButtonMember.searchMember());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,lastnameInput,mailInput,button,button1,button2);


        memberTable.getColumns().addAll(memberName, lastName, memberMail);
        memberTable.setItems(FXCollections.observableArrayList(memberRegistry.all()));
        memberTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);//Har det så att det kan ta bort många samtidigt



        VBox carBox = new VBox(10);
        carBox.getChildren().addAll(memberLabel,memberTable,hBox);


        Scene scene = new Scene(carBox,700,400);
        window.setScene(scene);
        window.show();
    }
    public void addButton(){
        Member newMember = new Member();
        newMember.setName(nameInput.getText());
        newMember.setLastname(lastnameInput.getText());
        newMember.setMail(mailInput.getText());
        memberTable.getItems().addAll(newMember);
        //För att rensa textfält
        nameInput.clear();
        lastnameInput.clear();
        mailInput.clear();

    }
    public void deleteButton(){
        ObservableList<Member> membersSelected = memberTable.getSelectionModel().getSelectedItems();
        ObservableList<Member> allMembers = memberTable.getItems();

        //Skapa en kopia innan man tar bort för att undvika ConcurrentModificationException
        ObservableList<Member> selectedCopy = FXCollections.observableArrayList(membersSelected);

        selectedCopy.forEach(allMembers::remove);

    }
}
