package projectmyteam;

public class Worker {
    private String name;
    private String role;

    public Worker(String name) {
        this.name = name;
        this.role = "Unassigned"; 
    }

    public void assignRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public String getName() {
        return this.name;
    }
}