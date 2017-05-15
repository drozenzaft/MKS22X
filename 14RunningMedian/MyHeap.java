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
    public int size() {
	return heap.size() - 1;
    }
    public void add(int s) {
	heap.add(s);
	pushUp(size());
    }
    public int remove() {
        swap(1,size());
	int root = heap.remove(size());
	pushDown(1);
	return root;
    }
    public int peek() {
	if (size() > 1) return heap.get(1);
	return -9999;
    }
    private void swap(int a, int b) {
	int temp = heap.get(a);
	heap.set(a,heap.get(b));
	heap.set(b,temp);
    }
    private void pushUp(int i) {
	while (i > 1 && compare2(heap.get(i),heap.get(i/2)) > 0) {
	    swap(i,i/2);
	    i /= 2;
	}
    }	
    private void pushDown(int i) {
	int bigger = 1;
	while (i*2 <= size() && compare2(heap.get(i),heap.get(i*2)) < 0 || size() >= i*2+1 && compare2(heap.get(i),heap.get(i*2+1)) < 0) {
	    if (size() >= i*2+1) {
		if (compare2(heap.get(i*2),heap.get(i*2+1)) >= 0) bigger = i*2;
		else bigger = i*2+1;
	    }
	    else if (size() >= i*2) {
		bigger = i*2;
	    }
	    else {
		break;
	    }
	    swap(i,bigger);
	    i = bigger;
	}
    }
    private int compare2(Integer me, Integer other) {
	return constant * me.compareTo(other);
    }
    public String toString() {
	String ans = "[";
	for (int a = 1; a < heap.size(); a++)
	    ans += heap.get(a) + ", ";
	return ans.substring(0,ans.length()-2) + "]";
    }
    /*public static void main(String[] args) {
	MyHeap rm = new MyHeap(false);
        rm.add(1);
	rm.add(64);
	rm.add(20);
	rm.add(34);
	rm.add(44);
	rm.add(49);
	rm.add(56);
	rm.add(401);
	rm.add(714);
	rm.add(1021);
	/*rm.add(7814);
	System.out.println(rm);
    }*/
}
