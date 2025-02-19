package projectmyteam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User {
    private String username;
    private String passwordHash;
    private double balance;

    public User(String username, String password, double balance) {
        if ((username != null && !username.trim().isEmpty()) && (password != null && !password.trim().isEmpty())) {
            this.username = username;
            this.passwordHash = hashPassword(password);
            this.balance = balance;
        } 
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public String getUsername() { 
        return username; 
    }

    public boolean checkPassword(String password) {
        return passwordHash.equals(hashPassword(password));
    }

    public double getBalance() { 
        return balance; 
    }

    public void addBalance(double amount) {
        if (amount > 0) {
            this.balance += amount;
            Database.saveUsers();
        } 
    }

    public void removeBalance(double amount) {
        if (amount < balance) {
            this.balance -= amount;
            Database.saveUsers();
        }
    }
}