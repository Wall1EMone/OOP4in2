package Items;

import java.util.ArrayList;
import java.util.List;

public class Ping extends Item {

    public Ping(){
        super("Ping",500, new ArrayList<>());
        List<String> clubs = new ArrayList<>();
        clubs.add("Driver: G440 MAX");
        clubs.add("3 wood: G440 MAX");
        clubs.add("5 wood: G440 MAX");
        clubs.add("4 - P: G440");
        clubs.add("50, 54, 60: s159");
        clubs.add("Putter: Heppler");

        setClubs(clubs);
    }
    @Override
    public void ShowInfo(){
        System.out.println("Golfset : " + getName());
        System.out.println("Märke: Ping");
        System.out.println("Pris: " + getPrice());
        System.out.println("Klubbor i setet:");
        for (String club : getClubs()){
            System.out.println(club);
            System.out.println();
        }
    }

}
