import java.util.*;
public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words,s,"",0);
	Collections.sort(words);
	return words;
    }
  
    private static void help(ArrayList<String> words, String s, String str, int ind) {
	try {
	    help(words,s,str+s.charAt(ind),ind+1);
	    help(words,s,str,ind+1);
	}
	catch (IndexOutOfBoundsException e) {
	    words.add(str);
	}
	return;
    }

    /*public static void main(String[] args) {
	Quiz2Redux q = new Quiz2Redux();
	ArrayList<String> ary = q.combinations(args[0]);
	String[] c = ary.toArray(new String[ary.size()]);
	System.out.println(Arrays.toString(c));
	}*/
    
}
