public class Driver{

    public static void main(String[]args){
        Maze f;
        for (int i = 0; i < 6; i++) {
	    f = new Maze("data" + i + ".dat");//true animates the maze.
		//        f.setAnimate(true);
	    f.solve();
	    System.out.println("Maze #" + i + ":");
	    System.out.println(f); 
	}
    }
}
