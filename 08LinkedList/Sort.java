import java.util.*;
public class Sort{
  public static void main (String[] args){
  //-----------SORTING POSITIVES-----------
      System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
      MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
      int[] correctData = new int[10];

      //Create MyLinkedListImproved and array with random integers
      for(int i = 0; i < 10; i++){
        int temp = (int)(Math.random() * 10000);
        data.add(temp);
        correctData[i] = temp;
      }
      System.out.println(data);

      //Sorts data and times the sort
      long end,start = System.currentTimeMillis();
      radixsort(data);
      System.out.println(data);
      end = System.currentTimeMillis();

      //Sorts the array
      Arrays.sort(correctData);
      System.out.println("CORRECT: "+Arrays.toString(correctData));
      System.out.println("Sort completed in " + (end - start) + " seconds");

      //Checks if data is properly sorted
      boolean hasError = false;
      int index = 0;
      for(Integer x: data){
        if(!(x.equals(correctData[index]))){
          System.out.println("THERE IS AN ERROR");
          System.out.println("Index of error: " + index);
          hasError = true;
        }
        index++;
      }

      if(!(hasError)){
        System.out.println("Your LinkedList with all positive integers is properly sorted.");
      }
      else{
        System.out.println(data);
      }
      System.out.println("\n");
}
public static void radixsort(MyLinkedListImproved<Integer> data){
  MyLinkedListImproved<Integer> neg = new MyLinkedListImproved<>();
  MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<>();
  MyLinkedListImproved<Integer> dataNeg = new MyLinkedListImproved<>();
  MyLinkedListImproved<Integer> dataPos = new MyLinkedListImproved<>();
  for(Integer value : data){
    if(value >= 0){
      pos.add(value);
    }
    else{
      neg.add(value);
    }
  }
  if(neg.size() > 0){
    dataNeg = radixsortHelper(neg, "-");
  }
    dataPos = radixsortHelper(pos, "+");
    dataNeg.extend(dataPos);
    data = dataNeg;
  }
  public static MyLinkedListImproved<Integer> radixsortHelper(MyLinkedListImproved<Integer> data, String sign){
    MyLinkedListImproved<Integer> data1 = data;
    @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] data2 = new MyLinkedListImproved[10];
    for(int counter  = 0; counter < 10; counter++){
      data2[counter] = new MyLinkedListImproved<Integer>();
    }
  int m = data.getMax();
  String length = m + "";
  int counter = length.length();
  int s = 10;
  while(counter >= 0){
    for(Integer c : data1){
      data2[(c % s) / (s/10)].add(c);
    }
    data1.clear();
    //if(sign.equals("+")){
      for(int i = 0; i < 10; i ++){
      data1.extend(data2[i]);
    }
    /*if(sign.equals("-")){
      for(int i = 9; i >= 0; i --){
      data1.extend(data2[i]);
    }
  }*/
      s = s * 10;
      counter--;
    }
    return data1;
  }
}
