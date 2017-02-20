import java.util.Arrays;
public class KnightBoard {
    private int[][] board;
    private int[][] moves;
    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	moves = new int[startingRows][startingCols];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		board[i][j] = 0;
		moves[i][j] = moves(i,j);
	    }
	}
    }
    public String name() {
	return "Rozenzaft,Daniel";
    }
    
    public void solve() {
	solveH(0,0,1);
    }
    
    private boolean badMove(int row, int col) {
	return row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] > 0;
    }

    private int moves(int row, int col) {
	int ans = 0;
	int rowNeg2 = row-2;
	int rowNeg1 = row-1;
	int rowPos1 = row+1;
	int rowPos2 = row+2;
	int colNeg2 = col-2;
	int colNeg1 = col-1;
	int colPos1 = col+1;
	int colPos2 = col+2;
	if (!badMove(rowPos2,colPos1))
	    ans++;;
	if (!badMove(rowPos2,colNeg1))
	    ans++;
	if (!badMove(rowNeg2,colPos1))
	    ans++;
	if (!badMove(rowNeg2,colNeg1))
	    ans++;
	if (!badMove(rowPos1,colPos2))
	    ans++;
	if (!badMove(rowPos1,colNeg2))
	    ans++;
	if (!badMove(rowNeg1,colPos2))
	    ans++;
	if (!badMove(rowNeg1,colNeg2))
	    ans++;
	return ans;
    }

    private int[] possibleMoves(int row, int col) {
	int rowNeg2 = row-2;
	int rowNeg1 = row-1;
	int rowPos1 = row+1;
	int rowPos2 = row+2;
	int colNeg2 = col-2;
	int colNeg1 = col-1;
	int colPos1 = col+1;
	int colPos2 = col+2;
	int[] ans = new int[8];
	for (int a = 0; a < ans.length; a++)
	    ans[a] = 100;
	if (!badMove(rowPos2,colPos1))
	    ans[0] = moves(rowPos2,colPos1);
	if (!badMove(rowPos1,colPos2))
	    ans[1] = moves(rowPos2,colNeg1);
	if (!badMove(rowNeg1,colPos2))
	    ans[2] = moves(rowNeg2,colPos1);
	if (!badMove(rowNeg2,colPos1))
	    ans[3] = moves(rowNeg2,colNeg1);
	if (!badMove(rowNeg2,colNeg1))
	    ans[4] = moves(rowNeg1,colNeg2);
	if (!badMove(rowNeg1,colNeg2))
	    ans[5] = moves(rowPos1,colPos2);
	if (!badMove(rowPos1,colNeg2))
	    ans[6] = moves(rowPos1,colNeg1);
	if (!badMove(rowPos2,colNeg1))
	    ans[7] = moves(rowNeg1,colPos2);
	return ans;
    }

    private boolean solveH(int row, int col, int ID) {
	if (ID > board.length * board[0].length) return true;
	int[] possibleMoves = possibleMoves(row,col);
	int rowNeg2 = row-2;
	int rowNeg1 = row-1;
	int rowPos1 = row+1;
	int rowPos2 = row+2;
	int colNeg2 = col-2;
	int colNeg1 = col-1;
	int colPos1 = col+1;
	int colPos2 = col+2;
	int[] fastestMoves = possibleMoves.clone();
        Arrays.sort(fastestMoves);
	System.out.print(row+","+col+","+Arrays.toString(possibleMoves));
	System.out.print(", "+Arrays.toString(fastestMoves)+"\n");
       	int id = ID+1;
	if (!badMove(row,col)) {
	    board[row][col] = ID;
	    System.out.println(this);
	    if (possibleMoves[0] == fastestMoves[0] && solveH(rowPos2,colPos1,id) || possibleMoves[1] == fastestMoves[0] && solveH(rowPos1,colPos2,id) || possibleMoves[2] == fastestMoves[0] && solveH(rowNeg1,colPos2,id) || possibleMoves[3] == fastestMoves[0] && solveH(rowNeg2,colPos1,id) || possibleMoves[4] == fastestMoves[0] && solveH(rowNeg2,colNeg1,id) || possibleMoves[5] == fastestMoves[0] && solveH(rowNeg1,colNeg2,id) || possibleMoves[6] == fastestMoves[0] && solveH(rowPos1,colNeg2,id) || possibleMoves[7] == fastestMoves[0] && solveH(rowPos2,colNeg1,id)) return true;
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
    public static void main(String[] args) {
	int var1 = Integer.parseInt(args[0]);
	int var2 = Integer.parseInt(args[1]);
	KnightBoard kb = new KnightBoard(var1,var2);
	kb.solve();
	System.out.println(kb);
    }
}
