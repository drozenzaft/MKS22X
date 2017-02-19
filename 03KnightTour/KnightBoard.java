public class KnightBoard {
    private int[][] board;
    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = 0;
	    }
	}
    }
    public String name() {
	return "Rozenzaft,Daniel";
    }
    
    public void solve() {
	solveH(0,0,1);
    }
    
    public boolean badMove(int row, int col) {
	return row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] > 0;
    }

    private boolean solveH(int row, int col, int ID) {
	if (ID > board.length * board[0].length) return true;
	int rowNeg2 = row-2;
	int rowNeg1 = row-1;
	int rowPos1 = row+1;
	int rowPos2 = row+2;
	int colNeg2 = col-2;
	int colNeg1 = col-1;
	int colPos1 = col+1;
	int colPos2 = col+2;
       	int id = ID+1;
	if (!badMove(row,col)) {
	    board[row][col] = ID;
	    if (solveH(rowPos2,colPos1,id) || solveH(rowPos1,colPos2,id) || solveH(rowNeg1,colPos2,id) || solveH(rowNeg2,colPos1,id) || solveH(rowNeg2,colNeg1,id) || solveH(rowNeg1,colNeg2,id) || solveH(rowPos1,colNeg2,id) || solveH(rowPos2,colNeg1,id)) return true;
	    board[row][col] = 0;
	}
	return false;
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
    /*public static void main(String[] args) {
	KnightBoard kb = new KnightBoard(8,8);
	System.out.println(kb.name());
	kb.solve();
	System.out.println(kb);
    }*/
}
