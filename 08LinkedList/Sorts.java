
import java.util.*;
 public class Sorts{
   public static void main(String[] args) {
    //-----------SORTING POSITIVES-----------
    System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
    MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
    int[] correctData = new int[10];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 10; i++){
      int temp = (int)(Math.random() * 1000);
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    long end,start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
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


    //-----------SORTING NEGATIVES-----------
    System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
    data.clear();
    correctData = new int[10];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 10; i++){
      int temp = (int)(Math.random() * 1000);
      temp *= -1;
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with all negative numbers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


  //-----------SORTING POSITIVES AND NEGATIVES-----------
    System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
    data.clear();
    correctData = new int[10];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 10; i++){
      int temp = (int)(Math.random() * 1000);
      if((int)(Math.random() * 1000) % 2 == 0){
        temp *= -1;
      }
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


   //-----------SORTING EMPTY LISTS-----------
    System.out.println("SORTING ON EMPTY LISTS");
    data.clear();
    correctData = new int[0];

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your empty LinkedList is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];

    int temp = (int)(Math.random() * 1000);
    data.add(temp);
    correctData[0] = temp;

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with one positive element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];

    temp = (int)(Math.random() * 1000) * -1;
    data.add(temp);
    correctData[0] = temp;

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with one negative element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
  }

   public static void radixsort(MyLinkedListImproved<Integer> data){
     MyLinkedListImproved<Integer> neg = new MyLinkedListImproved<>();
     MyLinkedListImproved<Integer> pos = new MyLinkedListImproved<>();
     for(Integer value : data){
       if(value >= 0){
         pos.add(value);
        // System.out.println(pos);
       }
       else{
         neg.add(value);
       }
     }
     if(pos.size() > 0){
     @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] data2 = new MyLinkedListImproved[10];
     for(int counter  = 0; counter < 10; counter++){
       data2[counter] = new MyLinkedListImproved<Integer>();
     }
   int m = pos.getMax();
   String length = m + "";
   int counter = length.length();
   int c1 = 0;
   while(c1 < counter){
     for(Integer c : pos){
       data2[(c / ((int)Math.pow(10, c1))) % 10].add(c);
     }
      pos.clear();
       for(int i = 0; i < 10; i ++){
       pos.extend(data2[i]);
     }
       for(int i = 0; i< 10; i++){
         data2[i] = new MyLinkedListImproved<Integer>();
       }
       c1++;
     }
   }
     if(neg.size() > 0){
     @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] data3 = new MyLinkedListImproved[10];
     for(int counter3  = 0; counter3 < 10; counter3++){
       data3[counter3] = new MyLinkedListImproved<Integer>();
     }
   int m1 = neg.getMin();
   String length1 = m1 + "";
   int counter1 = length1.length();
   int c2 = 0;
   while(c2 < counter1){
     for(Integer c : neg){
       data3[(Math.abs(c) / ((int)Math.pow(10, c2))) % 10].add(c);
     }
      neg.clear();
       for(int i = 9; i >= 0; i --){
       neg.extend(data3[i]);
     }
       for(int i = 0; i< 10; i++){
         data3[i] = new MyLinkedListImproved<Integer>();
       }
       c2++;
     }
   }
     data.clear();
     neg.extend(pos);
     data.extend(neg);
 }
 public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
    radixsort(data);
   }
 }
