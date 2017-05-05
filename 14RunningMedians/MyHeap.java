import java.util.*;
public class MyHeap {
    private ArrayList<Integer> heap;
    private int constant;
    public MyHeap() {
	heap = new ArrayList<Integer>();
	heap.add(null);
	constant = 1;
    }
    public MyHeap(boolean minMax) {
	heap = new ArrayList<Integer>();
	heap.add(null);
	if (minMax) constant = 1;
	else constant = -1;
    }
    private int size() {
	return heap.size() - 1;
    }
    public void add(Integer s) {
	heap.add(s);
	pushUp();
    }
    public Integer remove() {
        swap(1,size());
	Integer root = heap.remove(size());
	pushDown();
	return root;
    }
    public Integer peek() {
	if (size() > 1) return heap.get(1);
	return null;
    }
    private void swap(int a, int b) {
	Integer temp = heap.get(a);
	heap.set(a,heap.get(b));
	heap.set(b,temp);
    }
    private void pushUp() {
	int i = size();
	while (i > 1 && compare2(heap.get(i),heap.get(i/2)) > 0) {
	    System.out.println(this);
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
    private int compare2(Integer me, Integer other) {
	return constant * me.compareTo(other);
    }
    public String toString() {
	String ans = "[";
	for (int a : heap) ans += a + ", ";
	return ans.substring(0,ans.length()-2) + "]";
    }
}
