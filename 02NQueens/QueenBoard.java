import java.util.ArrayList;
import java.util.Arrays;
public class QueenBoard {
    private int[][]board;
    private int solutionCount;
    public QueenBoard(int size){
	board = new int[size][size];
    }

    public int countQueens() {
	int ans = 0;
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board.length; c++) {
		if (board[r][c] == -1) {
		    ans++;
		}
	    }
	}
	return ans;
    }

    public boolean solve() {
	return solveH(0,0);
    }

    private int findQueen(int row) {
	for (int c = 0; c < board.length; c++)
	    if (board[row][c] == -1) return c;
	return -1;
    }
    
    private boolean solveH(int row, int col) {
	if (col == board.length) return countQueens() == board.length;
	for (int r = row; r < board.length; r++) {
	    if (col >= board.length) {
		if (row == board.length - 1) {
		    removeQueen(r-1,findQueen(r-1));
		    return solveH(r-1,0);
		}
		return solveH(r,0);
	    }
	    if (!check(r,col)) {
		addQueen(r,col);
		System.out.println(this);
	    }
	    else if (col < board.length) {
		col++;
		r--;
	    }
       	}
	return countQueens() == board.length;
    }
    
  public int getSolutionCount() {
      if (solutionCount > 0) return solutionCount;
      return -1;
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
    board[r][c]++;
    for (int row = 0; row < board.length; row++) {
	for (int col = 0; col < board.length; col++) {
	    if (check(row,col)) {
		board[row][col]--;
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
		  ans += board[r][c];
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
    public static void main(String[] args) {
	//my code breaks whenever there is no solution with there being a queen at the top left corner
	QueenBoard q = new QueenBoard(5);
	//q.addQueen(2,2);
	//System.out.println(q);
	//q.addQueen(4,5);
	//System.out.println(q);
	/*for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		System.out.println(i+","+j+": " +(q.check(i,j)));
	    }
	    }*/
	//q.removeQueen(3,3);
	//System.out.println(q);
	//q.removeQueen(4,5);
	//System.out.println(q);
	System.out.println(q.solve());
	//System.out.println(q);
    }
}
