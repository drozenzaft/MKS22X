//java blah > out.txt 2 > err.txt: separate file output and error output
//particularly useful for stack overflow errors
import java.util.Arrays;
public class Merge {
  private static void merge(int[] a, int[] b, int[] destination) {
    int i = 0;
    int j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        destination[i+j] = a[i];
        i++;
      }
      else if (b[j] < a[i]) {
        destination[i+j] = b[j];
        j++;
      }
      else {
        destination[i+j] = a[i];
        i++;
        destination[i+j] = b[j];
        j++;
      }
    }
    if (i < a.length) {
      for (int x = i; x < a.length; x++) destination[j+x] = a[x];
    }
    else if (j < b.length) {
      for (int y = j; y < b.length; y++) destination[i+y] = b[y];
    }
  }

    public static void mergesort(int[] ary) {
	int[] left = Arrays.copyOfRange(ary,0,ary.length/2);
	int[] right = Arrays.copyOfRange(ary,ary.length/2,ary.length);
	if (left.length > 1) mergesort(left);
	if (right.length > 1) mergesort(right);
	merge(left,right,ary);
    }

    /*public static void main(String[] args) {
    int[] a = new int[115000000];//{1,2,7,10,23,44,77,92};
    for (int i = 0; i < a.length; i++) a[i] = (int)(Math.random()*a.length);
    mergesort(a);
    int[] b = new int[300];
    for (int j = 0; j < b.length; j++) b[j] = (int)(Math.random()*b.length);
    Arrays.sort(b);
    //int[] b = {0,3,8,17,27,41,77,81,86,101,104};
    int[] d = new int[a.length+b.length];
    merge(a,b,d);
    System.out.println(Arrays.toString(a));
  }*/
}
