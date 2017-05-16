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
	Integer dTS = distToStart + distToGoal;
	Integer dTG = distToGoal;
	Integer oDTS = other.distToStart + other.distToGoal;
	Integer oDTG = other.distToGoal;
	if (aStar) return dTS.compareTo(oDTS);
	return dTG.compareTo(oDTG);
    }
    /*public static void main(String[] args) {
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);
	Location aaa = null;
	Location blah = new Location(0, 0, aaa, 0, 2000000);
	Location test = new Location(0, 0, blah, 0, a, true);
	Location test1 = new Location(10, 10, blah, 100000000, b, false);
	System.out.println(test.compareTo(test1));
        test = new Location(0, 0, blah, 0, a, false);
	System.out.println(test.compareTo(test1));
	}*/
}
