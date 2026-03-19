package app;

import detection.PhishingDetector;
import detection.RiskScorer;
import model.Email;
import model.PasswordEntry;
import model.User;
import security.EncryptionManager;
import security.PasswordVault;

public class Main {
    public static void main(String[] args) {
        // Basic user setup
        User user = new User("jordan", "wolf123");
        System.out.println("User created: " + user);
        System.out.println("Authentication success: " + user.authenticate("wolf123"));
        System.out.println();

        // Password vault demo
        PasswordVault vault = new PasswordVault();
        vault.addEntry(new PasswordEntry("gmail.com", "jordan@gmail.com", "Alpha123!"));
        vault.addEntry(new PasswordEntry("discord.com", "nightwolf", "Alpha123!"));
        vault.addEntry(new PasswordEntry("canvas.asu.edu", "jwishom", "Secure456!"));

        System.out.println("Vault entries:");
        vault.displayEntries();
        System.out.println("Password reuse detected: " + vault.hasPasswordReuse("Alpha123!"));
        System.out.println();

        // Placeholder encryption demo
        EncryptionManager encryptionManager = new EncryptionManager();
        String encoded = encryptionManager.encode("MySecretPassword");
        String decoded = encryptionManager.decode(encoded);
        System.out.println("Encoded sample: " + encoded);
        System.out.println("Decoded sample: " + decoded);
        System.out.println();

        // Email and phishing detection demo
        Email email = new Email(
                "fake@suspicious.com",
                "Urgent: Verify Your Account",
                "Click here now to verify your account using bit.ly/some-link"
        );

        PhishingDetector detector = new PhishingDetector();
        RiskScorer scorer = new RiskScorer();

        int riskScore = detector.calculateRiskScore(email);
        String riskLevel = scorer.riskLevel(riskScore);

        System.out.println("Email analyzed: " + email);
        System.out.println("Risk Score: " + riskScore);
        System.out.println("Risk Level: " + riskLevel);
        System.out.println("Likely phishing: " + detector.isLikelyPhishing(email));
        System.out.println("Explanation:\n" + detector.generateExplanation(email));
    }
}
