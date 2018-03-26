import java.util.Arrays;
public class InsertionSort{
  public static void main(String[] args){
    int[] test = new int[] {10, 2, 4, 3, 0, 5, 6, 1, 7, 9, 8};
    InsertionSort.insertionSort(test, 4, 7);
    System.out.println(Arrays.toString(test));
  }
public static void insertionSort(int[] data, int sP, int eP){
    for(int counter = sP; counter <= eP; counter++){
      for(int counter1 = counter; counter1 > sP; counter1--){
        if(data[counter1] < data[counter1 -1]){
        swap(data, counter1 - 1, counter1);
        }
       }
    }
  }
  public static void swap(int[] ary, int a, int b){
    int c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }
}
