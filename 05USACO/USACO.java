import java.util.*;
import java.io.*;


public class USACO{
  public static void main(String[] args){
    System.out.println(USACO.silver("SampleInput.txt"));
  }
    public static int silver(String filename){
    ArrayList<char[]> filewords = new ArrayList<char[]>();
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
       //System.out.println(toString(secondArray));
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
      // System.out.println(toString(secondArray));
       //System.out.println(secondArray[R2][C2]);
       timeCounter++;
     }
      return secondArray[R2][C2];
    }
    catch(FileNotFoundException e){
         System.out.println("file not found");
    }
    return -1;
  }
  /* char[] firstline = filewords.get(0);
   int rows = firstline[0];
   char[] lastline = filewords.get(filewords.size()-1);
   System.out.println(toString(firstline));
   System.out.println(toString(lastline));
   char[][] firstArray = new char[firstline[0]][firstline[2]];
   System.out.println(rows + " " +4 + " " + firstline[0]);
   System.out.println(5 + " " + firstline[2]);
   for(int c1 = 0; c1 < rows; c1++){
       for(int c2 = 0; c2 < 5; c2++){
	   firstArray[c1][c2] = filewords.get(c1 + 1)[c2];
       }
   }
   System.out.println(toString(firstArray));
   int limit = firstline[4];
   return -1;
   */
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
