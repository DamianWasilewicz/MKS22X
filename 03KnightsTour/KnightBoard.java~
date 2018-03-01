public class KnightBoard{
   private int[][] moveset ={ {2,1} , {2,-1} , {-2, 1} , {-2,  -1} , {1, 2} , {1, -2} , {-1, 2} , {-1, -2}};
   private int[][] board;
   public KnightBoard(int startingRows, int startingCols){
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException("You can't have negative startings rows or starting columns");
	}
	int[][] data = new int[startingRows][startingCols];
	board = data;
   }
public boolean solve(int StartingRow, int StartingCol){
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c< board[r].length; c++){
		if(board[r][c] != 0){
		    throw new IllegalStateException("Your board cannot start with any nonzero numbers");
		}
	    }
	}
	if(StartingRow < 0 || StartingCol < 0){
	    throw new IllegalArgumentException("You can't have negative StartingRows or StartingCols");
	}
	return solveHelper(StartingRow, StartingCol, 1);
  }
 public boolean solveHelper(int StartingRow, int StartingCol, int level){
   if(level == board.length * board[0].length && board[StartingRow][StartingCol] == 0){
     board[StartingRow][StartingCol] = level;
     return true;
   }
  for(int counter = 0; counter < moveset.length; counter++){
	    if(!(StartingRow + moveset[counter][0] >= board.length||
	       StartingRow + moveset[counter][0] < 0||
	       StartingCol + moveset[counter][1] >= board[0].length||
	       StartingCol + moveset[counter][1] < 0 ||
         board[StartingRow + moveset[counter][0]][StartingCol + moveset[counter][1]] != 0)) {
        board[StartingRow][StartingCol] = level;
         if(solveHelper(StartingRow + moveset[counter][0], StartingCol + moveset[counter][1], level + 1)){
           return true;
         }
         else {
           board[StartingRow][StartingCol] = 0;
         }
         }
       }
       return false;
     }
     public int countSolutions(int StartingRow, int StartingCol){
     	for(int r = 0; r < board.length; r++){
     	    for(int c = 0; c< board[r].length; c++){
     		if(board[r][c] != 0){
     		    throw new IllegalStateException("Your board cannot start with any nonzero numbers");
     		}
     	    }
     	}
     	if(StartingRow < 0 || StartingCol < 0){
     	    throw new IllegalArgumentException("You can't have negative StartingRows or StartingCols");
     	}
     	return countSolutionsHelper(StartingRow, StartingCol, 1);
       }
  public int countSolutionsHelper(int StartingRow, int StartingCol, int level){
       int number = 0;
       if(level == board.length * board[0].length && board[StartingRow][StartingCol] == 0){
         return 1;
       }
      for(int counter = 0; counter < moveset.length; counter++){
         if(!(StartingRow + moveset[counter][0] >= board.length||
            StartingRow + moveset[counter][0] < 0||
            StartingCol + moveset[counter][1] >= board[0].length||
            StartingCol + moveset[counter][1] < 0 ||
             board[StartingRow + moveset[counter][0]][StartingCol + moveset[counter][1]] != 0)) {
            board[StartingRow][StartingCol] = level;
            number+=countSolutionsHelper(StartingRow + moveset[counter][0], StartingCol + moveset[counter][1], level + 1);
            board[StartingRow][StartingCol] = 0;
             }
           }
           return number;
         }

public String toString(){
	int counter = 0;
	String answer = new String("");
	for(int r = 0; r<board.length;r++){
	    for(int c = 0; c<board[r].length;c++){
    if(board[r][c] != 0){
    		    answer+= board[r][c] + " ";
    		    counter++;
    		}
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
