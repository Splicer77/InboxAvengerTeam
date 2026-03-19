package model;

public class User {
    private String username;
    private String masterPassword;

    public User(String username, String masterPassword) {
        this.username = username;
        this.masterPassword = masterPassword;
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.masterPassword.equals(password);
    }

    public void setMasterPassword(String newPassword) {
        this.masterPassword = newPassword;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "'}";
    }
}
