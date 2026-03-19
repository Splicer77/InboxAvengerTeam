package security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/*
 * Starter placeholder for encryption-related logic.
 * This currently uses Base64 as a simple demonstration helper only.
 * Replace this with real AES-based encryption during implementation.
 */
public class EncryptionManager {

    public String encode(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public String decode(String encodedText) {
        byte[] decoded = Base64.getDecoder().decode(encodedText);
        return new String(decoded, StandardCharsets.UTF_8);
    }
}
