public class KnightBoard {
    private int[][] board;
    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board.length; j++) {
		board[i][j] = -1;
	    }
	}
    }

    public void solve() {
	solveH(0,0,0);
    }
    
    public boolean solveH(int row, int col, int ID) {
	boolean isTaken;
	if (ID >= board.length * board[0].length) return true;
	if (board[row][col] == -1) {
	    board[row][col] = ID;
	    if (ID < board.length * board[0].length) {
		ID++;
		if (row < board.length - 2 && col < board[0].length -1 && board[row+2][col+1] == -1))
		    return solveH(row+2,col+1,ID);
		else if (row < board.length - 2 && col > 1 && board[row+2][col+1] == -1))
		    return solveH(row+2,col-1,ID);
		else if (row < board.length - 1 && col < board[0].length && board[row+1][col+2] == -1))
		    return solveH(row+1,col+2,ID);
		else if (row < board.length - 1 && col > 2 && board[row+1][col-2] == -1))
		    return solveH(row+1,col-2,ID);
		else if (row > 1 && col < board[0].length && board[row-1][col-2] == -1))
		    return solveH(row-1,col+2,ID);
		else if (row > 1 && col > 2) && board[row-1][col-2] == -1)
		    return solveH(row-1,col-2,ID);
		else if (row > 2 && col < board[0].length-1 && board[row-2][col+1] == -1))
		    return solveH(row-2,col+1,ID);
		else if (row > 2 && col > 1 && board[row-2][col-1] == -1)) 
		    return solveH(row-2,col-1,ID);
	    }
	}
	return true;
    }
    
    public void test() {
	int num = 0;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = num;
		num++;
	    }
	}
    }

    public String toString() {
	String ans = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] < 10) {
		    ans += " ";
		}
		ans += board[i][j];
		if (j < board[i].length - 1) {
		    ans += " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    public static void main(String[] args) {
	int var = Integer.parseInt(args[0]);
	KnightBoard kb = new KnightBoard(var,var);
	kb.solve();
	System.out.println(kb);
    }
}
