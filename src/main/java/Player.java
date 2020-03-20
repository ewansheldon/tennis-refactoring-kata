public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.points = 0;
        this.name = name;
    }

    public void addPoint() {
        points++;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}
