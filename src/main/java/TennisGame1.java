
public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;
    private final Score score;

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        score = new Score(player1, player2);
    }

    public void wonPoint(String playerName) {
        getPlayer(playerName).addPoint();
    }

    private Player getPlayer(String playerName) {
        return playerName.equals(player1.name) ? player1 : player2;
    }

    public String getScore() {
        return score.calculate();
    }
}
