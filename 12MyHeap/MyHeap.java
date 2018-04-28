public class MyHeap{
  private String[] data;
  private boolean minOrMax;
  private int size;
  public static void main(String[] args){
    MyHeap test = new MyHeap();
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

    //test.resize();
    System.out.println(test.toString());
    System.out.println(test.size());
    System.out.println(test.data.length);
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
   if(size() == data.length){
     resize();
   }
    if(size() == 0){
      data[0] = s;
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
     size+=1;
}
  public void pushUpMin(String s, int loc){
    int location = loc;
    if(location == 0){
      return;
    }
    else if(data[(location - 1)/ 2].compareTo(data[location]) < 0){
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
    else if(data[(location - 1)/ 2].compareTo(data[location]) > 0){
      swap(data, (location-1)/2, location);
      location = (location - 1) / 2;
      pushUpMax(s, location);
    }
  }
  public void resize(){
    String[] newData = new String[2 * size()];
    for(int c = 0; c < size(); c++){
      newData[c] = data[c];
    }
    data = newData;
    size = 2 * size;
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
