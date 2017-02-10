public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    public QueenBoard(int size){
	board = new int[size][size];
    }

    public boolean solve() {
	return solveH(0):
    }

    private boolean solveH(int row, int col, boolean lastDone) {
	int x = col;
	ArrayList<Integer[]> queens = new ArrayList<Integer[]>();
	while (board[col][col] != -1 && col < board.length) {
	    return solveH(row,col+1,lastDone) || solveH(row+1,col,lastDone);
	} 
	if (col < board.length && row < board.length) {
	    addQueen(row,col);
	    queens.add(row,col);
	    if (row == board.length - 1) lastDone = true;
	    return solveH(row,col+1,lastDone) || solveH(row+1, col,lastDone);
	}
	if (row == board.length - 1 && lastDone) return true; 
	else {
	    removeQueen(queens.get(i)[0],queens.get(i)[1]);
	    queens.remove(i);
	    return solveH(row-1,col+1,false);
	}
	    //use an arraylist to keep track of all places where queens have been placed
	    //if solveH returns false, then use the arraylist to removeQueen on all of the squares with queens on them, and then clear the arraylist and increment col by 1.
	    //so at the end: solveH(x + 1);
	return false;	
    }
    
  public int getSolutionCount() {
      if (solutionCount > 0) return solutionCount;
      return -1;
  }

  private void addQueen(int r, int c) {
    board[r][c]++;
    for (int row = 0; row < board.length; row++) {
	for (int col = 0; col < board.length; col++) {
	    if (thisQueenAttacksMe) {
		board[row][col]++;
	    }
	}
    }
  }

    private static void rookCheck(int queenRow, int squareRow) {
	return queenRow == squareRow;
    }
    private static boolean bishopCheck(int queenRow, int queenCol, int squareRow, int squareCol) {
	for (int row = queenRow; row < board.length, col++) {
	    for (int col = queenCol; col < board.length; col++) {
		try {
		    if (queenRow + 1 == squareRow && queenCol + 1 == squareCol && 
    
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
      for (int r = 0; r < board.length; r++) {
	  for (int c = 0; c < board.length; c++) {
	      //if there's a queen, add a Q. otherwise, add an underscore.
	      //add a space before the next Q/underscore, unless it's the last square on the board, then you should add a new line.
	      //sorry if this is too codey and not really pseudocodey!
	      if (board[r][c] == -1) {
		  ans += "Q";
	      }
	      else {
		  ans += "_";
	      }
	      if (c < board.length - 1) {
		  ans += " ";
	      }
	      else {
		  ans += "\n";
	      }
	  }
      }
  }
}
