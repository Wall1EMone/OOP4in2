package Items;

import java.util.ArrayList;
import java.util.List;

public class Callaway extends Item {

    public Callaway(){
        super("Callaway",500, new ArrayList<>());
        List<String> clubs = new ArrayList<>();
        clubs.add("Driver: Paradym Drivers");
        clubs.add("3 wood: Paradym Fairway Woods");
        clubs.add("5 wood: Paradym Fairway Woods");
        clubs.add("4 - P: Paradym Irons");
        clubs.add("52, 56, 60: Opus SP Black Shadow Wedge ");
        clubs.add("Putter: Eleven Tour Lined S Putter ");

        setClubs(clubs);
    }

    @Override
    public void ShowInfo() {
        System.out.println("Golfset: " + getName());
        System.out.println("Märke: Callaway");
        System.out.println("Pris: " + getPrice());
        System.out.println("Klubbor i setet:");
        for(String club : getClubs()){
            System.out.println(club);
            System.out.println();
        }
    }
}
