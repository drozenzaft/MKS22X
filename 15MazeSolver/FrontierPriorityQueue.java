public class FrontierPriorityQueue implements Frontier {
    private MyHeap locations;
    private int size;
    public FrontierPriorityQueue(boolean b) {
	locations = new MyHeap(b);
	size = 0;
    }
    public int size() {
	return size;
    }
    public void add(Location coord) {
	size++;
	locations.add(coord);
    }
    public Location next() {
	size--;
	return locations.remove();
    }
}
