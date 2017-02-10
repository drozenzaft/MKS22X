/*Squares have 3 states: 
	- In danger (1)
	- Safe space (0)
	- Has queen (-1)
	Queens can only be placed on zeroes.
	The board is a 2D int arry because if, say, two queens endanger the same square, then the square's number will be (1 + 1) = 2. That way, if you decide to remove a queen, you can subtract 1 from the value and the square will still be in danger.
	So if you add a queen, then you subtract 1 from the value.
	So, to summarize, if the value of a square is:
		-1, then there is a queen there.
		 0, then it is safe.
		 > 0, then it is endangered.*/

public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    public QueenBoard(int size){
	board = new int[size][size];
    }

    public boolean solve() {
	return solveH(0):
    }

    private boolean solveH(int col) {
	x = col;
	while (cannotPlaceQueen(col,col) && col < boardLength) {
	    return solveH(col,col+1) || solveH(col+1,col);
	} 
	if (col < boardLength) {
	    addQueen(col,col);
	}
	else {
	    //use an arraylist to keep track of all places where queens have been placed
	    //if solveH returns false, then use the arraylist to removeQueen on all of the squares with queens on them, and then clear the arraylist and increment col by 1.
	    //so at the end: solveH(x + 1);
	}	
    }
    
  public int getSolutionCount() {
    if (solutionWasFound) {
       return solutionCount;
    }
    else {
	return -1;
    }
  }

  private void addQueen(int r, int c) {
    board[r][c]++;
    for (int row = 0; row < boardLength; row++) {
	for (int col = 0; col < boardLength; col++) {
	    if (thisQueenAttacksMe) {
		board[row][col]++;
	    }
	}
    }
  }
    
  private void removeQueen(int r, int c) {
    board[r][c]++;
    for (int row = 0; row < boardLength; row++) {
	for (int col = 0; col < boardLength; col++) {
	    if (thisQueenAttackedMe) {
		board[row][col]--;
	    }
	}
    }
  }
    
    
  public String toString() {
      String ans = "";
      for (int r = 0; r < boardLength; r++) {
	  for (int c = 0; c < boardLength; c++) {
	      //if there's a queen, add a Q. otherwise, add an underscore.
	      //add a space before the next Q/underscore, unless it's the last square on the board, then you should add a new line.
	      //sorry if this is too codey and not really pseudocodey!
	      if (board[r][c] == -1) {
		  ans += "Q";
	      }
	      else {
		  ans += "_";
	      }
	      if (c < boardLength - 1) {
		  ans += " ";
	      }
	      else {
		  ans += "\n";
	      }
	  }
      }
  }
}		  
	    
