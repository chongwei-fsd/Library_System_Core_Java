import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberManager {
    private Scanner scanner=new Scanner(System.in);
    private List<Member>members=new ArrayList<>();

    public void addMember(Member member){
        members.add(member);
    }

    public List<Member>getAllMembers(){
        return members;
    }

    public String findByName(String name){
        for(Member m:members){
            if(m.getName().equals(name)){
                return m.getEmail();
            }
        }
        return "Member's name not found";
    }

    public String findByEmail(String email){
        for(Member m:members){
            if(m.getEmail().equals(email)){
                return m.getName();
            }
        }
        return "Member's email not found";
    }

    public String editExistingMember(String email){
        for(Member m:members){
           if(m.getEmail().equals(email)){
               System.out.println("Enter new name");
               String newName = scanner.nextLine();

               System.out.println("Enter new email");
               String newEmail = scanner.nextLine();

               m.setName(newName);
               m.setEmail(newEmail);
               return "Member has been updated";
           }
        }
        return "Member's email not found";
    }

    public String deleteMember(String email){
        boolean wasRemoved=members.removeIf(m->m.getEmail().equals(email));
        if(wasRemoved){
           return "Member deleted successfully";
        }else{
            return "Member's email not found";
        }
    }



}
