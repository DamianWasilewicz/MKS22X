public class Merge{
  public static void main(String[] args){
      int[] test = {1, 300, 20, 50000, 7000000, 4000, 600000, 900000000};
      Merge.mergesort(test);
      System.out.println(Merge.toString(test));
  }

  public static void mergesort(int[] data){
      int[] temporary = new int[data.length];
      msort(data, temporary, 0, data.length - 1);
  }
  public static void msort(int[] data, int[] temp, int startP, int endP){
    /*  if(startP < endP){
   for(int counter = startP; counter <= endP; counter++){
	  temp[counter] = data[counter];
  }*/
  if(endP - startP <= 10){
	  insertionSort(data, startP, endP);
  }
  for(int counter = startP; counter <= endP; counter++){
    temp[counter] = data[counter];
  }
      int mid = (startP + endP) / 2;
      msort(temp, data, startP, mid);
      msort(temp, data, mid + 1, endP);
      merge(data, temp, startP, mid, mid + 1, endP);
  }
    public static void merge(int[] data1, int[] data2, int sP, int m, int m1, int eP){
    int tracker1 = sP;
    int tracker2 = m1;
    for(int counter = tracker1; counter <= eP; counter++){
      if(tracker1 <= m && tracker2 > eP) {
          data1[counter] = data2[tracker1];
          tracker1++;
        }
        else if(tracker1 <= m && data2[tracker1] < data2[tracker2]){
          data1[counter] = data2[tracker1];
          tracker1++;
        }
    /* else if(tracker2 == eP){
          data1[counter] = data2[tracker1];
          tracker1++;
        }
      else if(data2[tracker1] < data2[tracker2]){
        data1[counter] = data2[tracker1];
        tracker1++;
      }*/
    else {
    //(data2[tracker1] >= data2[tracker2]){
        data1[counter] = data2[tracker2];
        tracker2++;
      }
    }
  }  public static void insertionSort(int[] data, int sP, int eP){
    int c;
      for(int counter = sP; counter <= eP; counter++){
        int c2 = data[counter];
        for(c = counter; c > sP && c2 < data[c - 1]; c--){
          data[c] = data[c - 1];
          }
          data[c] = c2;
         }
   }
   /*public static void insertionSort(int[] data, int sP, int eP){
       for(int counter = sP; counter <= eP; counter++){
         for(int counter1 = counter; counter1 > sP; counter1--){
           if(data[counter1] < data[counter1 -1]){
           swap(data, counter1 - 1, counter1);
           }
          }
       }
     }*/
 public static void swap(int[] ary, int a, int b){
  int c = ary[a];
  ary[a] = ary[b];
  ary[b] = c;
}

  public static String toString(int[] data){
    String answer = new String (" ");
    for(int counter = 0; counter < data.length; counter++){
      answer+= " " + data[counter];
    }
    return answer;
  }
}
