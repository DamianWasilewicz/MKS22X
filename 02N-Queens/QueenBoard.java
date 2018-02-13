public class QueenBoard{
    public static void main(String[] args){
	QueenBoard test = new QueenBoard(10);
	/*System.out.println(test.toString());
  System.out.println("------------------------------");
  test.addQueen(0, 0);
  System.out.println(test.toString());
  test.addQueen(2,1);
  System.out.println("------------------------------");
  System.out.println(test.toString());
  System.out.println("------------------------------");
  test.removeQueen(2,1);
  System.out.println(test.toString());
  System.out.println("------------------------------");
  test.removeQueen(0,0);
  System.out.println(test.toString());
  System.out.println("------------------------------");*/
  System.out.println(test.solve());
    }
    private int[][] board;
    public QueenBoard(int size){
	int[][] b = new int[size][size];
	for(int counter = 0; counter < size; counter++){
	    for(int counter2 = 0; counter2 < size; counter2++){
		b[counter][counter2] = 0;
	    }
	}
	board = b;
    }
    private boolean addQueen(int r, int c){
	     if(board[r][c] != 0){
         return false;
       }
       for(int c1 = 0; c1 < board.length; c1++){
         for(int c2 = 0; c2 < board[c1].length; c2++){
           if(c1 == r || c2 == c || Math.abs(c1 - c2) == Math.abs(r-c)){
             board[c1][c2]+= 1;
           }
         }
       }
       board[r][c] = -1;
       return true;
}
private boolean removeQueen(int r, int c){
   if(board[r][c] != -1){
     return false;
   }
   for(int c1 = 0; c1 < board.length; c1++){
     for(int c2 = 0; c2 < board[c1].length; c2++){
       if(c1 == r || c2 == c|| Math.abs(c1 - c2) == Math.abs(r-c)){
         board[c1][c2]-= 1;
       }
     }
   }
   board[r][c] = 0;
   return true;
}
    public String toString(){
	String answer = "";
	int c = 0;
	for(int counter = 0; counter < board.length; counter++){
	    for(int counter2 = 0; counter2 < board[counter].length; counter2++){
		if(c == board.length){
		    answer+= "\n";
		    c = 0;
		}
		if(board[counter][counter2] == -1){
		    answer+= "Q ";
		    c++;
		}
    if(board[counter][counter2] > 0){
		    answer+= "1 ";
		    c++;
		}
    if(board[counter][counter2] == 0){
		    answer+= "_ ";
		    c++;
		}
	  }
    }
    return answer;
}
public boolean solve(){
  return solveR(0);
}
public boolean solveR(int col){
  if(col >= board.length){
    return true;
  }
  for(int row : board[col]){
    if(addQueen(row,col)){
      if(solveR(col + 1)){
        return true;
      }
      removeQueen(row,col);
    }
  }
  return false;
}
}
