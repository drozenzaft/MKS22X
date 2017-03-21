import java.util.*;
public class Quick {
    //http://me.dt.in.th/page/Quicksort/
    //this really helped me understand the algorithm! ^^^
    private static void swap(int[] data, int ind1, int ind2) {
	int temp = data[ind2];
	data[ind2] = data[ind1];
	data[ind1] = temp;
    }
    
    /*public static int part(int[] data, int start, int end) {
	int ind = start + (int)(Math.random()*(end-start));
	int pivot = data[ind];
	System.out.println("pivot: " +ind+","+pivot);
	int j = end;
	int i = 0;
	swap(data,0,ind);
	ind = 0;
	System.out.println("after initial swap: "+ Arrays.toString(data));
	while (i <= j) {
	    if (data[i] >= pivot && i != ind) {
		swap(data,i,j);
		j--;
	    }
	    else {
		i++;
	    }
	    System.out.println("i, j: " +i+","+j);
	    System.out.println(Arrays.toString(data));
	}
	swap(data,ind,j);
	//swap(data,last,last-1);
	return j;
	}*/

    public static int part(int[] data, int start, int end) {
	int ind = start + (int)(Math.random()*(end-start));
	int pivot = data[ind];
	//System.out.println("pivot: " + ind + "," + pivot);
	int i = 0;
	int lt = start;
	int gt = end;
	swap(data,ind,0);
	while (i <= gt) {
	    if (data[i] == pivot) {
		i++;
	    }
	    else if (data[i] < pivot) {
		swap(data,i,lt);
		i++;
		lt++;
	    }
	    else {
		swap(data,i,gt);
		gt--;
	    }
	}
	return gt;
    }

    //return the value that is the kth smallest value of the array
    /*public static int quickselect(int[] data, int k){
	//System.out.println("before: "+Arrays.toString(data));
	int[] temp = new int[1];
	int part = part(data,0,data.length-1);
        if (k == part) return data[part];
	if (k > part) {
	    
	}
	else if (k < part) {
	    
	}
        if (Arrays.equals(data,temp)) return data[data.length-1];
        //System.out.println("after: " + Arrays.toString(temp));
	}*/

    
    
    public static void main(String[] args) {
	Quick a = new Quick();
	//int[] test1 = {3,1,4,3,5,3,2,6,5,3};
	int[] test1 = {2,10,15,23,0,5};
	int[] test = {44,75,23,43,55,12,64,77,33};
	System.out.println(Arrays.toString(test1));
	//System.out.println(part(test1,0,test1.length-1));
	//	for (int k = 0; k < test1.length; k++) {
	//  System.out.println(k + ": " + quickselect(test1,k));
	//}
	//System.out.println(Arrays.toString(test1));
    }
}
