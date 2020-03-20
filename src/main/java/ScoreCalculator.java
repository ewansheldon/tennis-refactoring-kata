public class ScoreCalculator {
    public static final int LOW_SCORE_TRESHOLD = 3;
    public static final String ADVANTAGE = "Advantage ";
    public static final String WIN_FOR = "Win for ";
    public static final String DEUCE = "Deuce";
    public static final String ALL = "-All";
    private Player player1;
    private Player player2;

    private String[] scoreName = {"Love", "Fifteen", "Thirty", "Forty"};

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
        return player1.getPoints() <= LOW_SCORE_TRESHOLD && player2.getPoints() <= LOW_SCORE_TRESHOLD;
    }

    private String advantageOrWinningScore() {
        return getAbsPointDiff() == 1 ? advantageScore() : winningScore();
    }

    private int getAbsPointDiff() {
        return Math.abs(player1.getPoints() - player2.getPoints());
    }

    private Player winningPlayer() {
        return player1.getPoints() > player2.getPoints() ? player1 : player2;
    }

    private String drawScore() {
        return player1.getPoints() < LOW_SCORE_TRESHOLD ? scoreName[player1.getPoints()] + ALL : DEUCE;
    }

    private String lowScore() {
        return scoreName[player1.getPoints()] + "-" + scoreName[player2.getPoints()];
    }

    private String winningScore() {
        return WIN_FOR + winningPlayer().name;
    }

    private String advantageScore() {
        return ADVANTAGE + winningPlayer().name;
    }
}