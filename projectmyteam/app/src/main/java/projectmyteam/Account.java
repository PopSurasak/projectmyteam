package projectmyteam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Account {
    private String username;
    private String passwordHash;

    public Account(String username, String password) {
        if ((username != null && !username.trim().isEmpty()) && (password != null && !password.trim().isEmpty())) {
            this.username = username;
            this.passwordHash = hashPassword(password);
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
}