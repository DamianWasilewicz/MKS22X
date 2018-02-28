import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{
    private char[][]maze;
    
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException(){
	int row = 0;
	int col = 0;
	char[][] data = new char[][];
	mazeInfo = new ArrayList<String>();
	Scanner inf = new Scanner(new File(filename)) ;
	   while(int.hasNextLine()){
		String line = inf.next();
		mazeInfo.add(line);
	   }
	   for(int counter = 0; counter < mazeInfo.size(); counter++){
	       
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
