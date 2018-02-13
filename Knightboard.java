public class Knightboard{
    public static void main(String[] args){
	Knightboard test = new Knightboard(5, 7);
    }
    private int[][] board;
    public Knightboard(int startingRows, int startingCols){
	if(startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
	}
	int[][] data = new int[startingRows][startingCols];
	board = data;
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
	
	
