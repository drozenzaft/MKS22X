import java.util.*;
public class Quick {
    //http://me.dt.in.th/page/Quicksort/
    //this really helped me understand the algorithm! ^^^
    private static void swap(int[] data, int ind1, int ind2) {
	int temp = data[ind2];
	data[ind2] = data[ind1];
	data[ind1] = temp;
    }
    
    /*    public static int part(int[] data, int start, int end) {
	int ind = start + (int)(Math.random()*(end-start));
	int pivot = data[ind];
	//System.out.println("pivot: " +ind+","+pivot);
	int j = end;
	int i = start+1;
	swap(data,start,ind);
	ind = start;
	//	System.out.println("after initial swap: "+ Arrays.toString(data));
	while (i <= j) {
	    if (data[i] > pivot) {
		swap(data,i,j);
		j--;
	    }
	    else if (data[i] < pivot) {
		i++;
	    }
	    else {
		i++;
	    }
	    //  System.out.println("i, j: " +i+","+j);
	    //System.out.println(Arrays.toString(data));
	}
	swap(data,ind,j);
	//swap(data,last,last-1);
	return j;
	}*/

    private static int[] part(int[] data, int start, int end) {
	Random rand = new Random();
	int ind = start + rand.nextInt(end-start);
	int pivot = data[ind];
	int i = start+1;
	int lt = start;
	int gt = end;
	swap(data,ind,start);
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
	int[] ans = new int[2];
	ans[0] = lt;
	ans[1] = gt;
	return ans;
    }

    public static void quicksort(int[] ary) {
	quickSortHelp(ary,0,ary.length-1);
    }

    private static void quickSortHelp(int[] data, int start, int end) {
	if (end > start) {
	    Random rand = new Random();
	    int ind = start + rand.nextInt(end-start);
	    int pivot = data[ind];
	    int i = start+1;
	    int lt = start;
	    int gt = end;
	    swap(data,ind,start);
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
	    quickSortHelp(data,start,lt);
	    quickSortHelp(data,gt+1,end);
	}
    }

    //return the value that is the kth smallest value of the array
    public static int quickselect(int[] data, int k) {
        return quickSelectHelp(data,k,0,data.length-1);
    }

    private static int quickSelectHelp(int[] data, int k, int start, int end) {
	if (end > start) {
	    Random rand = new Random();
	    int ind = start + rand.nextInt(end-start);
	    int pivot = data[ind];
	    int i = start+1;
	    int lt = start;
	    int gt = end;
	    swap(data,ind,start);
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
	    if (k < lt) return quickSelectHelp(data,k,start,lt);
	    if (k > gt) return quickSelectHelp(data,k,gt+1,end);
	}
	return data[k];
    }
        
    /*public static void main(String[] args) {
	Quick a = new Quick();
	//int[] test1 = {1,3,4,3,7,3,0,3,8,3,2,3};
	//int[] test1 = {3,1,4,9,12,10,2,6,5,7};
	int[] test1 = new int[5000];
	for (int i = 0; i < test1.length; i++)
	    test1[i] = (int)(Math.random()*test1.length);
	//int[] test1 = {2,10,15,23,0,5};
	//int[] test = Arrays.copyOfRange(test1,0,test1.length);
	//System.out.println(Arrays.toString(test1));
	//quicksort(test1);
	System.out.println(Arrays.toString(test1));
	//int[] t = {2,10,5,15,0,23};//ans: {1,3,2,4,0,5}
	for (int i = 0; i < test1.length; i++) System.out.println(quickselect(test1,i));
	//System.out.println(Arrays.toString(test1));
	//part(test1,0,test1.length-1);
	//System.out.println(Arrays.toString(test1));
	//	for (int k = 0; k < test1.length; k++) {
	//  System.out.println(k + ": " + quickselect(test1,k));
	//}
	//System.out.println(Arrays.toString(test1));
	}*/
}
