import java.util.Random;
public class QuickSelect{
  public static void main(String[] args){
    int[] test = new int[] {400, 60, 7, 300, 5000, 3, 9, 10000, 15, 200,70, 274};
    QuickSelect.partition(test, 0, 10);
  System.out.println(toString(test));
  }
  //public static
  public static int partition(int[] data, int start, int end){
    Random rand = new Random();
    int pivotIndex = rand.nextInt(end-start + 1) + start;
    int lessThan = start;
    int i = start;
    int greaterThan = end;
    while(i <= greaterThan){
      if(data[i] == data[pivotIndex]){
        i++;
      }
      else if(data[i] > data[pivotIndex]){
	      swap(data, i, greaterThan);
	      greaterThan--;
      }
      else{
        swap(data, lessThan, i);
        lessThan++;
	i++;
      }
    }
    System.out.println("" + start + "," + end "  " + 
    return greaterThan;
    }
    public static void swap(int[] ary, int a, int b){
   int c = ary[a];
   ary[a] = ary[b];
   ary[b] = c;
 }
 public static int quickSelect(int[] data, int k){
   int start = 0;
   int end = data.length - 1;
    int i = partition(data, 0, data.length - 1);
    while(i != k){
    if(i > k){
      end = i;
    }
    if(i < k){
      start = i;
    }
    i = partition(data, start, end);
  }
  return data[i];
 }
public static void quickSort(int[] data){
  quickSortH(data, 0, data.length - 1);
}
public static void quickSortH(int[] data, int start, int end){
  int i = partition(data, start, end);
  if(end> start + 1){
    quickSortH(data, start, i);
    quickSortH(data, i, end);
  }
  }

  public static String toString(int[] data){
    String answer = "[";
    for(int counter = 0; counter < data.length; counter++){
      answer+= data[counter] + " ";
    }
    answer+= "]";
    return answer;
  }
}
