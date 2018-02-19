

public class Knightboard{
  public static void main(String[] args){
	Knightboard test = new Knightboard(10, 10);
	System.out.println(test.toString());
  System.out.println(test.solve(0,0));
   }
   private int[] moveset;
   private int[][] board;
   public Knightboard(int startingRows, int startingCols){
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	int[][] data = new int[startingRows][startingCols];
	board = data;
	int[][] moveset  ={ {2,1} , {2,-1} , {-2, 1} , {-2,1} , {1, 2} , {1, -2} , {-1, 2} , {-1, -2}};
   }
public boolean solve(int StartingRow, int StartingCol){
	for(int r = 0; r < board.length; r++){
	    for(int c= 0; c< board[r].length; r++){
		if(board[r][c] != 0){
		    return false;
		}
	    }
	}
	if(StartingRow < 0 || StartingCol < 0){
	    return false;
	}
	return solveHelper(StartingRow, StartingCol, 0);
  }
 public boolean solveHelper(int StartingRow, int StartingCol, int level){
   if(level == board.length * board[0].length){
     return true;
   }
  for(int counter = 0; counter < moveset.length; counter++){
	    if(!(StartingRow + moveset[counter][0] >= board.length||
	       StartingRow + moveset[counter][0] <= board.length||
	       StartingCol + moveset[counter][2] >= board[0].length||
	       StartingCol + moveset[counter][2] <= board[0].length)){
         return solveHelper(StartingRow + moveset[counter][0], StartingCol + moveset[counter][2], level + 1);
         }
       }
       return false;
     }



public String toString(){
	int counter = 0;
	String answer = new String("");
	for(int r = 0; r<board.length;r++){
	    for(int c = 0; c<board[r].length;c++){
		if(board[r][c] == 0){
		    answer+= "__";
		    counter++;
		}
		if(counter == board.length){
		    answer+= "\n";
		    counter = 0;
		}
	    }
	}
	return answer;
   }
}
