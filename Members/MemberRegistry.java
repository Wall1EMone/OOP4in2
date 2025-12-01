package Members;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MemberRegistry {
    private List<Member> members;
    private List<String> history;

    public MemberRegistry(){
        this.members = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public MemberRegistry(List<String> history, List<Member> members){
        this.members = members;
        this.history = history;
    }

    public void add(Member member){
        members.add(member);
    }
    public Member findId(int id){
        for (Member m : members){
            if (m.getId()== id){
                return m;
            }
        }
        return null;
    }
    public int nextID(){//skapar ny id basera på hur många medlemmar det finns.
        return members.size() + 1;
    }
    public List<Member> all(){//Skriva ut alla medlemmar
        return members;
    }
    public void setHistory(List<String> history){
        this.history = history;
    }
    public void addHistory(String input){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SS");// noga med att "yyyy-MM-dd hh:mm:ss:SS" ska vara exakt så, annars blir siffror fel!
        String timeS = LocalDateTime.now().format(formatter);
        history.add("[" + timeS + "] " + input);
        //    history.add("[" + java.time.LocalDateTime.now().toString().replace("T", " ") + "] " + input);//Tar även bort T och ersätter med mellanslag
    }
    public List<String> getHistory(){
        return history;
    }
    public void showAllHistory(){
        for(Member m: members){
            System.out.println("Medlem ID " + m.getId() + " " + m.getName() + " " + m.getLastname());
            for(String h : m.getHistory()){
                System.out.println(" " + h);
                System.out.println();
            }
        }
    }

}
