import java.util.*;
import java.io.*;
public class MazeSolver {
    private MyHeap frontier;
    private Maze maze;
    public MazeSolver(String filename) {
	this(filename,false);
    }
    public MazeSolver(String filename, boolean animate) {
        maze = new Maze(filename);
	//place holder for animate...
    }
    public void solve() {
	solve(1);
    }
    public void solve(int style) {
	switch (style) {
	    case 0:
		//DFS
		frontier = new StackFrontier();
		break;
	    case 1:
		//BFS
		frontier = new QueueFrontier();
		break;
	    case 2:
		//BestFirst
		frontier = new FrontierPriorityQueue(false);
		break;
	    case 3:
		//A*
		frontier = new FrontierPriorityQueue(true);
		break;
	}
	frontier.add(maze.getStart());
	Location current = frontier.peek();
	while (frontier.size() > 0) {
	    if (!current.equals(maze.getEnd())) return;
	    current = frontier.next();
	    
	    frontier.remove();
	    current = frontier.peek();
	}
    }
    public String toString() {
	return maze.toString();
    }
    
}
