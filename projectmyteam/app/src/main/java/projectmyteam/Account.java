package projectmyteam;

class Account {
    private String username;
    private String password;

    public void createAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean userLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String userCheck() {
        // Placeholder for role checking (Owner/Customer)
        //return "Owner"; // or "Customer"
    }
}
