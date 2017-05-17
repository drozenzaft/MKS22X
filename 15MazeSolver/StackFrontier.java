import java.util.*;
public class StackFrontier implements Frontier {
    private Stack<Location> locations;
    private int size;
    public StackFrontier() {
	locations = new Stack<Location>();
	size = 0;
    }
    public int size() {
	return size;
    }
    public void add(Location coord) {
	locations.push(coord);
	size++;
    }
    public Location next() {
	size--;
	return locations.pop();
    }
}
