package Members;

import PricePolicy.PricePolicy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String lastname;
    private boolean status;
    private int id;
    private int rentalCount;
    private String level = "brons"; //Börjar alltid på brons
    private List<String> history = new ArrayList<>();
    private double hcp;
    private PricePolicy pricePolicy;
    private int bookingCount;


    public Member(){
    }
    public Member(String name, String lastname, boolean status, int id, String level, List<String> history, double hcp){
        this.name = name;
        this.lastname = lastname;
        this.status = status;
        this.id = id;
        this.rentalCount = 0;
        this.level = level;
        this.history = history;
        this.hcp = hcp;
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
    //Boolean
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    //Id
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    //Level
    public String getLevel(){
        return level;
    }
    public void setLevel(String level){
        this.level = level;
    }
    public double getRentalPrice(double basePrice){
        return pricePolicy.calculatePrice(basePrice);
    }
    //List
    public List<String> getHistory(){
        return history;
    }
    public void setHistory(List<String> history){
        this.history = history;
    }
    public void addHistory(String input){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SS");// noga med att "yyyy-MM-dd hh:mm:ss:SS" ska vara exakt så, annars blir siffror fel!
        String timeS = LocalDateTime.now().format(formatter);
        history.add("[" + timeS + "] " + input);
    //    history.add("[" + java.time.LocalDateTime.now().toString().replace("T", " ") + "] " + input);//Tar även bort T och ersätter med mellanslag
    }
    //räknar antal bokningar och uppgraderas
    public int getBookingCount(){
        return bookingCount;
    }
    public void BookingCount(){
        this.bookingCount++;
        checkLevelUpgrade();
    }
    private void checkLevelUpgrade(){
        if(bookingCount >=10 && level.equalsIgnoreCase("brons")){
            level = "silver";
            System.out.println("Grattis! Du har uppgraderas till silver-nivå.");
        }
        else if (bookingCount >=20 && level.equalsIgnoreCase("silver")){
            level = "guld";
            System.out.println("Grattis! Du har uppgraderas till guld-nivå.");
        }
    }
    //Hcp
    public double getHcp(){
        return hcp;
    }
    public void setHcp(double hcp){
        this.hcp = hcp;
    }
    public void info(){
        System.out.println("name: " + name);
        System.out.println("Lastname: " + lastname);
        System.out.println("Status: " + (status ? "Medlem" : "Ej medlem"));//annan typ av if sats, (condition ? sant : falsk)
        System.out.println("Id: " + id);
        System.out.println("Level: " + level);
        System.out.println("Antal hyrningar: " + rentalCount);
        System.out.println("Historik: " + history);
        System.out.println("Antal bokningar: " + getBookingCount());
        System.out.println("Hcp: " + hcp);
    }
}
