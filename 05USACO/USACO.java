import java.util.*;
import java.io.*;

public class USACO{
    public static int silver(String filename){
      filewords = new Arraylist<char[][]>;
   try{
         Scanner in = new Scanner(new file(filename);
         while(in.hasNext()){
         char[] row = in.nextLine.toCharArray();
         Filewords.add(row);
        }
      }
   }
    catch(FileNotFoundException e){
         System.out.println(“File Not Found”);
    }
   char[] firstline = filewords.get(0);
   char[] lastline = filewords.get(filewords.size()-1);
   int counter = 1;
   char[][] firstArray = new char[firstline[0]][firstline[1]];
   for(int c1 = 0; c1 < firstArray.length; c1++){
       for(int c2 = 0; c2 < firstArray[c1].length; c2++){
	   firstArray[c1][c2] = filewords.get(counter);
	   counter++;
       }
   }
   
    
      

