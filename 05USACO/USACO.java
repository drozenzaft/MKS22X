import java.util.*;
import java.io.*;
public class USACO {

    public USACO(String filename) {}
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
	    System.out.println("Lake not found! Please insert a valid lake file!");
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
		//System.out.println(Arrays.toString(split));
		for (int m = 0; m < split.length; m++) {
		    try {
			lake[n][m] = Integer.parseInt(split[m]+"");
			//System.out.println("INT!");
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
	//System.out.println("start stomp: ");
	//for (int[] l : lake) System.out.println(Arrays.toString(l));
	int max = maxes(lake,row-1,col-1);
	for (int r = row-1; r < row+2 && r < lake.length; r++) {
	    for (int c = col-1; c < col+2 && c < lake[r].length; c++) {
		if (lake[r][c] > max-amount) lake[r][c] = max - amount;
	    }
       	}
	//System.out.println("end stomp: ");
	//for (int[] k : lake) System.out.println(Arrays.toString(k));
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
	//System.out.println("\n");
	//for (int[] k : input) System.out.println(Arrays.toString(k));
	//System.out.println("\n");
	return input;
    }

    /*  public static void silver(String filename) {
	int[][] input = load2(filename);
	int i = input.length-1;
	System.out.println(solve(getPath(input),input[i][0]-1,input[i][1]-1,input[i][2]-1,input[i][3]-1,input[0][2]));
	for (int[] j : input) System.out.println(Arrays.toString(j));
    }

        private static boolean solve(int[][] input, int r, int c, int row, int col, int secs) {
	int sec = secs-1;
	if (r == row && c == col) return secs >= 0;
	if (r >= 0 && c >= 0 && r < input.length && c < input[0].length && input[r][c] != -1) {
	    if (input[r][c] == 0) {
		System.out.println("Set input[" +r + "]["+c+"] to one!");
		input[r][c] = 1;
		if (solve(input,r+1,c,row,col,sec) || solve(input,r-1,c,row,col,sec) || solve(input,r,c+1,row,col,sec) || solve(input,r,c-1,row,col,sec)) return true;
		input[r][c] = -1;
		secs++;
	    }
	}
	return false;
	}*/

    public static int silver(String filename) {
	int[][] input = load2(filename);
	int i = input.length-1;
	int[][][] param = new int[input[0][2]+1][][];
	param[0] = getPath(input);
	param[0][input[i][0]-1][input[i][1]-1] = 1;
	for (int j = 1; j < param.length; j++) {
	    param[j] = new int[param[0].length][param[0][0].length];
	    //param[j][input[i][2]-1][input[i][1]-1] = 1;
	}
	//for (int[] l : param[0]) System.out.println(Arrays.toString(l));
	solve(param);
	return param[param.length-1][input[i][2]-1][input[i][3]-1];
    }
    
    private static void solve(int[][][] input) {
	//input[1] = input[0];
	//System.out.println(Arrays.toString(input[0][0]));
	for (int i = 1; i < input.length; i++) {
	    int[][] temp = new int[input[i].length][input[i][0].length];
	    //temp = input[i-1];
	    //    for (int i = 1; i < input.length; i++) {
	    for (int r = 0; r < input[i].length; r++) {
		for (int c = 0; c < input[i][r].length; c++) {
		    if (input[i-1][r][c] > -1) {
			temp[r][c] = sumNeighbors(input[i-1],r,c);
			//System.out.println(temp[r][c]);
			//    System.out.println(i+":");
			//for (int[] q : input[i-1]) System.out.println(Arrays.toString(q));
		    }
		    else {
			temp[r][c] = -1;
		    }
		}
	    }
	    input[i] = temp;
		//}
	    //if (i < input.length-1) input[i+1] = Arrays.copyOf(input[i],input[i].length);
	    //copy(input,temp);
	    //for (int[] k : input) System.out.println(Arrays.toString(k));
	    //System.out.print("\n");
	}
	//}
	    //System.out.println("temp: ");
	    //for (int[] a : temp) System.out.println(Arrays.toString(a));
	    /*    for (int r = 0; r < input[i].length; r++) {
		for (int c = 0; c < input[i][r].length; c++) {
		    if (temp[r][c] > -1) {
			//input[i][r][c] = sumNeighbors(input[i-1],r,c);
			input[i][r][c] = sumNeighbors(input[i],r,c);
			//System.out.println(input[i][r][c]);
			//System.out.println(i+":");
			//for (int[] q : input[i-1]) System.out.println(Arrays.toString(q));
		    }
		    else {
			input[i][r][c] = -1;
		    }
		    }*/
	    //}
    // input[input.length-1] = temp;
	    //if (i < input.length-1) input[i+1] = Arrays.copyOf(input[i],input[i].length);
	    //copy(input,temp);
		for (int h = 0; h < input.length; h++) {
		    System.out.println(printer2(input,h));
		}
		//}
    }
    private static int sumNeighbors(int[][] input, int r, int c) {
	int ans = 0;
	int[][] neighbors = {{1,0},{-1,0},{0,1},{0,-1}};
	for (int i = 0; i < neighbors.length; i++) {
	    try {
		if (input[r+neighbors[i][0]][c+neighbors[i][1]] > 0) {
		    ans += input[r+neighbors[i][0]][c+neighbors[i][1]];
		    //input[r+neighbors[i][0]][c+neighbors[i][1]] = 0;
		    //System.out.println("["+r+","+c+"] added: "+Arrays.toString(neighbors[i]));
		}
		//System.out.println(input[r+neighbors[i][0]][c+neighbors[i][1]]);
	    }
	    catch (IndexOutOfBoundsException e) {
	    }
	}
	return ans;
    }

    private static void copy(int[][] src, int[][] targ) {
	for (int i = 0; i < src.length; i++) {
	    for (int j = 0; j < src[i].length; j++) {
		targ[i][j] = src[i][j];
	    }
	}
    }

    //thanks to khinshan for this printer/testing method
    public static String printer2(int[][][] pasture,int x){
	String s="";
	for(int i=0; i<pasture.length;i++){
	    for(int j=0; j< pasture[i].length;j++) {
		s += i + ": ";
		for (int k = 0; k < pasture[i][j].length; k++) {
		    s+=pasture[i][j][k]+" ";
		}
		s+="\n";
	    }
	    s+="\n";
	}
	return s;
    }

    /*public static void main(String[] args) {
	USACO travel = new USACO(args[0]);
	System.out.println(travel.bronze(args[0]));
	//for (int[] i : travel.load(args[0])) System.out.println(Arrays.toString(i));
	}*/
}
			   
/*
	if (r + 1 < input.length && input[r+1][c] > 0) ans += input[r+1][c];
	if (r - 1 >= 0 && input[r-1][c] > 0) ans += input[r-1][c];
	if (c + 1 < input[0].length && input[r][c+1] > 0) ans += input[r][c+1];
	if (c - 1 >= 0 && input[r][c-1] > 0) ans += input[r][c-1];
*/
