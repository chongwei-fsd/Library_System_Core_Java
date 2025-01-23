import java.util.List;
import java.util.Scanner;

public class StaffInterface {
    private Scanner scanner = new Scanner(System.in);
    private StaffManager staffManager = new StaffManager();

    private UserInterface userInterface;

    public void setUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void staffStart() {
        while (true) {
            System.out.println("""
                    =======================================================================

                    Staff Options:
                    1. Register new staff.
                    2. Edit existing staff.
                    3. Find a staff's email by their name.
                    4. Find a staff's name by their email.
                    5. Find staffs by their role.
                    6. Staff list.
                    7. Delete staff.
                    8. Back to main menu.
                    9. Quit program.

                    Choose option: \s""");
            String input = scanner.nextLine();

            inputReader(input);
        }
    }


    public void inputReader(String input) {
        switch (input) {
            case "1" -> newStaff();
            case "2" -> editStaff();
            case "3" -> searchByName();
            case "4" -> searchByEmail();
            case "5" -> searchByRole();
            case "6" -> listStaff();
            case "7" -> deleteStaff();
            case "8" -> userInterface.userStart();
            case "9" -> {
                System.out.println("""
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                System.exit(0);
            }
            default -> System.out.println("WRONG entry!");
        }
    }

    public void newStaff() {
        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Role: ");
        String role = scanner.nextLine();

        Staff staff = new Staff(name, email, role);
        staffManager.addStaff(staff);
    }

    public void listStaff() {
        System.out.println("Listing all staff: ");
        int number = 1;
        List<Staff> s = staffManager.getAllStaff();
        if (s.isEmpty()) {
            System.out.println("No staff");
        } else {
            for (Staff st : staffManager.getAllStaff()) {
                System.out.println(number + " Name: " + st.getName() + ", Email: " + st.getEmail() + ", Role: " + st.getRole());
                number++;
            }
        }
    }

    public void editStaff() {
        System.out.println("Enter email of the staff to edit: ");
        String email = scanner.nextLine();
        System.out.println(staffManager.editExistingStaff(email));
    }

    public void searchByName() {
        System.out.println("Search for (name): ");
        String searchedName = scanner.nextLine();
        System.out.println(staffManager.findByName(searchedName));
    }

    public void searchByEmail() {
        System.out.println("Search for (email): ");
        String searchedEmail = scanner.nextLine();
        System.out.println(staffManager.findByEmail(searchedEmail));
    }

    public void deleteStaff() {
        System.out.println("Enter email of the staff to delete: ");
        String email = scanner.nextLine();
        System.out.println(staffManager.deleteStaff(email));
    }

    public void searchByRole() {
        System.out.println("Enter role of the staff to search: ");
        String role = scanner.nextLine();
        System.out.println(staffManager.searchStaffRole(role));
    }


}
