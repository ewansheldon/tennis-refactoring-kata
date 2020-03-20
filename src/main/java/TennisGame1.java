
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return drawScore();
        }
        if (m_score1 >= 4 || m_score2 >= 4) {
            return advantageOrWinningScore();
        }
        return scores[m_score1] + "-" + scores[m_score2];
    }

    private String advantageOrWinningScore() {
        int diff = Math.abs(m_score1 - m_score2);
        return diff == 1 ? advantageScore() : winningScore();
    }

    private String winningScore() {
        return m_score1 > m_score2 ? "Win for player1" : "Win for player2";
    }

    private String advantageScore() {
        return m_score1 > m_score2 ? "Advantage player1" : "Advantage player2";
    }

    private String drawScore() {
        String score;
        switch (m_score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
