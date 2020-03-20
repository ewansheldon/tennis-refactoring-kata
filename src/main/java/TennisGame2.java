
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    private String player1Name;
    private String player2Name;
    private String[] formatScores = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (P1point == P2point) {
            return draw();
        }

        if (P1point < 4 && P2point < 4) {
            return lowScore();
        }

        if (Math.abs(P1point - P2point) >= 2) {
            return winningScore();
        }

        return advantageScore();
    }

    private String advantageScore() {
        return "Advantage " + winningPlayer();
    }

    private String winningScore() {
        return "Win for " + winningPlayer();
    }

    private String winningPlayer() {
        return P1point > P2point ? player1Name : player2Name;
    }

    private String lowScore() {
        return formatScores[P1point] + "-" + formatScores[P2point];
    }

    private String draw() {
        return P1point >= 3 ? "Deuce" : formatScores[P1point] + "-All";
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1point++;
        else
            P2point++;
    }
}