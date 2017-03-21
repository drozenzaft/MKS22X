import java.util.*;
import java.io.*;
public class USACO {

    public USACO() {}
    //bronze load
    private static int[][] load(String filename) {
	int[][] lake = new int[1][1];
	try {
	    Scanner lakeScan = new Scanner(new File(filename));
	    Scanner lakeScanLine = new Scanner(lakeScan.nextLine());
	    int i = lakeScanLine.nextInt();
	    int j = lakeScanLine.nextInt();
	    lakeScanLine.nextInt();
	    lake = new int[i+1+lakeScanLine.nextInt()][];
	    lakeScan = new Scanner(new File(filename));
	    lakeScanLine = new Scanner(new File(filename));
	    Scanner lakeScan2 = new Scanner(new File(filename));
	    i = 0;
	    while (i < lake.length && lakeScan.hasNextLine()) {
		j = 0;
		lake[i] = new int[lakeScan.nextLine().split(" ").length];
		lakeScanLine = new Scanner(lakeScan2.nextLine());
		while (j < lake[i].length && lakeScanLine.hasNextLine()) {
		    lake[i][j] = lakeScanLine.nextInt();
		    j++;
		}
		i++;
	    }
	}
	catch (FileNotFoundException e) {
	    System.out.println("Lake '" + filename + "' not found! Please insert a valid lake file!");
	    System.exit(1);
	}
	return lake;
    }
    //silver load
    private static int[][] load2(String filename) {
	int[][] lake = new int[1][1];
	String[] split = new String[1];
	try {
	    String line = "";
	    Scanner lakeScan = new Scanner(new File(filename));
	    Scanner lakeScanLine = new Scanner(lakeScan.nextLine());
	    int i = lakeScanLine.nextInt();
	    int j = lakeScanLine.nextInt();
	    lakeScanLine.nextInt();
	    lake = new int[i+2][];
	    lake[0] = new int[3];
	    for (int k = 1; k < lake.length-1; k++) lake[k] = new int[j];
	    lake[lake.length-1] = new int[4];
	    lakeScan = new Scanner(new File(filename));
	    for (int n = 0; n < lake.length; n++) {
		line = lakeScan.nextLine();
		split = line.split(" ");
		for (int m = 0; m < split.length; m++) {
		    try {
			lake[n][m] = Integer.parseInt(split[m]+"");
		    }
		    catch(NumberFormatException e) {
			for (int l = 0; l < split[0].length(); l++) {
			    if (split[0].charAt(l) == '.') {
				lake[n][l] = 0;
			    }
			    if (split[0].charAt(l) == '*') {
				lake[n][l] = -1;
			    }
			}
		    }
		}
	    }
	}
	catch (FileNotFoundException e) {
	    System.out.println("Lake not found! Please insert a valid lake file!");
	    System.exit(1);
	}
	return lake;
    }
    //bronze stuff
    private static int[][] getLake(int[][] lake) {
	int[][] ans = new int[lake.length-lake[0][3]-1][lake[1].length];
	for (int i = 0; i < ans.length; i++) {
	    for (int j = 0; j < ans[i].length; j++) {
		ans[i][j] = lake[i+1][j];
	    }
	}
	return ans;
    }
	
    public static int bronze(String filename) {
	int[][] lake = load(filename);
	int[][] finalLake = getLake(lake);
	int par = 0;
	for (int i = 0; i < lake[0][3]; i++) {
	    par = lake.length-lake[0][3]+i;
	    finalLake = stomp(lake[par][0],lake[par][1],lake[par][2],finalLake);
	}
	int s = summation(finalLake,lake[0][2]);
	return s * 72 * 72;
    }	
    
    private static int maxes(int[][] lake, int row, int col) {
	int max = 0;
	for (int r = row; r < lake.length && r < row+3; r++) {
	    for (int c = col; c < lake[r].length && c < col+3; c++) {
		if (lake[r][c] > max) max = lake[r][c];
	    }
	}
	return max;
    }
    
    private static int[][] stomp(int row, int col, int amount, int[][] lake) {
	int max = maxes(lake,row-1,col-1);
	for (int r = row-1; r < row+2 && r < lake.length; r++) {
	    for (int c = col-1; c < col+2 && c < lake[r].length; c++) {
		if (lake[r][c] > max-amount) lake[r][c] = max - amount;
	    }
       	}
	return lake;
    }
    private static int summation(int[][] lake, int goal) {
	int ans = 0;
	for (int r = 0; r < lake.length; r++) {
	    for (int c = 0; c < lake[r].length; c++) {
		if (lake[r][c] < goal) ans += goal - lake[r][c];
	    }
	}
	return ans;
    }

    //silver

    private static int[][] getPath(int[][] travel) {
	int[][] input = new int[travel.length-2][travel[0][1]];
	for (int i = 0; i < input.length; i++) {
	    for (int j = 0; j < input[i].length; j++) input[i][j] = travel[i+1][j];
	}
	return input;
    }

    public static int silver(String filename) {
	int[][] input = load2(filename);
	int i = input.length-1;
	int[][][] param = new int[input[0][2]+1][][];
	param[0] = getPath(input);
	param[0][input[i][0]-1][input[i][1]-1] = 1;
	for (int j = 1; j < param.length; j++) {
	    param[j] = new int[param[0].length][param[0][0].length];
	}
	solve(param);
	return param[param.length-1][input[i][2]-1][input[i][3]-1];
    }
    
    private static void solve(int[][][] input) {
	for (int i = 1; i < input.length; i++) {
	    int[][] temp = new int[input[i].length][input[i][0].length];
	    for (int r = 0; r < input[i].length; r++) {
		for (int c = 0; c < input[i][r].length; c++) {
		    if (input[i-1][r][c] > -1) {
			temp[r][c] = sumNeighbors(input[i-1],r,c);
		    }
		    else {
			temp[r][c] = -1;
		    }
		}
	    }
	    input[i] = temp;
	}
    }
    private static int sumNeighbors(int[][] input, int r, int c) {
	int ans = 0;
	int[][] neighbors = {{1,0},{-1,0},{0,1},{0,-1}};
	for (int i = 0; i < neighbors.length; i++) {
	    try {
		if (input[r+neighbors[i][0]][c+neighbors[i][1]] > 0) {
		    ans += input[r+neighbors[i][0]][c+neighbors[i][1]];
		}
	    }
	    catch (IndexOutOfBoundsException e) {
	    }
	}
	return ans;
    }

    /*public static void main(String[] args) {
	USACO travel = new USACO(args[0]);
	System.out.println(travel.bronze(args[0]));
	//for (int[] i : travel.load(args[0])) System.out.println(Arrays.toString(i));
	}*/
}
