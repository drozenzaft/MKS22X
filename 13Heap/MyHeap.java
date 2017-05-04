import java.util.*;
public class MyHeap {
    private ArrayList<String> heap;
    private int constant;
    public MyHeap() {
	heap = new ArrayList<String>();
	heap.add("");
	constant = 1;
    }
    public MyHeap(boolean minMax) {
	heap = new ArrayList<String>();
	heap.add(null);
	if (minMax) constant = 1;
	else constant = -1;
    }
    private int size() {
	return heap.size() - 1;
    }
    public void add(String s) {
	heap.add(s);
	pushUp();
    }
    public String remove() {
	String root = heap.remove(1);
	pushUp();
	return root;
    }
    public String peek() {
	if (size() > 1) return heap.get(1);
	return null;
    }
    private void swap(int a, int b) {
	String temp = heap.get(a);
	heap.set(a,heap.get(b));
	heap.set(b,temp);
    }
    private boolean isGood(int root) {
	if (size() == 1 || (size()-1)/2 == (size()-2)/2) return true;
	if (compare2(heap.get(root),heap.get(root*2)) < 0 || compare2(heap.get(root),heap.get(root*2+1)) < 0) return false;
	return true;
    }
    private void pushUp() {
	heap.set(1,heap.get(size()-1));
	heap.remove(heap.get(size()-1));
	pushDown();
    }
    private void pushDown() {
	int i = 1;
	int bigger = 2;
	while (!isGood(i)) {
	    if (compare2(heap.get(i*2),heap.get(i*2+1)) >= 0) bigger = i*2;
	    else bigger = i*2+1;
	    swap(i,bigger);
	}
    }
    private int compare2(String me, String other) {
	return constant * me.compareTo(other);
    }
    public String toString() {
	String ans = "[";
	for (String a : heap) ans += a + ", ";
	return ans.substring(0,ans.length()-2) + "]";
    }
    public static void main(String[] args) {
	MyHeap heap = new MyHeap(false);
	heap.add("a");
	heap.add("b");
	heap.add("W");
	heap.add("V");
	heap.add("c");
	heap.add("d");
	heap.add("U");
	heap.add("e");
	heap.add("T");
	heap.add("S");
	heap.add("f");
	heap.add("g");
	heap.add("R");
	heap.add("Q");
	System.out.println(heap);
    }
}


/*

You are writing a heap of strings, it is very easy to modify this to be a heap of anything else.

 Constructors
 -MyHeap() - construct empty max heap
 -MyHeap(boolean) - true: construct empty max heap, false: construct empty min heap.
 Methods
 -void add(String s)
 -String remove()
 -String peek()

Private methods:
 -pushUp()
 -pushDown()
*/
