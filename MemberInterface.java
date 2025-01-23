import java.util.Scanner;

public class MemberInterface  {
    private Scanner scanner=new Scanner(System.in);
    private MemberManager memberManager=new MemberManager();

    private UserInterface userInterface;

        public void setUserInterface(UserInterface userInterface){
        this.userInterface=userInterface;
    }

    public void memberStart() {
                while (true) {
            System.out.println("""
                    =======================================================================

                    Member Options:
                    1. Sign up new member.
                    2. Edit existing member.
                    3. Find a member's email by their name.
                    4. Find a member's name by their email.
                    5. Member list.
                    6. Delete member.
                    7. Back to main menu.
                    8. Quit program.

                    Choose option: \s""");
            String input = scanner.nextLine();

            inputReader(input);
        }
    }


    public void inputReader(String input) {
        switch (input) {
            case "1" -> signUp();
            case "2" -> editMember();
            case "3" -> searchByName();
            case "4" -> searchByEmail();
            case "5" -> listMembers();
            case "6" -> deleteMember();
            case "7" -> userInterface.userStart();
            case "8" -> {
                System.out.println("""
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                System.exit(0);
            }
            default -> System.out.println("Invalid entry!");
        }
    }

    public void signUp() {
        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        Member newMember=new Member(name,email);
        memberManager.addMember(newMember);
    }

    public void listMembers(){
        System.out.println("Listing all members: ");
        int number=1;
        for(Member m:memberManager.getAllMembers()){
            System.out.println(number+" Name: "+m.getName()+", Email: "+m.getEmail());
            number++;
        }
    }

    public void searchByName(){
        System.out.println("Search for (name): ");
        String searchedName = scanner.nextLine();
        System.out.println(memberManager.findByName(searchedName));
    }

    public void searchByEmail(){
        System.out.println("Search for (email): ");
        String searchedEmail = scanner.nextLine();
        System.out.println(memberManager.findByEmail(searchedEmail));
    }

    public void editMember(){
        System.out.println("Enter email of the member to edit: ");
        String email = scanner.nextLine();
        System.out.println(memberManager.editExistingMember(email));
    }

    public void deleteMember(){
        System.out.println("Enter email of the member to delete: ");
        String email = scanner.nextLine();
        System.out.println(memberManager.deleteMember(email));
    }



}
