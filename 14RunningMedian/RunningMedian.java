public class RunningMedian {
    private MyHeap min;
    private MyHeap max;
    public RunningMedian() {
	min = new MyHeap();
	max = new MyHeap(false);
    }
    public double getMedian() {
	if ((max.size() + min.size()) % 2 == 0)
	    return (max.peek() + min.peek()) / 2.0;
	return oddMedian();
    }
    public void add(int value) {
	if (value >= getMedian()) max.add(value);
	else min.add(value);	
	if (max.size() - min.size() > 1) min.add(max.remove());
	else if (min.size() - max.size() > 1) max.add(min.remove());
    }
    private int oddMedian() {
	if (min.size() > max.size()) return min.peek();
	else return max.peek();
    }
    /*public static void main(String[] args) {
	RunningMedian rm = new RunningMedian();
	rm.add(1);
	rm.add(64);
	rm.add(20);
	System.out.println(rm.getMedian());
	rm.add(34);
	rm.add(44);
	rm.add(49);
	rm.add(56);
	System.out.println(rm.getMedian());
	rm.add(401);
	rm.add(714);
	rm.add(1021);
	rm.add(7814);
	rm.add(9626);
	rm.add(10551);
	rm.add(12717);
	System.out.println(rm.max + ", " + rm.min);
	System.out.println(rm.getMedian());
	}*/
}
