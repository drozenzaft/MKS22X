import java.util.*;
import java.io.*;
public class Lake {
    private int[][] lake;

    public Lake() {
    }

    private void load(String filename) {
	try {
	    Scanner lakeScan = new Scanner(new File(filename));
	    int i = 0;
	    while (lakeScan.hasNextLine()) {
		lakeScan.nextLine();
		i++;
	    }
	    lake = new int[i][];
	    lakeScan = new Scanner(new File(filename));
	    for (int j = 0; j < lake.length; j++) {
		String lakeScanLine = lakeScan.nextLine();
		lake[j] = StringtoInt(lakeScanLine.split(" "));
	    }
	}
	catch (FileNotFoundException e) {
	    System.out.println("Lake not found! Please insert a valid lake file!");
	    System.exit(1);
	}
    }
    
    private static int[] StringtoInt(String[] str) {
	int[] ans = new int[str.length];
	for (int i = 0; i < str.length; i++) ans[i] = Integer.parseInt(str[i]);
	return ans;
    }

    private int[][] getLake() {
	int[][] ans = new int[lake.length][lake[1].length];
	for (int i = 1; i < lake.length-lake[0][3]; i++) ans[i-1] = lake[i];
	return ans;
    }
	
    public int bronze(String filename) {
	load(filename);
	for (int i = lake.length-lake[3]; i < lake.length; i++)
	    stomp(lake[i][0],lake[i][1],0,0,lake[i][2]);
	//return stomp(lake[0][0],lake[0][1],lake[0][2],lake[0][3]) * 72 * 72;
    }

    private boolean bad(int r, int c, int row, int col) {
	return row > r-2 && row < r+2 && row < lake.length-lake[0][3]-1 && row > 0 && col > c-2 && col < c+2 && col < lake[1].length && col > 0;
    }

    private int decrease(int row, int col, int amount) {
	int high = 0;
	int next = 0;
	int current = 0;
	for (int r = row; r < row+3 && r < lake.length; r++) {
	    for (int c = col; col < col+3 && col < lake[r].length; c++) {
		current = lake[r][c];
		if (current > high) {
		    high = current;
		}
		else if (current > next) {
		    next = current;
		}
	    }
	}
	if (next == 0 || high - next > amount) return amount;
	return high - next;
    }

    private static int[][] listToArray(ArrayList<int[]> in) {
	int[][] ans = new int[in.size()][2];
	for (int i = 0; i < ans.length; i++) ans[i] = in.get(i);
	return ans;
    }

    private int[][] maximums(int[][] sect) {
	//sect is the 3x3 square section
	int max = 0;
	int[] temp = new int[2];
	ArrayList<Integer> ans = new ArrayList<Integer>();
	for (int i = 0; i < sect.length; i++) {
	    for (int j = 0; j < sect[i].length; j++) {
		temp[0] = i;
		temp[1] = j;
		if (lake[i][j] >= max) ans.add(temp);
	    }
	}
	return listToArray(ans);
    }
    private int[][] getSect(int r, int c) {
	int[][] ans = new int[3][3];
	int i = r;
	int j = c;
	while (i < lake.length) {
	    while (j < lake[i].length) {
		ans[i-r][j-r] = getLake()[i][j];
		j++;
	    }
	    i++;
	}
	if (i < r+3 || j < c+3) ans[0][0] = -10000000;
	return ans;
    
    private void stomp(int r, int c, int row, int col, int amount) {
	if (amount == 0) return;
	if (!bad(r,c,row,col)) {
	    if (getSect(row,col)[0][0] != -10000000) {
	}

    public static void main(String[] args) {
	Lake lake = new Lake(args[0]);
	for (int[] i : lake.lake) System.out.println(Arrays.toString(i));
    }
}
			   
