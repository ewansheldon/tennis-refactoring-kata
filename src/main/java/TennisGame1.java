
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;
    private String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        getPlayer(playerName).addPoint();
    }

    private Player getPlayer(String playerName) {
        return playerName.equals(player1.getName()) ? player1 : player2;
    }


    public String getScore() {
//    move this to separate class?
        if (player1.getPoints() == player2.getPoints()) {
            return drawScore();
        }
        if (player1.getPoints() >= 4 || player2.getPoints() >= 4) {
            return advantageOrWinningScore();
        }
        return scores[player1.getPoints()] + "-" + scores[player2.getPoints()];
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

    private String winningScore() {
        return player1Winning() ? "Win for player1" : "Win for player2";
    }

    private String advantageScore() {
        return player1Winning() ? "Advantage player1" : "Advantage player2";
    }

    private String drawScore() {
        return player1.getPoints() < 3 ? scores[player1.getPoints()] + "-All" : "Deuce";
    }
}
