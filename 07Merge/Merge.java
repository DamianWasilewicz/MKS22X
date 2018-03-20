public class Merge{
  public static void main(String[] args){
      int[] test = {44, 51, 24, 65, 12, 49, 72, 66, 34, 18, 78 , 29, 79, 56 ,34 ,56, 65};
      Merge.mergesort(test);
      System.out.println(Merge.toString(test));
  }
  public static void mergesort(int[] data){
      int[] temp = new int[data.length];
      msort(data, temp, 0, data.length - 1);
  }
  public static void msort(int[] data, int[] temp, int startP, int endP){
      if(startP >= endP){
	  return;
      }
      for(int counter = startP; counter <= endP; counter++){
	  temp[counter] = data[counter];
      }
      int mid = (startP + endP) / 2;
      msort(temp, data, startP, mid);
      msort(temp, data, mid + 1, endP);
      Merge(data, temp, startP, mid, mid + 1, endP);
  }
	
	
    public static void Merge(int[] data1, int[] data2, int sP, int m, int m1, int eP){
    int[] newData = new int[data1.length + data2.length];
    int tracker1 = sP;
    int tracker2 = m1;
    while(tracker1 < m && tracker2 < eP){
      int sum = tracker1 + tracker2;
      if(data1[tracker1] < data2[tracker2]){
        newData[sum] = data1[tracker1];
        tracker1++;
      }
      else{
        newData[sum] = data2[tracker2];
        tracker2++;
      }
    }
    if(tracker2 == m){
      for(int counter = tracker1; counter < data1.length; counter++){
        newData[counter + tracker2] = data1[counter];
      }
    }
    if(tracker1 == eP){
      for(int counter = tracker2; counter < data2.length; counter++){
        newData[counter + tracker1] = data2[counter];
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
