import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze{
    private char[][]maze;

    private boolean animate;

    public Maze(String filename) throws FileNotFoundException{
	     char[][] data;
	     ArrayList mazeInfo = new ArrayList<char[]>();
	     Scanner inf = new Scanner(new File(filename)) ;
	     while(inf.hasNextLine()){
		       String line = inf.next();
		       mazeInfo.add(line.toCharArray());
	     }
	     for(int counter = 0; counter < mazeInfo.size(); counter++){
	       for(int counter1 = 0; counter1 < mazeInfo.get(0).length; counter1++){
           data[counter][counter1] = mazeInfo.get(counter)[counter1];
         }
       }
      maze = data;
      int num = 0;
      for(int counter = 0; counter < maze.length; counter++){
        for(int counter1 = 0; counter1 < maze[0].length; counter1++){
        if(num > 1){
          throw new IllegalStateException();
        }
        if(maze[counter][counter1] == 'E'){
          num++;
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
}
