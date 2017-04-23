import java.util.*;
public class MyDeque {
    private int front;
    private int back;
    private int size;
    private String[] deque;
    
    public MyDeque() {
      size = 10;
      front = 0;
      back = 0;
      deque = new String[size];
    }
    
    private void nPE(String s) {
      try {
	s.length();
      }
      catch (NullPointerException e) {
	  throw new NullPointerException("Cannot add null element");
      }
    }
    
    private void resize(int frnt) {
	String[] nw = new String[size*2];
	int i = frnt;
	int j = 0;
	if (frnt > front) j++;
	front = 0;
	while (j <= size) {
	    if (i == size) i = 0;
	    nw[j] = deque[i];
	    i++;
	    j++;
	}
	back = j-1;
	size = nw.length;
	deque = nw;
    }

    public void addFirst(String s) {
	nPE(s);
	if (deque[front] == null) {
	    deque[front] = s;
	    return;
	}
	front--;
	if (front < 0) front = size + front;
	if (deque[front] != null) resize(front+1);
	deque[front] = s;
    }
    
    public void addLast(String s) {
	nPE(s);
	if (deque[back] != null) back++;
	if (back == size) back = 0;
	if (deque[back] != null) resize(front);
	deque[back] = s;
    }

    private void nSEE() {
        if (deque[front] == null) throw new NoSuchElementException("Cannot get or remove from empty deque");
    }
    
    public String removeFirst() {
	nSEE();
	String ans = deque[front];
	deque[front] = null;
	front++;
	if (front == size || deque[front] == null) front = 0;
	if (deque[back] == null) back = 0;
	return ans;
    }

    public String removeLast() {
	nSEE();
	String ans = deque[back];
	deque[back] = null;
	back--;
	if (back < 0) back = size + back;
	if (deque[back] == null) {
	    back = 0;
	    front = 0;
	}
	return ans;
    }

    public String getFirst() {
	nSEE();
	return deque[front];
    }

    public String getLast() {
	nSEE();
	return deque[back];
    }

    public String toString() {
	return Arrays.toString(deque) + "," + deque[front] + "," + deque[back];
    }

    /*public static void main(String[] args) {
	MyDeque a = new MyDeque();
	a.addLast("a");
	System.out.println(a);
	a.addFirst("b");
	System.out.println(a);
	System.out.println(a.getFirst());
	System.out.println(a.getLast());
	System.out.println(a.removeLast());
	System.out.println(a);
	System.out.println(a.removeLast());
	System.out.println(a);
	a.addLast("a");
	System.out.println(a);
	a.addLast("b");
	System.out.println(a);
	a.addFirst("c");
	System.out.println(a);
	a.addFirst("d");
	System.out.println(a);
	a.addLast("e");
	System.out.println(a);
	a.addLast("f");
	System.out.println(a);
	a.addFirst("g");
	System.out.println(a);
	a.addLast("h");
	System.out.println(a);
	a.addLast("i");
	System.out.println(a);
	a.addFirst("j");
	System.out.println(a);
	a.addLast("k");
	System.out.println(a);
	a.addLast("l");
	System.out.println(a);
	a.addFirst("m");
	System.out.println(a);	
	a.addFirst("n");
	System.out.println(a);
	a.addLast("o");
	System.out.println(a);
	a.addLast("p");
	System.out.println(a);
	a.addFirst("q");
	System.out.println(a);
	a.addFirst("r");
	System.out.println(a);
	a.addLast("s");
	System.out.println(a);
	a.addFirst("t");
	System.out.println(a);
	a.addLast("u");
	System.out.println(a);
	a.addFirst("v");
	System.out.println(a);
	a.removeLast();
	System.out.println(a);
	a.removeFirst();
	System.out.println(a);
	a.removeFirst();
	System.out.println(a);
	a.removeLast();
	System.out.println(a);
	a.removeFirst();
	System.out.println(a);
	System.out.println(a.getFirst());
	System.out.println(a.getLast());
	while (!a.getFirst().equals(a.getLast())) a.removeLast();
	System.out.println(a);
	int i = 97;
	while (i <= 122) {
	    a.addFirst(Character.toString((char)i));
	    i++;
	}
	System.out.println(a);
	}*/
}
