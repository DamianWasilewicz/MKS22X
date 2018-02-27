import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{
    private char[][]maze;
    
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException(){
	int row = 0;
	int col = 0;
        File text = new File(filename);
	Scanner inf = new Scanner(text);
	   while(int.hasNextLine()){
           	if(col == char[row].length - 1){
		    col = 0;
		    row+= 1;
		}
		String line = inf.nextLine();
		char[row][col] = line.substring(col, col + 1);
		col++;
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
