package projectmyteam;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Database {
    private static HashMap<String, Account> users = new HashMap<>();
    private static final String FILE_PATH = "users_encrypted.json";
    private static final Gson gson = new Gson();

    static {
        loadUsers();
    }

    public static boolean registerUser(String username, String password) {
        if (users.containsKey(username)) return false;
        users.put(username, new Account(username, password));
        saveUsers(); 
        return true;
    }

    public static Account authenticate(String username, String password) {
        Account user = users.get(username);
        return (user != null && user.checkPassword(password)) ? user : null;
    }

    public static void saveUsers() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            String jsonData = gson.toJson(users);
            String encryptedData = EncryptionUtil.encrypt(jsonData);
            writer.write(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String encryptedData = reader.readLine();
            if (encryptedData != null) {
                String jsonData = EncryptionUtil.decrypt(encryptedData);
                Type type = new TypeToken<HashMap<String, Account>>() {}.getType();
                users = gson.fromJson(jsonData, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (users == null) users = new HashMap<>(); 
    }
}