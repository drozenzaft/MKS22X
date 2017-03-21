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
	for (int i = ind; i <= s.length(); i++) {
	    unique(words,str);
	    try {
		help(words,s,str+s.charAt(i),i+1);
		help(words,s,""+s.charAt(i),i+1);
	    }
	    catch (IndexOutOfBoundsException e) {
		unique(words,str);
	    }
	}
   	return;
    }

    private static void unique(ArrayList<String> ary, String in) {
	int chance = 0;
	for (String a : ary) {
	    if (a.equals(in)) {
		chance++;
	    }
	}
	if (chance == 0) ary.add(in);
    }
    
    /*private static void help(ArrayList<String> words, String s, String str) {
	if (words.size() == (int)(Math.pow(2,s.length))) return;
	for (int i = 0; i < s.length(); i++) {
	    if (!words.contains(str)) words.add(str);
	    */

    /*public static void main(String[] args) {
	Quiz2Redux q = new Quiz2Redux();
	ArrayList<String> ary = q.combinations(args[0]);
	String[] c = ary.toArray(new String[ary.size()]);
	System.out.println(Arrays.toString(c));
	}*/
    
}
