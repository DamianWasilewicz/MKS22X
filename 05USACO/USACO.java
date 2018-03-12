import java.util.*;
import java.io.*;


public class USACO{
  public static void main(String[] args){
    System.out.println(USACO.bronze("SampleInput.txt"));
  }
  /*public static void main(String[] args){
	for (int i = 1; i < 11; i ++){
	    String file = "makelake/makelake." + i; // Remove the "makelake/" if the test files are in the same directory
	    int ans = getAnswer(file + ".out");

	    int ansU = USACO.bronze(file + ".in");

	    System.out.println("Your Answer: " + ansU);
	    System.out.println("Answer: " + ans);
	    System.out.println("Correct? " + (ans == ansU));
	}


	for (int i = 1; i < 11; i ++){
	    String file = "ctravel/ctravel." + i; // Remove the "ctravel/" if the test files are in the same directory
	    int ans = getAnswer(file + ".out");

	    int ansU = USACO.silver(file + ".in");

	    System.out.println("Your Answer: " + ansU);
	    System.out.println("Answer: " + ans);
	    System.out.println("Correct? " + (ans == ansU));
	}
	//System.out.println(USACO.silver("ctravel/ctravel.1.in"));
    }

    public static int getAnswer(String filename){
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);

	    String inty = s.nextLine();
	    return Integer.parseInt(inty);

	}catch (FileNotFoundException e){
	    System.out.println("FILE!");
	}
	return 0;
    }
 */
  public static int bronze(String filename){
    try{
      Scanner in = new Scanner(new File(filename));
      int rows = in.nextInt();
      int cols = in.nextInt();
      int elevation = in.nextInt();
      int numMoves = in.nextInt();
      int[][] lake = new int[rows][cols];
      for(int r = 0; r< rows; r++){
        for(int c = 0; c< cols; c++){
          lake[r][c] = in.nextInt();
        }
      }
      int[][] moveset = new int[numMoves][3];
        for(int counter = 0; counter < numMoves; counter++){
          for(int counter1 = 0; counter1 < 3; counter1++){
            moveset[counter][counter1] = in.nextInt();
          }
        }
      for(int movenum = 0; movenum < numMoves; movenum++){
      int maximumElevation = 0;
      for(int counter = moveset[movenum][0] - 1; counter < moveset[movenum][0] +2 ; counter++){
          for(int counter1 = moveset[movenum][1] - 1; counter1 < moveset[movenum][1] +2 ; counter1++){
            if(lake[counter][counter1] > maximumElevation){
              maximumElevation = lake[counter][counter1];
            }
        }
      }
      int threshold = maximumElevation - moveset[movenum][2];
      for(int counter = moveset[movenum][0] - 1; counter < moveset[movenum][0] + 2 ; counter++){
          for(int counter1 = moveset[movenum][1] - 1; counter1 < moveset[movenum][1] + 2 ; counter1++){
            if(lake[counter][counter1] >= threshold){
              lake[counter][counter1] = threshold;
            }
          }
        }
      }
        int totalAmountofWater = 0;
        for(int counter = 0; counter < rows ; counter++){
            for(int counter1 = 0; counter1 < cols; counter1++){
              if(elevation - lake[counter][counter1] > 0){
                lake[counter][counter1] = elevation - lake[counter][counter1];
              }
              else{
                lake[counter][counter1] = 0;
              }
             totalAmountofWater+= lake[counter][counter1];
           }
         }
         return totalAmountofWater * 6 * 6 * 12 * 12;
}
catch(FileNotFoundException e){
  System.out.println("File not Found");
}
return -1;
}



    public static int silver(String filename){
   try{
         Scanner in = new Scanner(new File(filename));
         int rows = in.nextInt();
         int cols = in.nextInt();
         int time = in.nextInt();
         in.nextLine();
         char[][] firstArray = new char[rows][cols];
         for(int numrow = 0; numrow < rows; numrow++){
        firstArray[numrow] = in.nextLine().toCharArray();
        }
        int R1 = in.nextInt() - 1;
        int C1 = in.nextInt() - 1;
        int R2 = in.nextInt() - 1;
        int C2 = in.nextInt() - 1;
       int[][] secondArray = new int[rows][cols];
       secondArray[R1][C1] = 1;

       int timeCounter = 0;
       while(timeCounter < time){
         int[][] thirdArray = new int[rows][cols];
         for(int r = 0; r < rows; r++){
           for(int c = 0; c < cols; c++){
           if(r > 0){
             thirdArray[r][c] += secondArray[r - 1][c];
           }
           if(r < rows - 1){
             thirdArray[r][c] += secondArray[r + 1][c];
           }
           if(c>0){
             thirdArray[r][c] += secondArray[r][c - 1];
           }
           if(c < cols - 1){
             thirdArray[r][c] +=  secondArray[r][c + 1];
           }
           if(firstArray[r][c] == '*'){
             thirdArray[r][c] = 0;
           }
         }
       }
       for(int r = 0; r < rows; r++){
         for(int c = 0; c < cols; c++){
           secondArray[r][c] = thirdArray[r][c];
         }
       }

       timeCounter++;
     }
      return secondArray[R2][C2];
    }
    catch(FileNotFoundException e){
         System.out.println("file not found");
    }
    return -1;
  }
 public static String toString(int[] input){
   String answer = " ";
   for(int c1 = 0; c1 < input.length; c1++){
    answer += input[c1];
   }
   return answer;
 }
 public static String toString(int[][] input){
   String answer = " ";
   int counter = 0;
   for(int c1 = 0; c1 < input.length; c1++){
     for(int c2 = 0; c2 < input[c1].length; c2++){
       if(counter == 5){
         answer += "\n";
         counter = 0;
       }
    answer += input[c1][c2] + " ";
    counter++;
   }
 }
    return answer;
 }
 }
