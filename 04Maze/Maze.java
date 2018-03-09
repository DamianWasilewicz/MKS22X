import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
    //maze of chars
    private char[][]maze;
    //turns animation on and off
    private boolean animate;
    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
         throw a FileNotFoundException or IllegalStateException
    */
     public static void main(String[] args){
	try{
	Maze f = new Maze("data3.dat");
	f.setAnimate(true);
	System.out.println(f.solve());
	System.out.println(f);}
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	}
    }
    public Maze(String filename) throws FileNotFoundException{
	     String mazeInfo = "";
	     Scanner inf = new Scanner(new File(filename));
       int rows = 0;
       int cols = 0;
	     while(inf.hasNextLine()){
           String temp = inf.nextLine();;
		       mazeInfo+= temp;
		       rows++;
           cols= temp.length();
     }
     maze = new char[rows][cols];
      int index = 0;
	     for(int counter = 0; counter < rows; counter++){
	       for(int counter1 = 0; counter1 < cols; counter1++){
           maze[counter][counter1] = mazeInfo.charAt(index);
           index++;
         }
       }
      int Enum = 0;
      int Snum = 0;
      for(int counter = 0; counter < maze.length; counter++){
        for(int counter1 = 0; counter1 < maze[0].length; counter1++){
        if(Enum > 1 || Snum > 1){
          throw new IllegalStateException();
        }
        if(maze[counter][counter1] == 'E'){
          Enum++;
        }
        if(maze[counter][counter1] == 'S'){
          Snum++;
        }
        }
    }
  }
     private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
    public void setAnimate(boolean b){
	animate = b;
    }
    public void clearTerminal(){
	//erase terminal, go to top left of screen.
	System.out.println("\033[2J\033[1;1H");
    }
    //prints out the maze;
  public String toString(){
    String answer = "";
    int c = 0;
    for(int counter = 0; counter < maze.length; counter++){
      for(int counter1 =0; counter1 < maze[counter].length; counter1++){
        if( c == maze[counter].length){
          answer+= "\n";
          c = 0;
        }
        answer+= maze[counter][counter1];
        c++;
      }
    }
    return answer;
  }
  /*Wrapper Solve Function returns the helper function
     Note the helper function has the same name, but different parameters.
     Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
   */
  public int solve(){
    int startingR = 0;
    int startingC = 0;
      for(int counter = 0; counter < maze.length; counter++){
        for(int counter1 = 0; counter1< maze[counter].length; counter1++){
          if(maze[counter][counter1] == 'S'){
            startingR = counter;
            startingC = counter1;
          }
        }
      }
      return solve(startingR, startingC, 1) - 1;
    }
  private int solve(int r, int c, int numb){
    if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
    int[][] movebank = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
      if(maze[r][c] == 'E'){
        return numb;
      }
      if(maze[r][c] == '#' ||
       maze[r][c] == '.'||
       maze[r][c] == '@'){
         return 0;
       }
       for(int counter = 0; counter < movebank.length; counter++){
         maze[r][c] = '@';
         int num = solve(r + movebank[counter][0], c + movebank[counter][1], numb);
        if(num > 0){
         return 1 + num;
        }
        maze[r][c] = '.';
        num--;
      }
      return 0;
    }
    public int count(){
      int answer = 0;
      for(int counter = 0; counter < maze.length; counter++){
        for(int counter1 = 0; counter1 < maze[counter].length; counter1++){
          if(maze[counter][counter1] == '@'){
            answer++;
          }
        }
      }
      return answer;
    }
  }
