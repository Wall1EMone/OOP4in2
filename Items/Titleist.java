package Items;

import java.util.ArrayList;
import java.util.List;

public class Titleist extends Item{

    public Titleist(){
        super("Titleist",500, new ArrayList<>());
        List<String> clubs = new ArrayList<>();
        clubs.add("Driver: GT2 Driver");
        clubs.add("3 wood: GT2 Fairway");
        clubs.add("5 wood: GT2 Fairway");
        clubs.add("4 - P: T150");
        clubs.add("52, 56, 60: Vokey SM10");
        clubs.add("Putter: Studio Style Newport");

        setClubs(clubs);
    }
    @Override
    public void ShowInfo(){
        System.out.println("Golfset : " + getName());
        System.out.println("Märke: Titleist");
        System.out.println("Pris: " + getPrice());
        System.out.println("Klubbor i setet:");
        for (String club : getClubs()){
            System.out.println(club);
            System.out.println();
        }
    }
}
