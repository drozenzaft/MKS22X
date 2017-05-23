import java.util.*;
public class QueueFrontier implements Frontier {
    private ArrayDeque<Location> locations;
    private int size;
    public QueueFrontier() {
	locations = new ArrayDeque<Location>();
	size = 0;
    }
    public int size() {
	return size;
    } 
    public void add(Location coord) {
	locations.add(coord);
	size++;
    }
    public Location next() {
	size--;
	return locations.removeFirst();
    }
}
