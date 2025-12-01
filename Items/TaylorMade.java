package Items;

import java.util.ArrayList;
import java.util.List;

public class TaylorMade extends Item {

    public TaylorMade(){
        super("TaylorMade", 500, new ArrayList<>());
        List<String> clubs = new ArrayList<>();
        clubs.add("Driver: Qi35 Max Designer Series Driver");
        clubs.add("3 wood: Qi35 Max Fairway");
        clubs.add("5 wood: Qi35 Max Fairway");
        clubs.add("4 - P: P·7CB Battle Worn Irons");
        clubs.add("52, 56, 60: Hi-Toe 4 Wedge");
        clubs.add("Putter: Spider Tour X");

        setClubs(clubs);
    }

    @Override
    public void ShowInfo(){
        System.out.println("Golfset : " + getName());
        System.out.println("Märke: TaylorMade");
        System.out.println("Pris: " + getPrice());
        System.out.println("Klubbor i setet:");
        for (String club : getClubs()){
            System.out.println(club);
            System.out.println();
        }
    }

}
