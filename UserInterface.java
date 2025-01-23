import java.util.Scanner;

public class UserInterface   {
    private Scanner scanner=new Scanner(System.in);

    private StaffInterface staffInterface;
    private MemberInterface memberInterface;

    public UserInterface(StaffInterface staffInterface, MemberInterface memberInterface) {
        this.staffInterface = staffInterface;
        this.memberInterface = memberInterface;
    }

    public void userStart() {
        System.out.println("=======================================================================");
        while (true) {
            System.out.println("""
                    Welcome to our Library System. Please choose from the options below.
                    1. Members.
                    2. Staff.
                    3. Books.
                    4. Quit Program.
                    
                    Choose option:\s""");
            String input = scanner.nextLine();

            inputReader(input);
        }
    }

    public  void inputReader(String input) {
        switch (input) {
            case "1" -> memberInterface.memberStart();
            case "2" -> staffInterface.staffStart();
            case "4" -> {
                System.out.println("""
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                System.exit(0);
            }
            default -> System.out.println("""
                   Invalid entry!
                   =======================================================================
                    """);
        }
    }


}
