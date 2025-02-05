package projectmyteam;

public class User {
    private String username;
    private float userBalance;

    public User(String username, float balance) {
        if (username != null && !username.trim().isEmpty()) {
            this.username = username;
        } else {
            System.out.println("Invalid username.");
        }

        if (balance >= 0) {
            this.userBalance = balance;
        } else {
            System.out.println("Imagine having negative balance");
            this.userBalance = balance;
        }
    }

    public void changeName(String username) {
        if (username != null && !username.trim().isEmpty()) {
            this.username = username;
        } else {
            System.out.println("So your name is empty?");
        }
    }

    public void addBalance(float balance) {
        if (balance > 0) {
            this.userBalance += balance;
        } else {
            System.out.println("What are you doing?");
        }
    }

    public void printUserInfo() {
        System.out.println("Username: " + username);
        System.out.println("Balance: $" + userBalance);
    }
}
