package projectmyteam;

class User {
    private String username;
    private float userBalance;

    public void changeName(String username) {
        this.username = username;
    }

    public void addBalance(float balance) {
        this.userBalance += balance;
    }
}


