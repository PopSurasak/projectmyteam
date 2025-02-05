package projectmyteam;

public class Account {
    private String username;
    private String password;

    public void createAccount(String username, String password) {
        if (username != null && !username.trim().isEmpty() &&
            password != null && !password.trim().isEmpty()) {
            this.username = username;
            this.password = password;
        } else {
            System.out.println("Empty like you");
        }
    }

    public boolean userLogin(String username, String password) {
        if (this.username == null || this.password == null) {
            System.out.println("No account exists.");
            return false;
        }
        return this.username.equals(username) && this.password.equals(password);
    }

    public String userCheck() {
        if (username == null) {
            return "No user logged in.";
        }
        return username.equals("admin") ? "Owner" : "Customer";
    }
}
