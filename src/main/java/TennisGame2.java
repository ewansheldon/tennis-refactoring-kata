
public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
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
            score = lowDrawScore(score);
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

    private String p1WinningNotToLove() {
        String score;
        if (P1point == 2)
            P1res = "Thirty";
        if (P1point == 3)
            P1res = "Forty";
        if (P2point == 0)
            P2res = "Love";
        if (P2point == 1)
            P2res = "Fifteen";
        if (P2point == 2)
            P2res = "Thirty";
        score = P1res + "-" + P2res;
        return score;
    }

    private String p2ToLove() {
        String score;
        if (P2point == 1)
            P2res = "Fifteen";
        if (P2point == 2)
            P2res = "Thirty";
        if (P2point == 3)
            P2res = "Forty";

        P1res = "Love";
        score = P1res + "-" + P2res;
        return score;
    }

    private String p1ToLove() {
        String score;
        if (P1point == 1)
            P1res = "Fifteen";
        if (P1point == 2)
            P1res = "Thirty";
        if (P1point == 3)
            P1res = "Forty";

        P2res = "Love";
        score = P1res + "-" + P2res;
        return score;
    }

    private String draw() {
        return "Deuce";
    }

    private String lowDrawScore(String score) {
        if (P1point == 0)
            score = "Love";
        if (P1point == 1)
            score = "Fifteen";
        if (P1point == 2)
            score = "Thirty";
        score += "-All";
        return score;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }

    private void P1Score() {
        P1point++;
    }

    private void P2Score() {
        P2point++;
    }
}