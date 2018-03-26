import java.util.Random;
public class Quick{
  public static void main(String[] args){
    int[] test = new int[] {300, 20, 1, 4000, 50000, 8000000, 700000, 60000, 90000000};
    System.out.println(Quick.quickselect(test, 7));
    System.out.println(Quick.partition(test, 0, 8));
  System.out.println(toString(test));
}
/*public static void main(String[] args){
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
}*/
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

  public static int[] partition(int[] data, int start, int end){
     Random rand = new Random();
     int pivotIndex = (int) (Math.random() * (end-start + 1)) + start;
     int pivotElement = data[pivotIndex];
		 data[pivotIndex] = data[start];
     data[start] = pivotElement;
		 int counter = start + 1;
     int lessThan = start;
     int greaterThan = end;
     while(counter <= greaterThan){
      if(data[counter] > pivotElement){
				swap(data, counter, greaterThan);
         greaterThan--;
       }
       else if(data[counter] == pivotElement){
        counter++;
       }
       else{
         swap(data, counter, lessThan);
           lessThan++;
					 counter++;
         }
     }
     return new int[] {lessThan, greaterThan};
     }


    public static void swap(int[] ary, int a, int b){
  int c = ary[a];
  ary[a] = ary[b];
  ary[b] = c;
}


    public static int quickselect(int[] data, int k){
     int[] counterarray = partition(data, 0, data.length - 1);
		 int starting = 0;
		 int ending = data.length - 1;
    while(k < counterarray[0] || k > counterarray[1]){
     if(counterarray[0] > k){
       ending = counterarray[0];
    }
    else if(counterarray[1] < k){
      starting = counterarray[1];
    }
		counterarray = partition(data, starting, ending);
 }
 return data[k];
 }
public static void quicksort(int[] data){
  quicksortH(data, 0, data.length - 1);
}
public static void quicksortH(int[] data, int start, int end){
  if(end - start < 5){
    insertionSort(data, start, end);
  }
  if(start < end){
    int[] startingPoints = partition(data, start, end);
    quicksortH(data, start, startingPoints[0] - 1);
    quicksortH(data, startingPoints[1] + 1, end);
  }
  }
  public static void insertionSort(int[] data, int sP, int eP){
   int c;
     for(int counter = sP; counter <= eP; counter++){
       int c2 = data[counter];
       for(c = counter; c > sP && c2 < data[c - 1]; c--){
         data[c] = data[c - 1];
         }
         data[c] = c2;
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
