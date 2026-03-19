package detection;

import model.Email;

public class PhishingDetector {
    private RiskScorer riskScorer;

    public PhishingDetector() {
        this.riskScorer = new RiskScorer();
    }

    public int calculateRiskScore(Email email) {
        return riskScorer.score(email);
    }

    public boolean isLikelyPhishing(Email email) {
        int score = calculateRiskScore(email);
        return score >= 7;
    }

    public String generateExplanation(Email email) {
        StringBuilder explanation = new StringBuilder();
        String sender = email.getSender().toLowerCase();
        String content = email.getContent().toLowerCase();

        if (content.contains("urgent")) {
            explanation.append("- Urgent language detected\n");
        }
        if (content.contains("click here") || content.contains("verify your account")) {
            explanation.append("- Suspicious action request detected\n");
        }
        if (sender.contains("suspicious") || sender.contains("fake")) {
            explanation.append("- Suspicious sender pattern detected\n");
        }
        if (content.contains(".ru") || content.contains("bit.ly")) {
            explanation.append("- Potentially suspicious link pattern detected\n");
        }

        if (explanation.length() == 0) {
            explanation.append("- No major phishing indicators detected");
        }

        return explanation.toString();
    }
}
