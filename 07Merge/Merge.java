public class Merge{
  public static void main(String[] args){
    int[] d1 = new int[] {1, 3, 5, 7, 9, 11};
    int[] d2 = new int[] {2, 4, 5, 8, 10, 12};
    System.out.println(Merge.toString(Merge.Merge(d1, d2)));
  }
  public static int[] Merge(int[] data1, int[] data2){
    int[] newData = new int[data1.length + data2.length];
    int tracker1 = 0;
    int tracker2 = 0;
    while(tracker1 < data1.length && tracker2 < data2.length){
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
    if(tracker2 == data2.length){
      for(int counter = tracker1; counter < data1.length; counter++){
        newData[counter + tracker2] = data1[counter];
      }
    }
    if(tracker1 == data1 .length){
      for(int counter = tracker2; counter < data2.length; counter++){
        newData[counter + tracker1] = data2[counter];
      }
    }
    return newData;
  }
  public static String toString(int[] data){
    String answer = new String (" ");
    for(int counter = 0; counter < data.length; counter++){
      answer+= " " + data[counter];
    }
    return answer;
  }
}
