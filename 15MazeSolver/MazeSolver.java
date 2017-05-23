import java.util.*;
import java.io.*;
public class MazeSolver {
    private Maze maze;
    private boolean animate,aStar;
    public MazeSolver(String filename) {
	this(filename,false);
    }
    public MazeSolver(String filename, boolean animate) {
        maze = new Maze(filename);
	aStar = false;
	this.animate = animate;
    }
    private ArrayList<Location> getNeighbors(Location current) {
	ArrayList<Location> ans = new ArrayList<Location>();
	int x = current.getX();
	int y = current.getY();
	int sx = maze.getStart().getX();
	int ex = maze.getEnd().getX();
	int sy = maze.getStart().getY();
	int ey = maze.getEnd().getY();
	int newX = 0;
	int newY = 0;
	//ugly method sorry!
	try {
	    newX = x-1;
	    if (maze.get(newX,y) != '#') {
		ans.add(new Location(newX,y,current,Math.abs(newX-sx), Math.abs(newX-ex),aStar));
		maze.set(newX,y,'?');
	    }
	}
	catch (IndexOutOfBoundsException e) {}
	try {
	    newX = x+1;
	    if (maze.get(newX,y) == ' ') {
		ans.add(new Location(newX,y,current,Math.abs(newX-sx), Math.abs(newX-ex),aStar));
		maze.set(newX,y,'?');
	    }
	}
	catch (IndexOutOfBoundsException e) {}
	try {
	    newY = y-1;
	    if (maze.get(x,newY) == ' ') {
		ans.add(new Location(x,newY,current,Math.abs(newY-sy), Math.abs(newY-ey),aStar));
		maze.set(x,newY,'?');
	    }
	}
	catch (IndexOutOfBoundsException e) {}
	try {
	    newY = y+1;
	    if (maze.get(x,newY) == ' ') {
		ans.add(new Location(x,newY,current,Math.abs(newY-sy), Math.abs(newY-ey),aStar));
		maze.set(x,newY,'?');
	    }
	}
	catch (IndexOutOfBoundsException e) {}
	return ans;
    }
    public void solve() {
	solve(1);
    }
    public void solve(int style) {
	Frontier frontier = new StackFrontier();
	if (style == 0) frontier = new StackFrontier(); //DFS
	if (style == 1) frontier = new QueueFrontier(); //BFS
	if (style == 2) frontier = new FrontierPriorityQueue(false); //BestFirst
	if (style == 3) {
	    frontier = new FrontierPriorityQueue(true);
	    aStar = true;
	}//A*
	Location current = maze.getStart();;
	frontier.add(current);
	while (frontier.size() > 0) {
	    maze.set(current.getX(), current.getY(), '.');
	    current = frontier.next();
	    if (current.equals(maze.getEnd())) {
		traceBack(current);
		return;
	    }
	    //System.out.println(current.getX() + "," + current.getY());
	    maze.set(current.getX(), current.getY(), '.');
	    for (Location n : getNeighbors(current)) {
		frontier.add(n);
	    }
	    if (animate) {
		try {
		    Thread.sleep(1000);
		}
		catch (InterruptedException e) {}
		System.out.println(this);
	    }
	}
    }
    private void traceBack(Location current) {
	Location prev = current.getPrevious();
	while (!maze.getStart().equals(prev)) {
	    maze.set(prev.getX(), prev.getY(), '@');
	    prev = prev.getPrevious();
	}
    }
    public String toString() {
	maze.set(maze.getStart().getX(), maze.getStart().getY(), 'S');
	maze.set(maze.getEnd().getX(), maze.getEnd().getY(), 'E');
	return maze.toString();
    }
    public static void main(String[] args) {
	MazeSolver m = new MazeSolver(args[0]);
	m.solve(Integer.parseInt(args[1]));
	System.out.println(m);
    }
}
