import java.util.Stack;
public class Postfix {

    private static double apply(String op, double a, double b) {
	switch (op) {
	    case "+":
		return b + a;
	    case "-":
		return b - a;
	    case "*":
		return b * a;
	    case "/":
		return b / a;
	    case "%":
		return b % a;
	}
	return 0;
    }

    private static boolean isOperator(String s) {
	return s.equals("+")
	    || s.equals("-")
	    || s.equals("*")
	    || s.equals("/")
	    || s.equals("%");
    }

    public static double eval(String s) {
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
	for (String token : tokens) {
	    if (isOperator(token)) values.push(apply(token,values.pop(),values.pop()));
	    else values.push(Double.parseDouble(token));
	}
	return values.pop();
    }

    public static void main(String[] args) {
	System.out.println(eval("10 2.0 +"));
	System.out.println(eval("11 3 - 4 + 2.5 *"));
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
    
}
