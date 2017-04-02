public class MyLinkedList {
    private LNode start;
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
	private LNode(int val) {
	    value = val;
	}
	private LNode(int val, LNode nex) {
	    value = val;
	    next = nex;
	}
    }
    
    public boolean add(int value) {
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
	}
	//System.out.println(current.value+","+i);
	return true;
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
    
    public int get(int index) {
	exception(index);
	LNode current = start;
	int i = 0;
	while (i < index) {
	    current = current.next;
	    i++;
	}
	return current.value;
    }

    public int set(int index, int newValue) {
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
    }
    
    public int indexOf(int value) {
	LNode current = start;
	int i = 0;
	while (i < size) {
	    current = current.next;
	    if (get(i) == value) return i;
	    else i++;
	}
	return -1;
    }

    public void add(int index, int value) {
	if (size == 0) {
	    add(value);
	    return;
	}
	exception(index);
	LNode current = new LNode(get(index));
	for (int i = index+1; i < size; i++) {
	    current.next = new LNode(get(i));
	    set(i,current.value);
	    current = current.next;
	}
	add(current.value);
	set(index,value);
    }

    public int remove(int index) {
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
    }

    private void exception(int index) {
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Error: LinkedList does not contain a node at specified index");
    }
    
    public String toString() {
	LNode current = start;
	String ans = "";
	int i = 0;
	while (i < size) {
	    if (i > 0) ans += ", ";
	    ans += current.value;
	    current = current.next;
	    i++;
	}
	return "[" + ans + "]";
    }

    public static void main(String[] args) {
	MyLinkedList l = new MyLinkedList();
	l = new MyLinkedList();
	System.out.println(l);
        for (int i = 0; i < 11; i++) l.add(i);
	System.out.println(l);
	l.add(5,100);
	System.out.println(l);
	l.add(8,77);
	System.out.println(l.get(8));
	System.out.println(l);
	l.remove(8);
	System.out.println(l);
	l.set(8,14);
	System.out.println(l);
	l.add(777);
	System.out.println("error?" +l);
	l.add(4,74);
	System.out.println(l);
    }
}
    
