package Items;

import java.util.ArrayList;
import java.util.List;

public class Cobra extends Item {

    public Cobra(){
        super("Cobra", 500,new ArrayList<>());
        List<String> clubs = new ArrayList<>();
        clubs.add("Driver: DS-ADAPT MAX-K Driver ");
        clubs.add("3 wood: DS-ADAPT X Fairway");
        clubs.add("5 wood: DS-ADAPT X Fairway");
        clubs.add("4 - P: KING Tour Irons");
        clubs.add("50,54, 58: KING Black Wedge");
        clubs.add("Putter: Sport-40 Vintage Putter");

        setClubs(clubs);
    }
    @Override
    public void ShowInfo(){
        System.out.println("Golfset : " + getName());
        System.out.println("Märke: Cobra");
        System.out.println("Pris: " + getPrice());
        System.out.println("Klubbor i setet:");
        for (String club : getClubs()){
            System.out.println(club);
            System.out.println();
        }

    }
}
