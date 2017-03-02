import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate;
    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
        animate = false;
	try {
	    Scanner mazeScan = new Scanner(new File(filename));
	    int i = 0;
	    int j = 0;
	    String line = "";
	    while (mazeScan.hasNextLine()) {
		i++;
		line = mazeScan.nextLine();
		if (j == 0) j = line.length();
	    }
	    maze = new char[i][j];
	    //System.out.println(i+","+j+"!!!!");
	    i = 0;
	    mazeScan = new Scanner(new File(filename));
	    while (mazeScan.hasNextLine()) {
		line = mazeScan.nextLine();
		//System.out.println("'"+line+"'");
		//System.out.println(line.length()+","+maze[i].length);
		for (int c = 0; c < line.length(); c++) {
		    //System.out.println(maze[i][c]);
		    maze[i][c] = line.charAt(c);
		}
		i++;
	    }
	}
	catch (FileNotFoundException e) {
	    System.out.println("Maze not found! Please insert a valid maze file!");
	    System.exit(1);
	}
    }

    public String name() {
	return "Rozenzaft,Daniel";
    }

    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int[] s = findS();
	int startr = s[0];
	int startc = s[1];
            //Initialize starting row and startint col with the location of the S. 
	maze[startr][startc] = ' ';//erase the S, and start solving!
	return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (maze[row][col] == 'E') {
	    return true;
	}
	if (maze[row][col] == ' ') {
	    maze[row][col] = '@';
	    if (solve(row+1,col) || solve(row-1,col) || solve(row,col+1) || solve(row,col-1)) return true;
	    maze[row][col] = '.';
	}
	return false;
    }
    
    private int[] findS() {
	int[] temp = new int[2];
	for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[r].length; c++)
		if (maze[r][c] == 'S') {
		    temp[0] = r;
		    temp[1] = c;
		}
	}
	return temp;
    }
    
    private String recolor(char c) {
	int which = 0;
	if (c == '@') which = 36;
	if (c == ' ') which = 37;
	if (c == '.') which = 31;
	return (char)27 + "[" + which + "m" + c + (char)27 + "[0m";
    } 

    public String toString() {
	String ans = "";
	for (int i = 0; i < maze.length; i++) {
	    for (int j = 0; j < maze[i].length; j++) {
		ans += maze[i][j];
		if (j == maze[i].length - 1) ans += "\n";
	    }
	}
	return ans;
    }
}
