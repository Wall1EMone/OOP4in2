package Members;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MemberRegistry {
    private List<Member> members;

    public MemberRegistry(){
        this.members = new ArrayList<>();
        members.add(new Member("Mone","Larsson","mone.larsson@outlook.com"));
        members.add(new Member("Bella", "Larsson","bella.larsson@outlook.com"));
        members.add(new Member("Soukanya", "Larsson","soukanya.larsson@outlook.com"));
    }

    public MemberRegistry(List<String> history, List<Member> members){
        this.members = members;
    }


    public List<Member> all(){//Skriva ut alla medlemmar
        return members;
    }
    public void setMembers(List<Member> members){
        this.members = members;
    }

}
