package Members;

import PricePolicy.PricePolicy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String lastname;
    private String mail;
    private PricePolicy pricePolicy;



    public Member(){
    }
    public Member(String name, String lastname, String mail){
        this.name = name;
        this.lastname = lastname;
        this.mail = mail;
    }
    //Setter och Getter för name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }

    public double getRentalPrice(double basePrice){
        return pricePolicy.calculatePrice(basePrice);
    }
    //List
//    public List<String> getHistory(){
//        return history;
//    }
//    public void setHistory(List<String> history){
//        this.history = history;
//    }
//    public void addHistory(String input){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SS");// noga med att "yyyy-MM-dd hh:mm:ss:SS" ska vara exakt så, annars blir siffror fel!
//        String timeS = LocalDateTime.now().format(formatter);
//        history.add("[" + timeS + "] " + input);
//    //    history.add("[" + java.time.LocalDateTime.now().toString().replace("T", " ") + "] " + input);//Tar även bort T och ersätter med mellanslag
//    }


    public void info(){
        System.out.println("name: " + name);
        System.out.println("Lastname: " + lastname);
        System.out.println("Mail: " + mail);


    }
}
