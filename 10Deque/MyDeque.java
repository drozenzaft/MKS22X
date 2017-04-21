public interface MyDeque extends Queue {
  private int front;
  private int back;
  private int size;
  private String[] deque;
  
  public MyDeque() {
    size = 10;
    front = 0;
    back = 0;
    deque = new String[size];
  }
  
  private void nPE(String s) {
    try {
      int a = s.length();
    }
    catch (NullPointerException e) {
      throw new NullPointerException("Specified element is null: " + s);
    }
  }
  
  public void addFirst(String s) {
    nPE(s);
    
}
