import java.util.*;
public class Quick {
    //http://me.dt.in.th/page/Quicksort/
    //this really helped me understand the algorithm! ^^^
    private static void swap(int[] data, int ind1, int ind2) {
	int temp = data[ind2];
	data[ind2] = data[ind1];
	data[ind1] = temp;
    }
    
    public static int part(int[] data, int start, int end) {
	int ind = start + (int)(Math.random()*(end-start));
	int pivot = data[ind];
	System.out.println("pivot: " +ind+","+pivot);
	int last = end;
	swap(data,0,ind);
	for (int i = start; i <= last; i++) {
	    if (data[i] > pivot) {
		swap(data,i,last);
		last--;
		i--;
	    }
	    System.out.println("i, last: " +i+","+last);
	    System.out.println(Arrays.toString(data));
	}
	swap(data,0,last);
	//swap(data,last,last-1);
	return last;
    }

    public static void main(String[] args) {
	Quick a = new Quick();
	int[] test1 = {3,1,4,1,5,9,2,6,5,3};
	int[] test = {44,75,23,43,55,12,64,77,33};
	System.out.println(Arrays.toString(test1));
	System.out.println(part(test1,0,test1.length-1));
	System.out.println(Arrays.toString(test1));
    }

    //-Choose a random element to be a pivot, and partition the array around it. 
    //-Only partition the elements from start to end inclusive.
    //-When done returns the index of the final position of the pivot element.      
    //    (Should be from start to end inclusive)
}
