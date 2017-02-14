public class QueenBoard {
    private int[][]board;
    private int solutionCount;
    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount = -1;
    }

    public static String name() {
	return "Rozenzaft,Daniel";
    }

    public void solve() {
	solveH(0);
    }
    
    private boolean solveH(int col) {
	if (col == board.length) return true;
	for (int r = 0; r < board.length; r++) {
	    if (!check(r,col)) {
		addQueen(r,col);
		/*if (col == board.length-1) {
		    System.out.println(this);
		    }*/
		if (solveH(col+1))
		    return true;
	    }
	    removeQueen(r,col);
	    //System.out.println("remove, " +col+"\n"+this);
	}
	return col == board.length;
    }
    
     private boolean addSolutions(int col) {
	 if (solutionCount == -1) {
	     solutionCount++;
	 }
	 if (col == board.length) {
	     solutionCount++;
	     return true;
	 }
	 for (int r = 0; r < board.length; r++) {
	     if (!check(r,col)) {
		 addQueen(r,col);
		 /*if (col == board.length-1) {
		   System.out.println(this);
		   }*/
		 addSolutions(col+1);
		 removeQueen(r,col);
		 //System.out.println("remove, " +col+"\n"+this);
	     }
	 }
	 return true;
     }

    public void countSolutions() {
	addSolutions(0);
    }
	
  public int getSolutionCount() {
      return solutionCount;
  }

    private static boolean rookCheck(int queenRow, int queenCol, int squareRow, int squareCol) {
	return queenRow == squareRow || queenCol == squareCol;
    }
    
    private static boolean bishopCheck(int queenRow, int queenCol, int squareRow, int squareCol, int boardLength) {
	for (int row1 = 0; queenRow + row1 < boardLength; row1++) {
	    if (Math.abs(squareRow-queenRow) == Math.abs(squareCol-queenCol)) {
		return true;
	    }
	}
	return false;
    }

    public boolean check(int squareRow, int squareCol) {
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board.length; c++) {
		if (board[r][c] == -1) {
		    if (rookCheck(r,c,squareRow,squareCol) || bishopCheck(r,c,squareRow,squareCol,board.length)) {
			return true;
		    }
		}
	    }
	}
	return false;
    }

    public boolean check(int queenRow, int queenCol, int squareRow, int squareCol) {
	return rookCheck(queenRow,queenCol,squareRow,squareCol) || bishopCheck(queenRow,queenCol,squareRow,squareCol,board.length);
    }
    
  private void addQueen(int r, int c) {
      board[r][c] = -1;
      for (int row = 0; row < board.length; row++) {
	  for (int col = 0; col < board.length; col++) {
	      if (board[row][col] > -1 && check(r,c,row,col)) {
		  board[row][col]++;
	      }
	}
      }
  }
    
  private void removeQueen(int r, int c) {
      if (board[r][c] == -1) {
	  board[r][c] = 0;
	  for (int row = 0; row < board.length; row++) {
	      for (int col = 0; col < board.length; col++) {
		  if (check(r,c,row,col) && board[row][col] > 0) {
		      if (r == row && c == col) {
			  System.out.println("["+r+","+c+"]");
			  board[r][c] = 0;
		      }
		      board[row][col]--;
		  }
	      }
	  }
      }
  }
    
  public String toString() {
      String ans = "";
      for (int r = 0; r < board.length; r++) {
	  for (int c = 0; c < board.length; c++) {
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
      return ans;
  }
    /*public static void main(String[] args) {
	QueenBoard q;
	for (int i = 1; i <= 10; i++) {
	    q = new QueenBoard(i);
	    //System.out.println(q);
	    q.solve();
	    //System.out.println(i+":"+q.getSolutionCount());
	    System.out.println(q);
	    q = new QueenBoard(i);
	    q.countSolutions();
	    System.out.println(i+":"+q.getSolutionCount());
	    //System.out.println(name());
	}
	}*/
}
