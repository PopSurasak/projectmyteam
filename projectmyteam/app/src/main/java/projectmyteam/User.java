package projectmyteam;

public class User {
    private String username;
    private String password;
    private double balance;

    public User(String username, String password, double balance) {
        if (username != null && !username.trim().isEmpty()) && (password != null && !password.trim().isEmpty()) {
            this.username = username;
            this.password = password;
            this.balance = balance;
        } else {
            System.out.println("Invalid");
        }
    }

    public void addBalance(double amount) {
        if (amount > 0) {
            this.balance += amount;
            Database.saveUsers();
        } else {
            System.out.println("Invalid");
        }
    }

    public void removeBalance(double amount) {
        if (amount < balance) {
            this.balance -= amount;
            Database.saveUsers();
        } else {
            System.out.println("Invalid");
        }
    }
}
