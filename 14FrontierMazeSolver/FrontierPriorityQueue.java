public class FrontierPriorityQueue implements Frontier{
  private MyHeap<Location> pQueue;
  public FrontierPriorityQueue(){
    pQueue = new MyHeap<Location>(false);
  }
  public Location next(){
    return pQueue.remove();
  }
  public void add(Location n){
    pQueue.add(n);
  }
  public boolean hasNext(){
    return pQueue.size() != 0;
  }
}
