import java.util.*;
public class MyHeap{
  private String[] data;
  private boolean minOrMax;
  private int size;
  private int end;
  /*public static void main(String[] args){
    MyHeap test = new MyHeap(true);
    System.out.println(test.toString());
    System.out.println(test.size());
    System.out.println(test.data.length);
    test.add("A");
    test.add("B");
    test.add("C");
    test.add("D");
    test.add("E");
    test.add("F");
    test.add("G");
    test.add("H");
    test.add("I");
    test.add("J");
    test.add("K");
    test.add("L");
    test.add("M");
    test.add("N");
    test.add("O");
    //test.resize();
    System.out.println(test.toString());
    System.out.println(test.size());
    System.out.println(test.data.length);
    System.out.println(test.end);
    //test.remove();
    System.out.println(test.peek());
    System.out.println(test.size());
    System.out.println(test.data.length);
    System.out.println(test.end);*/
    public static void main(String[] args) {
   MyHeap a = new MyHeap(false);
   String[] b = new String[20];
   for(int i = 0; i < 20; i++){
     int temp = (int)(Math.random() * 26) + 97;
     char value = (char)temp;
     a.add("" + value);
     b[i] = "" + value;
   }

   Arrays.sort(b);

   System.out.println("MyHeap: " + a);
   System.out.println("Arrays: "+ Arrays.toString(b));
  }
  public MyHeap(){
    setBool(true);
    data = new String[10];
  }
  public MyHeap(boolean bool){
    setBool(bool);
    data = new String[10];
  }
  public void setBool(boolean bool){
    minOrMax = bool;
  }
  public int size(){
    return size;
  }
  public void add(String s){
   if(size() == data.length - 1){
     resize();
   }
    if(size() == 0){
      data[0] = s;
      end = 1;
    }
    else{
    data[size()] = s;
     if(minOrMax){
      pushUpMax(s, size() -1);
    }
     else{
       pushUpMin(s, size() - 1);
     }
   }
     size++;
     end++;
}
  public void pushUpMin(String s, int loc){
    int location = loc;
    if(location == 0){
      return;
    }
    else if(data[(location - 1)/ 2].compareTo(data[location]) > 0){
      swap(data, (location-1)/2, location);
      location = (location - 1) / 2;
      pushUpMin(s, location);
    }
  }
  public void pushUpMax(String s, int loc){
    int location = loc;
    if(location == 0){
      return;
    }
    else if(data[(location - 1)/ 2].compareTo(data[location]) < 0){
      swap(data, (location-1)/2, location);
      location = (location - 1) / 2;
      pushUpMax(s, location);
    }
  }
  public void remove(){
    swap(data, 0, end - 1);
    if(minOrMax){
      pushDownMax(0);
    }
    else{
      pushDownMin(0);
    }
  }
  public String peek(){
    return data[0];
  }
  public void pushDownMin(int loc){
    int location = loc;
    if(location + 1 == end || (2 * location) + 1 > size() - 1 || (2 * location) + 1 > size() - 1) {
      return;
    }
    int which;
    if(data[(2 * location) + 1].compareTo(data[2 * location]) < 0){
      which = (2 * location) + 1;
    }
      else{
       which = (2 * location) + 2;
      }
      swap(data, which, location);
      location = which;
      pushDownMin(location);
    }
  public void pushDownMax(int loc){
    int location = loc;
    if(location + 1 == end){
      return;
    }
    int which;
    if(data[(2 * location) + 1].compareTo(data[2 * location]) < 0){
      which = (2 * location) + 1;
    }
      else{
       which = (2 * location) + 2;
      }
      swap(data, which, location);
      location = which;
      pushDownMax(location);
    }
  public void resize(){
    String[] newData = new String[2 * size()];
    for(int c = 0; c < size(); c++){
      newData[c] = data[c];
    }
    data = newData;
  }
  public String toString(){
    String answer = new String("[");
    for(int i = 0; i < size(); i++){
      if(data[i] != null){
      answer+= data[i] + " ";
    }
  }
    return answer + "]";
  }
  public static void swap(String[] ary, int a, int b){
    String c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }
}
