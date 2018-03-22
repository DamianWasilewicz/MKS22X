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
      if(startP < endP){
   for(int counter = startP; counter <= endP; counter++){
	  temp[counter] = data[counter];
  }
      int mid = (startP + endP) / 2;
      msort(temp, data, startP, mid);
      msort(temp, data, mid + 1, endP);
      merge(data, temp, startP, mid, mid + 1, endP);
  }
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
  }


  public static String toString(int[] data){
    String answer = new String (" ");
    for(int counter = 0; counter < data.length; counter++){
      answer+= " " + data[counter];
    }
    return answer;
  }
}
