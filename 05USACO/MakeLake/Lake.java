import java.util.*;
import java.io.*;
public class Lake {
    private int[][] lake;

    public Lake(String filename) {
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
	

    public static void main(String[] args) {
	Lake lake = new Lake(args[0]);
	for (int[] i : lake.lake) System.out.println(Arrays.toString(i));
    }
}
			   
