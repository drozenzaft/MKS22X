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
  
  private static boolean help(ArrayList<String> words, String s, String str, int i) {
    if (i > s.length()) return true;
    if (!words.contains(str)) {
      words.add(str);
      if (i < s.length() && (help(words,s,str+s.charAt(i),i+1) || help(words,s,""+s.charAt(i),i+1))) return true;
    }
    return false;
  }

    public static void main(String[] args) {
	Quiz2Redux q = new Quiz2Redux();
	ArrayList<String> ary = q.combinations(args[0]);
	String[] c = ary.toArray(new String[ary.size()]);
	System.out.println(Arrays.toString(c));
    }
    
}
