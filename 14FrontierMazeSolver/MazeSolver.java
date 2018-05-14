import java.io.FileNotFoundException;
public class MazeSolver{
  private Maze maze;
  private Frontier frontier;
  public static void main(String[] args){
    try{
    MazeSolver test = new MazeSolver("data3.dat");
    System.out.println(test.maze);
    System.out.println(test.solve(1));

     }catch(FileNotFoundException e){
       System.out.println("File not found");
       System.exit(1);
     }
    }
  public MazeSolver(String mazeText) throws FileNotFoundException{
    maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){
    return solve(0);
  }
  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    if(mode == 0){
      frontier = new FrontierQueue();
    }
    else{
      frontier = new FrontierStack();
    }
    Location e = maze.getEnd();
    frontier.add(maze.getStart());
    while(frontier.hasNext()){
      Location temp = frontier.next();
      System.out.println(maze);
      Location[] neighbors = maze.getNeighbors(temp);
      if(!temp.equals(maze.getStart())){
        maze.set(temp.getX(), temp.getY(), '.');
      }
      for(Location n : neighbors){
        if(n != null){
        if(n.getX() == e.getX() && n.getY() == e.getY()){
          while(!temp.equals(maze.getStart())){
            maze.set(temp.getX(), temp.getY(), '@');
            temp = temp.getPrev();
          }
          return true;
        }
          frontier.add(n);
          maze.set(n.getX(), n.getY(), '?');
        }
      }
    }
    return false;
  }

  public String toString(){
    return maze.toString();
  }
}
