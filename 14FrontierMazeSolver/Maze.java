import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
  private Location start,end;
  private char[][] board;
  public static void main(String[] args){
  	try{
  	Maze f = new Maze("data3.dat");
    System.out.println(f.toString());
  }
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
     board = new char[rows][cols];
      int index = 0;
	     for(int counter = 0; counter < rows; counter++){
	       for(int counter1 = 0; counter1 < cols; counter1++){
           board[counter][counter1] = mazeInfo.charAt(index);
           index++;
         }
       }
     }
  // '#' - wall
  // ' ' - open space
  // '?' - frontier space
  // '.' - visited space
  // 'E' - end space (do not replace this)
  // '@' - part of solution
  // 'S' - starting space (do not replace this)
  public String toString(){
    String answer = "";
    int c = 0;
    for(int counter = 0; counter < board.length; counter++){
      for(int counter1 =0; counter1 < board[counter].length; counter1++){
        if( c == board[counter].length){
          answer+= "\n";
          c = 0;
        }
        answer+= board[counter][counter1];
        c++;
      }
    }
    return answer;
  }

  // Work on this method as a group!
  /*public String toStringColor(){
  }*/

  //return a list of Locations that are:
  // adjacent to n and  not visited
  // all the Locations in this list should have their previous set to n.
  public Location[] getNeighbors(Location n){
    /*int tx = n.getX();
    int ty = n.getY();
    Location[] answer;
    if(tx - 1 >= 0 && board[tx - 1][ty] != '#' && board[tx - 1][ty] != '.' ){

    }*/
    Location[] tempAnswer = new Location[4];
    return tempAnswer;
  }

  public Location getStart(){
    return start;
  }

  public Location getEnd(){
    return end;
  }



}
