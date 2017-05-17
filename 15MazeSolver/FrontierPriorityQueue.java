public class FrontierPriorityQueue implements Frontier {
    private MyHeap locations;
    private int size;
    public FrontierPriorityQueue() {
	locations = new MyHeap();
	size = 0;
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
