public class QueenBoard{
  /*public static void main(String[]args){
         QueenBoard test = new QueenBoard(8);
         System.out.println(test);
         test.addQueen(4,4);
 	   System.out.println(test);
 	   test.addQueen(7,5);
 	   System.out.println(test);
 	   test.addQueen(6,1);
 	   System.out.println(test);
 	// test.removeQueen(4,4);
 	       System.out.println(test);
 	//System.out.println(test.solve());
       //  System.out.println(test);

         QueenBoard test2 = new QueenBoard(2);
         System.out.println(test2.solve());
         System.out.println(test2);

 	    QueenBoard b = new QueenBoard(4);
 	   System.out.println(b.solve()); //prints true
     System.out.println(b); //prints a valid solution
     try{
       b.solve();
     }catch(IllegalStateException e){
       System.out.println("Error: The board contains non-zero values");
     } //prints "Error: The board contains non-zero values"
     try{
       b.countSolutions();
     }catch(IllegalStateException e){
       System.out.println("Error: The board contains non-zero values");
     } //prints "Error: The board contains non-zero values"
     for (int i = 0; i < 12; i++){
       QueenBoard a = new QueenBoard(i);
       System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
        /*        Expected Values
        i --> # of Solutions   i --> # of Solutions
       0 --> 1                      6 --> 4
       1 --> 1                      7 --> 40
       2 --> 0                      8 --> 92
       3 --> 0                      9 --> 352
       4 --> 2                    10 --> 724
       5 --> 10                  11 --> 2680
        System.out.println(a); //prints out an empty i by i grid of underscores
     }
   } */
    //board field;
    private int[][] board;
    //constucts board of size n by n;
public QueenBoard(int size){
	int[][] b = new int[size][size];
	for(int counter = 0; counter < size; counter++){
	    for(int counter2 = 0; counter2 < size; counter2++){
		b[counter][counter2] = 0;
	    }
	}
	board = b;
    }
    //adds queen to row r col c, returns true if move is possible
  private boolean addQueen(int r, int c){
	     if(board[r][c] != 0){
         return false;
       }
       for(int c1 = 0; c1 < board.length; c1++){
         for(int c2 = 0; c2 < board[c1].length; c2++){
           if(c1 == r || c2 == c || c1 - c2 == r-c || c1 + c2 == r + c){
             board[c1][c2]+= 1;
           }
         }
       }
       board[r][c] = -1;
       return true;
}
//removes queen from row r col c, returns true as long as space is occupied by queen
private boolean removeQueen(int r, int c){
   if(board[r][c] != -1){
     return false;
   }
   for(int c1 = 0; c1 < board.length; c1++){
     for(int c2 = 0; c2 < board[c1].length; c2++){
       if(c1 == r || c2 == c || c1 - c2 == r-c || c1 + c2 == r + c){
         board[c1][c2]-= 1;
       }
     }
   }
   board[r][c] = 0;
   return true;
}
//tests if its possible to fit n queens on an n by n board;
public boolean solve(){
  for(int c = 0; c < board.length; c++){
    for(int c2 = 0; c2<board[c].length; c2++){
      if(board[c][c2] != 0){
        throw new IllegalStateException("Your board cannot start with any nonzero numbers");
      }
    }
  }
  return solveR(0);
}
//helper function for solve
public boolean solveR(int col){
  if(col == board.length){
    return true;
  }
  for(int row = 0; row<board.length; row++){
    if(addQueen(row,col)){
      if(solveR(col + 1)){
        return true;
      }
      removeQueen(row,col);
    }
  }
  return false;
}
//counts the number of possible solutions for an n by n board;
public int countSolutions(){
  for(int c = 0; c < board.length; c++){
    for(int c2 = 0; c2<board[c].length; c2++){
      if(board[c][c2] != 0){
        throw new IllegalStateException("Your board cannot start with any nonzero numbers");
      }
    }
  }
  return countSolutionsR(0, 0);
}
//helper function for countSolutions;
public int countSolutionsR(int col, int counter){
  int number = counter;
  if(col == board.length){
    return 1;
  }
  for(int row = 0; row<board.length; row++){
    if(addQueen(row,col)){
        number+= countSolutionsR(col + 1, 0);
      }
      removeQueen(row,col);
    }
  return number;
}
//prints board;
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
    if(board[counter][counter2] != -1){
		    answer+= "_ ";
		    c++;
		}
	  }
    }
    return answer;
}
}
