package detection;

import model.Email;

public class RiskScorer {

    public int score(Email email) {
        int score = 0;

        String sender = email.getSender().toLowerCase();
        String subject = email.getSubject().toLowerCase();
        String content = email.getContent().toLowerCase();

        if (content.contains("urgent") || subject.contains("urgent")) {
            score += 2;
        }

        if (content.contains("click here") || content.contains("verify your account")) {
            score += 3;
        }

        if (sender.contains("suspicious") || sender.contains("fake")) {
            score += 4;
        }

        if (content.contains(".ru") || content.contains("bit.ly")) {
            score += 2;
        }

        return score;
    }

    public String riskLevel(int score) {
        if (score >= 7) {
            return "High";
        } else if (score >= 4) {
            return "Medium";
        } else {
            return "Low";
        }
    }
}
