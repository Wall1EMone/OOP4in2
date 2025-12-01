package Items;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Wilson extends Item {

    public Wilson(){
        super("Wilson",500, new ArrayList<>());
        List<String> clubs = new ArrayList<>();
        clubs.add("Driver: DYNAPWR Carbon");
        clubs.add("3 wood: DYNAPWR Max Fairway Wood");
        clubs.add("5 wood: DYNAPWR Max Fairway Wood");
        clubs.add("4 - P: Wilson Staff Model® Blades");
        clubs.add("52, 56, 60: Infinite Wedge");
        clubs.add("Putter: Infinite Buckingham Putter");

        setClubs(clubs);
    }

    @Override
    public void ShowInfo(){
        System.out.println("Golfset : " + getName());
        System.out.println("Märke: Wilson");
        System.out.println("Pris: " + getPrice());
        System.out.println("Klubbor i setet:");
        for (String club : getClubs()){
            System.out.println(club);
            System.out.println();
        }
    }
}
