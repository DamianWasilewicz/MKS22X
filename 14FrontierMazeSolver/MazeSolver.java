import java.io.FileNotFoundException;
public class MazeSolver{
  private Maze maze;
  private Frontier frontier;
  private boolean aStar = false;
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
    clearTerminal();
    //System.out.println(this);
    wait(20);
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
    else if(mode == 1){
      frontier = new FrontierStack();
    }
    else if(mode == 2){
      frontier = new FrontierPriorityQueue();
    }
    else{
      frontier = new FrontierPriorityQueue();
      setAStar(true);
    }
    Location e = maze.getEnd();
    frontier.add(maze.getStart());
    while(frontier.hasNext()){
    //  clearTerminal();
      //System.out.println(this);
    //  wait(20);
      Location temp = frontier.next();
      //System.out.println(maze.toString());
      Location[] neighbors = maze.getNeighbors(temp, aStar);
      if(!temp.equals(maze.getStart())){
        maze.set(temp.getX(), temp.getY(), '.');
      }
      for(Location n : neighbors){
        if(n != null){
          if(n.equals(e)){
            while(!temp.equals(maze.getStart())){
              maze.set(temp.getX(), temp.getY(), '@');
              temp = temp.getPrev();
            }
          //  System.out.println(maze.toString());
          return true;
        }
          frontier.add(n);
          maze.set(n.getX(), n.getY(), '?');
        }
      }
    }
    return false;
  }
  public void setAStar(boolean star){
    aStar = star;
  }
  public String toString(){
    return maze.toString();
  }
  private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
     public void clearTerminal(){
 //erase terminal, go to top left of screen.
 System.out.println("\033[2J\033[1;1H");
   }
}
