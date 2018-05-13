import java.util.LinkedList;
public class FrontierQueue implements Frontier{
  private LinkedList<Location> queue;
  public FrontierQueue(){
    queue = new LinkedList<Location>();
  }
  public Location next(){
    return queue.remove();
  }
  public void add(Location n){
    queue.add(n);
  }
  public boolean hasNext(){
    return (queue.peek() != null);
  }
}
