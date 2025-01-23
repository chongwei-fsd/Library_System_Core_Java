import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MemberInterface memberInterface=new MemberInterface();
        StaffInterface staffInterface=new StaffInterface();

        UserInterface userInterface=new UserInterface(staffInterface,memberInterface);

        memberInterface.setUserInterface(userInterface);
        staffInterface.setUserInterface(userInterface);

        userInterface.userStart();





    }

}
