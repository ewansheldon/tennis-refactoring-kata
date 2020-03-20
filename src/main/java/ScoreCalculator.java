public class ScoreCalculator {
    private Player player1;
    private Player player2;

    String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public ScoreCalculator(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    String calculateScore() {
        if (player1.getPoints() == player2.getPoints()) {
            return drawScore();
        }
        if (player1.getPoints() >= 4 || player2.getPoints() >= 4) {
            return advantageOrWinningScore();
        }
        return scores[player1.getPoints()] + "-" + scores[player2.getPoints()];
    }

    String advantageOrWinningScore() {
        return getAbsPointDiff() == 1 ? advantageScore() : winningScore();
    }

    int getAbsPointDiff() {
        return Math.abs(player1.getPoints() - player2.getPoints());
    }

    boolean player1Winning() {
        return player1.getPoints() > player2.getPoints();
    }

    String winningScore() {
        return player1Winning() ? "Win for player1" : "Win for player2";
    }

    String advantageScore() {
        return player1Winning() ? "Advantage player1" : "Advantage player2";
    }

    String drawScore() {
        return player1.getPoints() < 3 ? scores[player1.getPoints()] + "-All" : "Deuce";
    }
}