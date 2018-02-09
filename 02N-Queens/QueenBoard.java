public class QueenBoard{
    public static void main(String[] args){
	QueenBoard test = new QueenBoard(5);
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
	if(
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
		else{
		    answer+= "_ ";
		    c++;
		}
	    }
	}
	return answer;
    }
}
	
        
