import java.util.Random;
public class Quick{
  /*public static void main(String[] args){
    int[] test = new int[] {300, 20, 1, 4000, 50000, 8000000, 700000, 60000, 90000000};
    System.out.println(Quick.quickselect(test, 7));
    System.out.println(Quick.partition(test, 0, 8));
  System.out.println(toString(test));
}*/
public static void main(String[] args){
	try{
	    int[] test = new int[Integer.parseInt(args[0])];
	    for(int i =0; i < test.length; i++){
		Random seed= new Random();
		int num=seed.nextInt((Integer.parseInt(args[1])));
		if(seed.nextBoolean()){
		    num*=-1;
		}
		test[i]=num;

	    }
	    System.out.println("Before:"+"\n"+toString(test));
	    System.out.println(partition(test, 0, test.length-1));
	    System.out.println("After:"+"\n"+toString(test));
	}
	catch(Exception IndexOutOfBounds){
	    System.out.println("After the file name insert the size of the array and the bounds for the numbers in the array"+"\n"+"EX: FileName 10 200"+"\n"+"Would give an array of size 10 with numbers ranging from -200 to 200");
	}

    }
public static int partitionNonDutchSail(int[] data, int start, int end){
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
    System.out.println("" + start + "," + end + "  ");
    return greaterThan;
    }
  public static int partition(int[] data, int start, int end){
    if(data.length < 2){
      return start;
    }
     Random rand = new Random();
     int pivotIndex = (int) (Math.random() * (end-start)) + start;
     int pivotElement = data[pivotIndex];
     swap(data, start, pivotIndex);
     int lessThan = start + 1;
     int greaterThan = end;
     while(lessThan <= greaterThan){
      if(data[lessThan] < pivotElement){
         lessThan++;
       }
       else if(pivotIndex <= end && data[lessThan] == pivotElement){
        swap(data, lessThan, pivotIndex);
        pivotIndex++;
       }
       else{
         swap(data, greaterThan, lessThan);
           greaterThan--;
         }
     }
     swap(data,greaterThan, start);
     return greaterThan;
     }
    public static void swap(int[] ary, int a, int b){
  int c = ary[a];
  ary[a] = ary[b];
  ary[b] = c;
}


 public static int quickselect(int[] data, int k){
   int counter = data.length;
    while(counter != k){
     if(counter > k){
       counter = partition(data, 0, counter - 1);
    }
    else{
      counter = partition(data, counter + 1, data.length - 1);
    }
 }
 return data[k];
 }
public static void quicksort(int[] data){
  quicksortH(data, 0, data.length - 1);
}
public static void quicksortH(int[] data, int start, int end){
  if(start < end){
    int startingPoint = partition(data, start, end);
    quicksortH(data, start, startingPoint - 1);
    quicksortH(data, startingPoint + 1, end);
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
