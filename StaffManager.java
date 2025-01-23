import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffManager {
    private Scanner scanner=new Scanner(System.in);
    private List<Staff>staffs=new ArrayList<>();

    public void addStaff(Staff staff){
        staffs.add(staff);
    }

    public List<Staff>getAllStaff(){
        return staffs;
    }

    public String editExistingStaff(String email){
        for(Staff s:staffs){
            if(s.getEmail().equals(email)){
                System.out.println("Enter new name");
                String newName = scanner.nextLine();

                System.out.println("Enter new email");
                String newEmail = scanner.nextLine();

                s.setName(newName);
                s.setEmail(newEmail);
                return "Staff has been updated";
            }
        }
        return "Staff's email not found";
    }

    public String findByName(String name){
        for(Staff s:staffs){
            if(s.getName().equals(name)){
                return s.getEmail();
            }
        }
        return "Staff's name not found";
    }

    public String findByEmail(String email){
        for(Staff s:staffs){
            if(s.getEmail().equals(email)){
                return s.getName();
            }
        }
        return "Staff's email not found";
    }

    public String deleteStaff(String email){
        boolean wasRemoved=staffs.removeIf(s->s.getEmail().equals(email));
        if(wasRemoved){
            return "Staff deleted successfully";
        }else{
            return "Staff's email not found";
        }
    }

    public String searchStaffRole(String role) {
        for(Staff s:staffs){
            if(s.getRole().equals(role)){
                return "Name: "+s.getName()+", Email: "+s.getEmail();
            }
        }
        return role+" not found";
    }
}
