public class Sorts{
public static void main(String[] args){
  int[] test = new int[10];
  test[0] = 5;
  test[1] = 12;
  test[2] = 2;
  test[3] = 45;
  test[4] = 56;
  test[5] = 34;
  test[6] = 345;
  test[7] = 342;
  test[8] = 5;
  test[9] = 45;
  System.out.println(toString(test));
  heapsort(test);
  System.out.println(toString(test));

}
  /*public static void heapsort(int[] data){
    Heapify(data);
    int l = data.length;
    for(int counter = 0; counter < data.length; counter++){
      remove(data, l);
      l--;
    }
  }*/
  public static void heapsort(int[]data){

 heapify(data);
 int length = data.length - 1;

 for (int i = 0; i < data.length; i++){

     // System.out.println("root " + data[0]);
     //System.out.println("to swap with " + toSwap + "\n");

     swap(data, 0, length);
     pushDownMax(data, 0, length);
     length--;

     //System.out.println(toString(data));
       }
   }
  public static void heapify(int[] data){
    for(int counter = data.length - 1; counter >= 0; counter--){
      pushDownMax(data, counter, data.length);
    }
  }
  public static void pushDownMax(int[] data, int index, int end){
int c = index*2;
if (c + 1 < end && data[index] < data[c+1]  && (c+2 >= end || data[c+2] <= data[c+1]))
{
   swap(data, index, c+1);
   pushDownMax(data, c+1, end);
}

else if (c+2 < end  && data[index] < data[c+2] && (c+1 >= end || data[c+1] <= data[c+2]))
{
   swap(data,index, c+2);
   pushDownMax(data, c+2, end);
}
 }
 public static void swap(int[] ary, int a, int b){
   int c = ary[a];
   ary[a] = ary[b];
   ary[b] = c;
 }
 public static String toString(int[]data){
	String str = "[";
	for (int i = 0; i < data.length ; i++){
	    str += data[i] + " , ";
	}
	return str + "]";
    }
  public static void remove(int[] data, int end){
     swap(data, 0, end - 1);
     pushDownMax(data, 0, end);
  }
}
