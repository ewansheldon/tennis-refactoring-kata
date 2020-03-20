public class ScoreCalculator {
    public static final int WIN_THRESHOLD = 4;
    private Player player1;
    private Player player2;

    private String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public ScoreCalculator(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String calculateScore() {
        if (isDraw()) {
            return drawScore();
        }
        if (isLowScore()) {
            return lowScore();
        }
        return advantageOrWinningScore();
    }

    private boolean isDraw() {
        return player1.getPoints() == player2.getPoints();
    }

    private boolean isLowScore() {
        return player1.getPoints() < WIN_THRESHOLD && player2.getPoints() < WIN_THRESHOLD;
    }

    private String advantageOrWinningScore() {
        return getAbsPointDiff() == 1 ? advantageScore() : winningScore();
    }

    private int getAbsPointDiff() {
        return Math.abs(player1.getPoints() - player2.getPoints());
    }

    private boolean player1Winning() {
        return player1.getPoints() > player2.getPoints();
    }

    private String drawScore() {
        return player1.getPoints() < 3 ? scores[player1.getPoints()] + "-All" : "Deuce";
    }

    private String lowScore() {
        return scores[player1.getPoints()] + "-" + scores[player2.getPoints()];
    }

    private String winningScore() {
        return player1Winning() ? "Win for player1" : "Win for player2";
    }

    private String advantageScore() {
        return player1Winning() ? "Advantage player1" : "Advantage player2";
    }

}