public class QueenBoard{
    public static void main(String[] args){
	QueenBoard test = new QueenBoard(5);
	System.out.println(test.toString());
  System.out.println("------------------------------");
  test.addQueen(0, 0);
  System.out.println(test.toString());
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
	     if(board[r][c] == 0){
         board[r][c] = -1;
           for(int c1 = 0; c1 < board[r].length; c1++){
             if(c1!= c){
               board[r][c1]+=1;
         }
         for(int c1 = 0; c1 < board[r].length; c1++){
           if(c1!= c){
             board[r][c1]+=1;
       }
       }
         return true;
       }
       else{
         return false;
       }
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
		if(board[counter][counter2] < 0){
		    answer+= "Q ";
		    c++;
		}
    if(board[counter][counter2] > 0){
		    answer+= "1 ";
		    c++;
		}
		else{
		    answer+= "_ ";
		    c++;
		}
	  }
	}
	return answer;
    }
}
