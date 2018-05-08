public interface Frontier{
  Location next();
  void add(Location n);
  boolean hasNext();
}
