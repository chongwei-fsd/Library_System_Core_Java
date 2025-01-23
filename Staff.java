public class Staff extends Member {
    private String role;

    public Staff(String name, String email, String role) {
        super(name, email);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
