import java.util.Deque;
public class FrontierStack implements Frontier{
  private Deque<Location> stack;
  public Location next(){
    return stack.removeFirst();
  }
  public void add(Location n){
    stack.addFirst(n);
  }
  public boolean hasNext(){
    return !(stack.peekFirst() == null);
  }
}
