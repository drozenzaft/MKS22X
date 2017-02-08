public class Recursion {
    public static String name() {
	return "Rozenzaft,Daniel";
    }
    private static boolean isCloseEnough(double a, double b) {
	return Math.abs(a-b)/b <= 0.000000000000001;
    }
    public static double sqrt(double n) {
	return sqrt2(n,1);
    }
    private static double sqrt2(double n, double guess) {
        if (n < 0)
	    throw new IllegalArgumentException("Domain Error: input is less than 0");
	if (n == 0)
	    return 0.0;
	guess = (n / guess + guess) / 2.0;
	//System.out.println(guess);
	if (isCloseEnough(n,guess*guess))
	    return guess;
	return sqrt2(n,guess);
    }
    public static void main(String[] args) {
	//System.out.println(name());
	//System.out.println(sqrt(100));
	//System.out.println(sqrt(2));
	//for (int i = 0; i <= 20; i++) {
	//    System.out.println(sqrt(i));
	//}
	//System.out.println(sqrt(-0.100));
	//System.out.println(isCloseEnough(1000000000,1000000002));
    }
}
