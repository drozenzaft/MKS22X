import java.util.*;
import java.io.*;
public class MazeSolver {
    private MyHeap frontier;
    private char[][] maze;
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
	    case 1:
		//BFS
		break;
	    case 2:
		//BestFirst
		break;
	    case 3:
		//A*
		break;
	}
	Location start = maze.getStart();
	Location current = frontier.peek();
	while (!current.equals(maze.getEnd()) && frontier.size() > 0) {
	    frontier.remove();
	    current = frontier.peek();
	}
    }
    public String toString() {
	return maze.toString();
    }
    
}
