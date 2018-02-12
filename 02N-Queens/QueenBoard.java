public class QueenBoard{
   
public class QueenBoard{
    public static void main(String[] args){
	QueenBoard test = new QueenBoard(5);
	System.out.println(test.toString());
	System.out.println("---------------------");
	test.addQueen(0, 0);
	System.out.println("---------------------");
	System.out.println(test.toString());
	System.out.println("---------------------");
	test.addQueen(2, 1);
	System.out.println(test.toString());
	System.out.println("---------------------");
	test.removeQueen(0, 0);
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
	if(board[r][c] != 0){
	    return false;
	}
	for(int c1 = 0; c1< board.length; c1++){
	    for(int c2 = 0; c2<board[r].length; c2++){
		if(c1 == r || c2 == c ||
		   c1 + c2 == r + c || c1 - c2 == r - c){
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
	for(int c1 = 0; c1< board.length; c1++){
	    for(int c2 = 0; c2<board[r].length; c2++){
		if(c1 == r || c2 == c ||
		   c1 + c2 == r + c || c1 - c2 == r - c){
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
		if(board[counter][counter2] > 0){
		    answer+= "L ";
		    c++;
		}
		if(board[counter][counter2] < 0){
		    answer+= "Q ";
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
}
	
            }
}
