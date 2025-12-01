package Items;

import java.util.ArrayList;
import java.util.List;

public class Mizuno extends Item {

    public Mizuno(){
        super("Mizuno", 500, new ArrayList<>());
        List<String> clubs = new ArrayList<>();
        clubs.add("Driver: Mizuno ST-MAX 230 Driver");
        clubs.add("3 wood: Mizuno ST-MAX 230");
        clubs.add("5 wood: Mizuno ST-MAX 230");
        clubs.add("4 - P: Mizuno Pro S-3");
        clubs.add("52, 56, 60: Mizuno Pro T-3 Wedge Black");
        clubs.add("Putter: Mizuno M-Craft OMOI Putter – 04 / Black");

        setClubs(clubs);

    }

    @Override
    public void ShowInfo(){
        System.out.println("Golfset : " + getName());
        System.out.println("Märke: Mizuno");
        System.out.println("Pris: " + getPrice());
        System.out.println("Klubbor i setet:");
        for (String club : getClubs()){
            System.out.println(club);
            System.out.println();
        }

    }
}
