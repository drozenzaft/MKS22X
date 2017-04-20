import java.util.Iterator;
import java.util.NoSuchElementException;
public class MyLinkedList implements Iterable<Integer> {
    private LNode start,end;
    private int size;

    public MyLinkedList() {
	size = 0;
    }
	
    /*public MyLinkedList(int first, int howBig) {
	start = new LNode(first);
	size = howBig;
        int i = 1;
	LNode current = new LNode(0);
	start.next = current;
	while (i < size) {
	    current.next = new LNode(0);
	    current = current.next;
	    i++;
	}
    }*/
    
    private class LNode {
	private int value;
	private LNode next;
	private LNode prev;
	private LNode(int val) {
	    value = val;
	}
	public String toString() {
	    if (prev == null && next == null) return "null," + value + ",null";
	    if (prev == null) return "(null)"+value+"(" + next.value+ ")";
	    else if (next == null) return "(" + prev.value + ")" + value + "(null)";
	    return "(" + prev.value + ")" + value + "("+next.value+")";
	}
    }

    private class MyLinkedListIterator implements Iterator<Integer> {
	private LNode start;
	private MyLinkedList linkedList;
	private MyLinkedListIterator(MyLinkedList linkedList) {
	    this.linkedList = linkedList;
	    start = linkedList.start;
	}
	public Integer next() {
	    if (hasNext()) {
		int ans = start.value;
		if (start.next != null) start = start.next;
		else start = null;
		return ans;
	    }
	    else {
		throw new NoSuchElementException();
	    }
	}
	public boolean hasNext() {
	    return start != null;
	}
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

    public Iterator<Integer> iterator() {
	return new MyLinkedListIterator(this);
    }
    
    /*public boolean add(int value) {
	size++;
	int i = 0;
	LNode current;
	if (size == 1) {
	    start = new LNode(value);
	    current = start;
	}
	else {
	    current = start;
	    while (i < size-2) {
		//must end at size-2 because you're starting at start.next (index 1) and you've increased the size by one in the variable without actually adding to the list, so you should loop until 1 less than the end
		current = current.next;
		i++;
	    }
	    current.next = new LNode(value);
	    (current.next).prev = current;
	}
	//System.out.println(current.value+","+i);
	return true;
	}*/

    public void add(int value) {
	if (size == 0) {
	    start = new LNode(value);
	    end = start;
	    size++;
	    return;
	}
	end.next = new LNode(value);
	end.next.prev = end;
	end = end.next;
	size++;
    }

    /*public boolean add(int value) {
	LNode prev = start;
	int next = 0;
	size++;
	int i = 1;
	while (i < size) {
	    prev.next = new LNode(prev.value);
	    prev = prev.next;
	    i++;
	}
	if (size > 1) start.value = value;
	else start = new LNode(value);
	return true;
	}*/
    
    public int size() {
	return size;
    }
    
    /*public int get(int index) {
	exception(index);
	LNode current = start;
	int i = 0;
	while (i < index) {
	    current = current.next;
	    i++;
	}
	return current.value;
	}*/

    public int get(int index) {
	return getNode(index).value;
    }

    /*public int set(int index, int newValue) {
	exception(index);
	LNode current = start;
	int i = 0;
	while (i < index) {
	    current = current.next;
	    i++;
	}
	int oldValue = current.value;
	current.value = newValue;
	return oldValue;
	}*/

    public int set(int index, int newValue) {
	LNode node = getNode(index);
	int ans = get(index);
	node.value = newValue;
	return ans;
    }
    
    /*public int indexOf(int value) {
	LNode current = start;
	int i = 0;
	while (i < size) {
	    current = current.next;
	    if (get(i) == value) return i;
	    else i++;
	}
	return -1;
	}*/

    public int indexOf(int value) {
	int i = 0;
	while (i < size) {
	    if (get(i) == value) return i;
	}
	return -1;
    }

    /*public void add(int index, int value) {
	if (size == 0 || size == index) {
	    add(value);
	    return;
	}
	exception(index);
	LNode current = new LNode(get(index));
	for (int i = index+1; i < size; i++) {
	    current.next = new LNode(get(i));
	    (current.next).prev = current;
	    set(i,current.value);
	    current = current.next;
	}
	add(current.value);
	set(index,value);
	}*/

    public void add(int index, int value) {
	if (size == 0 || index == size) {
	    add(value);
	    return;
	}
	LNode current = getNode(index);
	LNode newbie = new LNode(value);
	newbie.next = current;
	if (index > 0) {
	    newbie.prev = current.prev;
	    newbie.prev.next = newbie;
	}
	size++;
    }
	
    /*public int remove(int index) {
	exception(index);
	int ans = get(index);
	int i = index;
	LNode current = new LNode(get(index-1));
	while (i < size-1) {
	    current.next = new LNode(get(i+1));
	    set(i,current.next.value);
	    current = current.next;
	    i++;
	}
	size--;
	//System.out.println("final: " + this);
	return ans;
	}*/

    public int remove(int index) {
	LNode node = getNode(index);
	int ans = node.value;
	if (index > 0 && index < size-1) {
	    node.prev.next = node.next;
	    node.next.prev = node.prev;
	}
	else if (index == 0) {
	    start = node.next;
	}
	else {
	    end.prev.next = null;
	}
	size--;
	return ans;
    }

    private LNode getNode(int index) {
	exception(index);
	int i = 0;
	LNode current = start;
	while (i < index) {
	    current = current.next;
	    i++;
	}
	return current;
    }

    private void exception(int index) {
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Error: LinkedList does not contain a node at specified index: " + index);
    }
    
    public String toString() {
	String ans = "";
	int i = 0;
	while (i < size) {
	    if (i > 0) ans += ", ";
	    ans += get(i);
	    i++;
	}
	return "[" + ans + "]";
    }

    //toStringDebug
    /*public String toString() {
	String ans = "";
	int i = 0;
	while (i < size) {
	    if (i > 0) ans += ", ";
	    ans += getNode(i);
	    i++;
	}
	return "[" + ans + "]";
	}*/

    /*public static void main(String[] args) {
	MyLinkedList l = new MyLinkedList();
	l = new MyLinkedList();
	//System.out.println(l);
	for (int i = 0; i < 11; i++) {
	    l.add(i);
	    //  System.out.println(l + "," + l.start.value + "," + l.end.value);
	}
	System.out.println(l);
	for (int j : l) System.out.println(j);
	System.out.println(l);
	//	System.out.println(l + "," + l.start.value + "," + l.end.value);
	l.add(5,100);
	//	System.out.println(l + "," + l.start.value + "," + l.end.value);
	l.add(8,77);
	//	System.out.println(l.get(8));
	//System.out.println(l + "," + l.start.value + "," + l.end.value);
	l.remove(8);
	//	System.out.println(l + "," + l.start.value + "," + l.end.value);
	l.set(8,14);
	//	System.out.println(l + "," + l.start.value + "," + l.end.value);
	l.add(777);
	//System.out.println(l + "," + l.start.value + "," + l.end.value);
	l.add(4,74);
	//	System.out.println(l + "," + l.start.value + "," + l.end.value);
	while (l.size > 4) {
	    l.remove(3);
	    //  System.out.println(l + "," + l.start.value + "," + l.end.value);
	}
	//	System.out.println(l + "," + l.start.value + "," + l.end.value);
	Iterator<Integer> it = l.iterator();
	System.out.println(it.hasNext());
	System.out.println(it.next());
	for (int i : l) System.out.println(i);
    }
    */
}
