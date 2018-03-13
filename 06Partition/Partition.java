import java.util.Random;
public class Partition{
  public static void main(String[] args){
    int[] test = new int[] {4, 6, 7, 3, 5, 3, 9, 10, 15, 2,7, 27};
    System.out.println(Partition.partition(test, 4, 9));
  }
  public static int partition(int[] data, int start, int end){
    Random rand = new Random();
    int pivotIndex = rand.nextInt(end-start + 1) + start - 1;
    int pivotElement = data[pivotIndex];
    int[] sorted = new int[data.length];
    /*for(int counter = start; counter <= end; counter++){
      sorted[c] = data[counter];
      c++;
    }*/
    int lessThan = start;
    int greaterThan = end;
    for(int counter = start; counter < end + 1; counter++){
      sorted[pivotIndex] = pivotElement;
      if(data[counter] < pivotElement){
        sorted[lessThan] = data[counter];
        lessThan++;
      }
      if(data[counter] > pivotElement){
      sorted[greaterThan] = data[counter];
        greaterThan--;
      }
    }
    System.out.println(toString(sorted));
    return greaterThan;
    }
    public static void swap(int[] ary, int a, int b){
   int c = ary[a];
   ary[a] = ary[b];
   ary[b] = c;
 }


 public static String toString(int[] arr){
   String answer = "";
  for(int counter = 0; counter < arr.length ; counter++){
    answer+= " " + arr[counter];
 }
 return answer;
  }
}
