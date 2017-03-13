import java.util.*;
import java.io.*;
public class USACO {

    public USACO(String filename) {
	load(filename);
    }
    
    private static int[][] load(String filename) {
	int[][] lake = new int[1][1];
	try {
	    String line = "";
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

    private static boolean bad(int row, int col, int[][] lake) {
	return row < lake.length && col < lake[0].length;
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

    /*public static void main(String[] args) {
	USACO lake = new USACO(args[0]);
	for (int[] i : lake.load(args[0])) System.out.println(Arrays.toString(i));
	System.out.println(lake.bronze(args[0]));
	}*/
}
			   
