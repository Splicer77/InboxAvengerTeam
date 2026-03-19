package security;

import java.util.ArrayList;
import java.util.List;
import model.PasswordEntry;

public class PasswordVault {
    private List<PasswordEntry> entries;

    public PasswordVault() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(PasswordEntry entry) {
        entries.add(entry);
    }

    public List<PasswordEntry> getEntries() {
        return entries;
    }

    public PasswordEntry findByWebsite(String website) {
        for (PasswordEntry entry : entries) {
            if (entry.getWebsite().equalsIgnoreCase(website)) {
                return entry;
            }
        }
        return null;
    }

    public boolean hasPasswordReuse(String password) {
        int count = 0;
        for (PasswordEntry entry : entries) {
            if (entry.getPassword().equals(password)) {
                count++;
            }
        }
        return count > 1;
    }

    public void displayEntries() {
        for (PasswordEntry entry : entries) {
            System.out.println(entry);
        }
    }
}
