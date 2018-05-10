import java.util.Stack;
public class FrontierStack implements Frontier{
  private Stack<Location> stack;
  public FrontierStack(){
    stack = new Stack<Location>();
  }
  public Location next(){
    return stack.pop();
  }
  public void add(Location n){
    stack.add(n);
  }
  public boolean hasNext(){
    return (stack.size()!= 0);
  }
}
