
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            m_score1++;
            player1.addPoint();
        } else {
            m_score2++;
            player2.addPoint();
        }
    }

    public String getScore() {
        if (player1.getPoints() == player2.getPoints()) {
            return drawScore();
        }
        if (player1.getPoints() >= 4 || player2.getPoints() >= 4) {
            return advantageOrWinningScore();
        }
        return scores[m_score1] + "-" + scores[m_score2];
    }

    private String advantageOrWinningScore() {
        int diff = Math.abs(m_score1 - m_score2);
        return diff == 1 ? advantageScore() : winningScore();
    }

    private String winningScore() {
        return player1Winning() ? "Win for player1" : "Win for player2";
    }

    private String advantageScore() {
        return player1Winning() ? "Advantage player1" : "Advantage player2";
    }

    private boolean player1Winning() {
        return m_score1 > m_score2;
    }

    private String drawScore() {
        return m_score1 < 3 ? scores[m_score1] + "-All" : "Deuce";
    }
}
