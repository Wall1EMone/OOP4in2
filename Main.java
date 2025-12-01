import Inventory.Inventory;
import Items.Item;
import Members.Member;
import Members.MemberRegistry;
import PricePolicy.PricePolicy;
import Rental.Rental;
import Rental.RentalRegistry;
import org.w3c.dom.html.HTMLAreaElement;
import PricePolicy.Brons;
import PricePolicy.*;

import java.security.Policy;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberRegistry registry = new MemberRegistry();
        Inventory inventory = new Inventory();
        RentalRegistry rentalRegistry = new RentalRegistry();
        Member member = new Member();
        boolean run = true;

        while(run){
            System.out.println("Välkommen till Mones golfshop");
            System.out.println("Gör ditt val");
            System.out.println();
            System.out.println("1. Skapa medlem");
            System.out.println("2. Söka medlem");
            System.out.println("3. Ändra medlem");
            System.out.println("4. Lista på alla set");
            System.out.println("5. Kolla klubbor i setet");
            System.out.println("6. Boka");
            System.out.println("7. Avsluta uthyrning");
            System.out.println("8. Summera intäkter");
            System.out.println("9. Avsluta");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    while (true) {
                        try {
                            System.out.print("Namn: ");
                            String name = scanner.nextLine();

                            System.out.print("Efternamn: ");
                            String lastName = scanner.nextLine();

                            System.out.print("Handikapp: ");
                            double hcp = scanner.nextDouble();
                            scanner.nextLine();

                            int id = registry.nextID(); // Id baserad på antal medlemmar i listan och siffran på iden går upp åt.
                            Member m = new Member(name, lastName, true, id, "brons", new ArrayList<>(), hcp);
                            registry.add(m);
                            m.addHistory("Medlem skapad: " + name + " " + lastName);
                            registry.addHistory("Medlem skapad: " + name + " " + lastName);

                            System.out.println("Medlem skapad!");
                            System.out.println("Namn: " + name);
                            System.out.println("Efternamn: " + lastName);
                            System.out.println("ID: " + id);
                            System.out.println();

                            break;
                        } catch (Exception e) {
                            System.out.println("Skriv namn och efternamn med bokstäver och handikapp med siffra!");
                            System.out.println();
                            scanner.nextLine();
                        }

                    }
                    break;

                case 2:
                    while (true) {
                        try {
                            System.out.print("Skriv in ID nummer: ");
                            int idNum = scanner.nextInt();
                            scanner.nextLine();

                            Member found = registry.findId(idNum);
                            if (found != null){
                                found.info();
                                System.out.println();
//                                for (String s : found.getHistory()) {
//                                    System.out.print(s);
//                                    System.out.println();
//                                }

                                break;
                            }else{
                                System.out.println("Ingen medlem med det ID:t!");

                            }
                            //Kollar om id finns i listan och skriver ut info om true
//                            boolean found2 = false;
//                            for (Member m : members) {
//                                if (m.getId() == idNum) {
//                                    m.info();
//                                    System.out.println();
//                                    found2 = true;
//                                    break;
//                                }
//                            }
//                            if (!found2) {
//                                System.out.println("Du är inte medlem!");
//                                continue;// Så att det går tillbaka i början utan att gå till meny
//                            }
//                            break;//Bryta sig ut while loop när det hittat

                        } catch (Exception e) {
                            System.out.println("Fel: Skriv ditt id i tal!");
                            scanner.nextLine();
                        }
                    }
                    break;

                case 3:
                    while (true) {
                        try {
                            System.out.print("Skriv in ID på den du vill ändra: ");
                            int id3 = scanner.nextInt();
                            scanner.nextLine();

                            Member found = registry.findId(id3);
                            if(found !=null){
                                System.out.print("Nytt namn: ");
                                String name3 = scanner.nextLine();
//                                found.setName(scanner.nextLine());//Skriva ihop det på detta sätt så jag att slipper göra found.setName senare

                                System.out.print("Nytt efternamn: ");
                                String lastName3 = scanner.nextLine();
//                                found.setLastname(scanner.nextLine());

                                System.out.print("Nytt handikapp: ");
                                double hcp3 = scanner.nextDouble();
//                                found.setHcp(scanner.nextDouble());
                                scanner.nextLine();

                                found.setName(name3);
                                found.setLastname(lastName3);
                                found.setHcp(hcp3);

                                found.addHistory("Ändring: " + name3 + " " + lastName3 + " " + hcp3);
                                registry.addHistory("Ändring: " + name3 + " " + lastName3);
                                System.out.println();

                                System.out.println("Medlem uppdaterad!");
                                System.out.println("Nytt namn: " + name3);
                                System.out.println("Nytt efternamn: " + lastName3);
                                System.out.println("Nytt handikapp: " + hcp3);
                                System.out.println();

                                break;
                            }else{
                                System.out.println("Ingen medlem med det ID:t!");

                            }

//                            boolean found3 = false;
//
//                            for (Member m3 : members) {
//                                if (m3.getId() == id3) {
//                                    System.out.print("Nytt namn: ");
//                                    String name3 = scanner.nextLine();
//
//                                    System.out.print("Nytt Efternamn: ");
//                                    String lastName3 = scanner.nextLine();
//
//                                    System.out.println("Nytt handikapp: ");
//                                    double hcp3 = scanner.nextDouble();
//
//                                    m3.addHistory("Ändring: " + name3 + " " + lastName3);
//
//                                    m3.setName(name3);
//                                    m3.setLastname(lastName3);
//                                    m3.setHcp(hcp3);
//
//                                    System.out.println("Nytt namn: " + name3);
//                                    System.out.println("nytt efternamn: " + lastName3);
//                                    System.out.println("Nytt handikapp: " + hcp3);
//                                    System.out.println();
//
//                                    found3 = true;
//                                    break;
//
//                                }
//                            }
//                            if(found3){
//                                break;
//                            }

                        } catch (Exception e) {
                            System.out.println("Fel: Skriv ditt id i tal!");
                            scanner.nextLine();
                        }
                    }break;

                case 4:
                    System.out.println("Här är listan på alla golfset");
                    inventory.showAllItems();
                    System.out.println();
                    break;
                case 5:
                    while(true){

                            System.out.println("Skriv namn på set du vill kolla");
                            String nameSet = scanner.nextLine();

                            boolean found5 = false;
                            for (Item ns : inventory.getItems()){
                                if(ns.getName().equalsIgnoreCase(nameSet)){
                                    ns.ShowInfo();
                                    System.out.println();

                                    found5 = true;
                                    break;
                                }
                            }
                            if (found5){
                                break;
                            }
                            else{
                                System.out.println("Setet du söker finns inte, eller skriv rätt namn!");
                            }


                    }
                    break;
                case 6:
                    while (true) {
                        try {
                            inventory.showAllItems();

                            System.out.println("DU KAN BARA BOKA GOLFSET MAX I 24 TIMMAR!");
                            System.out.println("Ange id om du är medlem, annars skriv (0)");
                            int id6 = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Ange namn på golfset du vill boka: ");
                            String setName6 = scanner.nextLine();

                            Item chosen = null;
                            for (Item item : inventory.getItems()) {
                                if (item.getName().equalsIgnoreCase(setName6)) {
                                    chosen = item;
                                    break;
                                }
                            }

                            if (chosen == null) {
                                System.out.println("Setet finns inte, försök igen!");
                                continue;
                            }

                            double basePrice = 500;
                            double finalPrice = basePrice;

                            Member member6 = null; // deklarera utanför if-satsen
                            if (id6 != 0) {
                                member6 = registry.findId(id6);
                                if (member6 != null) {
                                    member6.BookingCount();

                                    PricePolicy policy = null;
                                    String level = member6.getLevel();
                                    member6.addHistory("Bokat: " + setName6);
                                    registry.addHistory("Bokat: " + setName6);

                                    switch (level.toLowerCase()) {
                                        case "brons": policy = new Brons(); break;
                                        case "silver": policy = new Silver(); break;
                                        case "guld": policy = new Guld(); break;
                                        default: System.out.println("Ej medlem, fullpris.");
                                    }

                                    if (policy != null) {
                                        finalPrice = policy.calculatePrice(basePrice);
                                        System.out.println("Medlemsnivå: " + policy.getLevelName());
                                    }
                                } else {
                                    System.out.println("Ej medlem, fullpris.");
                                }
                            }

                            // Skapa rental oavsett medlem eller ej
                            Rental newRental = new Rental(member6, chosen, java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusHours(24), true, finalPrice);
                            rentalRegistry.addRental(newRental);

                            System.out.println("Bokning klar för " + chosen.getName());
                            System.out.println("Pris: " + finalPrice + " kr");
                            System.out.println();
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Skriv id i tal!");
                            scanner.nextLine();
                        } catch (Exception e) {
                            System.out.println("Skriv set namn med bokstäver");
                        }
                    }
                    break;

                //Avsluta bokning
                case 7:
                    while (true) {
                        try {

                            System.out.println("Ange id om du är medlem, annars skriv (0)");
                            int id7 = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Ange namn på golfset du vill återlämna: ");
                            String setName7 = scanner.nextLine();

                            Item returned = null;
                            for(Item item : inventory.getItems()){
                                if(item.getName().equalsIgnoreCase(setName7)){
                                    returned = item;
                                    break;
                                }

                            }
                            if(returned == null){
                                System.out.print("Setet finns inte, försök igen!");
                                continue;
                            }

                            if(id7 != 0){
                                Member member7 = registry.findId(id7);
                                if(member7 != null) {

                                    member7.addHistory("Återlämnat: " + setName7);
                                    registry.addHistory("Återlämnat: " + setName7);

                                    System.out.println("Tack " + member7.getName() + " för denna gång");
                                    System.out.println("Välkommen åter!");
                                    System.out.println();


                                }else{
                                    System.out.println("Tack för denna gång!");
                                    System.out.println("Välkommen åter!");
                                    System.out.println();
                                }
                            }else{
                                System.out.println("Tack för denna gång!");
                            }
                            break;

                        } catch (Exception e) {
                            System.out.println("Har du skrivit rätt??");
                        }
                    }break;
                //Intäkter
                case 8:
                    double totalIncome = 0;
                    for (Rental r : rentalRegistry.getAllRentals()) {
                        totalIncome += r.getTotalPrice();
                    }
                    System.out.println("Totala intäkter: " + totalIncome + " kr");
                    break;


                case 9:
                    System.out.println("Välkommen åter!");
                    run = false;
                    break;
                default:
                    System.out.println("Skriva ett tal 1-10");
            }


        }



    }
}