import java.util.*;
public class Part {
    //https://www.cise.ufl.edu/~ddd/cis3020/summer-97/lectures/lec17/sld003.htm
    //this really helped me understand the algorithm! ^^^
    private static void swap(int[] data, int ind1, int ind2) {
	int temp = data[ind2];
	data[ind2] = data[ind1];
	data[ind1] = temp;
    }
    
    public static int part(int[] data, int start, int end) {
	int ind = (int)(Math.random()*(end-start));
	int piv = data[ind];
	System.out.println(ind+","+piv);
	int beg = start;
	int en = end;
	for (int i = start; beg > en; i++) {
	    if (piv >= data[beg]) beg++;
	    if (piv < data[en]) en--;
	}
	swap(data,ind,en);
	return en;
    }

    public static void main(String[] args) {
	Part a = new Part();
	int[] test = {44,75,23,43,55,12,64,77,33};
	System.out.println(Arrays.toString(test));
	System.out.println(part(test,1,test.length-1));
	System.out.println(Arrays.toString(test));
    }

    //-Choose a random element to be a pivot, and partition the array around it. 
    //-Only partition the elements from start to end inclusive.
    //-When done returns the index of the final position of the pivot element.      
    //    (Should be from start to end inclusive)
}
