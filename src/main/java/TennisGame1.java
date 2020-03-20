
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;
    private final ScoreCalculator scoreCalculator;

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        scoreCalculator = new ScoreCalculator(player1, player2);
    }

    public void wonPoint(String playerName) {
        getPlayer(playerName).addPoint();
    }

    private Player getPlayer(String playerName) {
        return playerName.equals(player1.getName()) ? player1 : player2;
    }

    public String getScore() {
        return scoreCalculator.calculateScore();
    }
}
