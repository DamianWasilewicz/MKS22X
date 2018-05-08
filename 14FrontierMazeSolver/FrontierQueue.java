import java.util.Deque;
public class FrontierQueue implements Frontier{
  private Deque<Location> queue;
  public Location next(){
    return queue.removeFirst();
  }
  public void add(Location n){
    queue.addLast(n);
  }
  public boolean hasNext(){
    return !(queue.peekFirst() == null);
  }
}
