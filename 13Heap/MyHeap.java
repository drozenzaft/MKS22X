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
	pushUp();
    }
    public String remove() {
        swap(1,size());
	String root = heap.remove(size());
	pushDown();
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
    private void pushUp() {
	int i = size();
	while (i > 1 && compare2(heap.get(i),heap.get(i/2)) > 0) {
	    swap(i,i/2);
	    i /= 2;
	}
    }
	
    private void pushDown() {
	int i = 1;
	int bigger = 2;
	while (i*2 < size() && (compare2(heap.get(i),heap.get(i*2)) < 0 || compare2(heap.get(i),heap.get(i*2+1)) < 0)) {
	    if (compare2(heap.get(i*2),heap.get(i*2+1)) >= 0) bigger = i*2;
	    else bigger = i*2+1;
	    swap(i,bigger);
	    i = bigger;
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
    /*public static void main(String[] args) {
	MyHeap heap = new MyHeap(false);
	heap.add("a");
	System.out.println(heap);
	heap.add("b");
	System.out.println(heap);
	heap.add("W");
	System.out.println(heap);
	heap.add("V");
	System.out.println(heap);
	heap.add("c");
	System.out.println(heap);
	heap.add("d");
	System.out.println(heap);
	heap.add("U");
	System.out.println(heap);
	heap.add("e");
	System.out.println(heap);
	heap.add("T");
	System.out.println(heap);
	heap.add("S");
	System.out.println(heap);
	heap.add("f");
	System.out.println(heap);
	heap.add("g");
	System.out.println(heap);
	heap.add("R");
	System.out.println(heap);
	heap.add("Q");
	System.out.println(heap);
	heap.remove();
	System.out.println(heap);
	}*/
}
