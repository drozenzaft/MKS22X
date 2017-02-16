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
	System.out.println(solveH(0,0,0));
    }
    
    public boolean badMove(int row, int col) {
	return row < 0 || row >= board.length || col < 0 || col >= board[0].length;
    }

    public boolean solveH(int row, int col, int ID) {
	if (ID >= board.length * board[0].length) return true;
	if (badMove(row,col)) return false;
       	if (board[row][col] == -1) {
	    board[row][col] = ID;
	    System.out.println(ID+"\n"+this);
	    if (ID < board.length * board[0].length) {
		return solveH(row-1,col+2,ID+1) || solveH(row-1,col-2,ID+1) || solveH(row+2,col-1,ID+1) || solveH(row+2,col+1,ID+1) || solveH(row+1,col+2,ID+1) || solveH(row+1,col-2,ID+1) || solveH(row-2,col+1,ID+1) || solveH(row-2,col-1,ID+1);
	    }
	}
	return false;
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
