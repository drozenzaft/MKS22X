import java.util.Comparable;
public class Location implements Comparable<Location> {
    private int row;
    private int col;
    private int distToGoal;
    private boolean aStar;
    public Location(int x, int y) {
        row = x;
	col = y;
    }
}
