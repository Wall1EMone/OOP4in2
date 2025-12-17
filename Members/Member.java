package Members;

import PricePolicy.PricePolicy;


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

    public void info(){
        System.out.println("name: " + name);
        System.out.println("Lastname: " + lastname);
        System.out.println("Mail: " + mail);


    }
}
