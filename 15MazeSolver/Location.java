import java.util.*;
public class Location implements Comparable<Location> {
    private int row;
    private int col;
    private Location previous;
    private int distToStart;
    private int distToGoal;
    private boolean aStar;
    public Location(int r, int c, Location previous, int distToStart, int distToGoal) {
        row = r;
	col = c;
	aStar = false;
        this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
    }
    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar) {
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToGoal;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }
    public int compareTo(Location other) {
	if (aStar) return (previous.distToGoal + distToGoal).compareTo(other.distToGoal+other.previous.distToGoal);
	return distToGoal.compareTo(other.distToGoal);
    }
}
