import java.util.*;
import java.io.*;

public class Travel{
    private char[][] travel;
    private int[] input;
    //make a new int[] with the first row of travel
    private boolean animate;
    /*Constructor loads a travel text file, and sets animate to false by default.
      1. The file contains a rectangular ascii travel, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The travel has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Travel(String filename){
        animate = false;
	try {
	    Scanner travelScan = new Scanner(new File(filename));
	    int i = 0;
	    int j = 0;
	    String line = "";
	    while (travelScan.hasNextLine()) {
		i++;
		line = travelScan.nextLine();
		if (j == 0) j = line.length();
	    }
	    travel = new char[i][j];
	    //System.out.println(i+","+j+"!!!!");
	    i = 0;
	    travelScan = new Scanner(new File(filename));
	    while (travelScan.hasNextLine()) {
		line = travelScan.nextLine();
		//System.out.println("'"+line+"'");
		//System.out.println(line.length()+","+travel[i].length);
		for (int c = 0; c < line.length(); c++) {
		    //System.out.println(travel[i][c]);
		    travel[i][c] = line.charAt(c);
		}
		i++;
	    }
	}
	catch (FileNotFoundException e) {
	    System.out.println("Travel not found! Please insert a valid travel file!");
	    System.exit(1);
	}
    }

    private void separate() {
	input = new int[travel.length-1];
	for (int j = 0; j < input.length; j++) 
	    input[j] = Character.getNumericValue(travel[travel.length-1]);
	char[][] temp = new int[travel.length-2][travel[travel.length-1].length];
	for (int i = 1; i < travel.length-1; i++)
	    temp[i-1] = travel[i];
	travel = temp;
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
	int startr = input[0];
	int startc = input[1];
	return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved travel has a path marked with '@' from S to E.

      Returns true when the travel is solved,
      Returns false when the travel has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col, ){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (row == input[2] && col == input[3])
	    return true;
	}
	if (travel[row][col] == '.') {
	    travel[row][col] = '@';
	    if (solve(row+1,col) || solve(row-1,col) || solve(row,col+1) || solve(row,col-1)) return true;
	    travel[row][col] = ' ';
	}
	return false;
    }
    
    private String recolor(char c) {
	int which = 0;
	if (c == '*') which = 37;
	if (c == ' ') which = 32;
	if (c == '@') which = 33;
	if (c == '.') which = 36;
	return (char)27 + "[" + which + "m" + c + (char)27 + "[0m";
    } 

    public String toString() {
	String ans = "";
	for (int i = 0; i < travel.length; i++) {
	    for (int j = 0; j < travel[i].length; j++) {
		ans += reclor(travel[i][j]);
		if (j == travel[i].length - 1) ans += "\n";
	    }
	}
	return ans;
    }
}
