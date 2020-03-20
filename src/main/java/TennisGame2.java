
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
        String score = "";
        if (P1point < 4 && P2point < 4) {
            score = lowScore();
        }

        if (P1point == P2point && P1point < 4) {
            score = lowDrawScore();
        }

        if (P1point == P2point && P1point >= 3) {
            score = draw();
        }


        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String lowScore() {
        return formatScores[P1point] + "-" + formatScores[P2point];
    }

    private String draw() {
        return "Deuce";
    }

    private String lowDrawScore() {
        return formatScores[P1point] + "-All";
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }
}