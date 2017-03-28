public class MyLinkedList {
    private LNode start;
    private int size;
    public MyLinkedList(LNode first, int howBig) {
	start = first;
	size = howBig;
    }
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
	start.next = new LNode(value);
	return true;
    }
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
	exception(index);
	size++;
	LNode last;
	for (int i = index+1; i < size; i++) {
	    last = new LNode(get(i));
	    set(i,get(i-1));
	}
    }

    public int remove(int index) {
	exception(index);
	int ans = get(index);
	for (int i = index; i < size-1; i++) set(i,get(i+1));
	size--;
	return ans;
    }

    private void exception(int index) {
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Error: LinkedList does not contain a node at specified index");
    }
    
    public String toString() {
	LNode current = start;
	String ans = "[";
	int i = 0;
	while (i < size) {
	    ans += current.value + ", ";
	    current = current.next;
	    i++;
	}
	return ans + "]";
    }
}
    
