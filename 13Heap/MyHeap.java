import java.util.*;
public class MyHeap {
    private ArrayList<String> heap;
    private int constant;
    public MyHeap() {
	heap = new ArrayList<String>();
	heap.add(null);
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
    }
    public String remove() {
	return heap.remove(1);
    }
    public String peek() {
	return heap.get(1);
    }
    public String toString() {
	String ans = "[";
	for (String a : heap) ans += a + ", ";
	return ans.substring(0,ans.length()-2) + "]";
    }
    public static void main(String[] args) {
	
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
