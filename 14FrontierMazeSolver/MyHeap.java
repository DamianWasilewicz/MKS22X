import java.util.* ;
public class MyHeap<T extends Comparable<T>>{
  private T[] data;
  private boolean minOrMax;
  private int size;
  public static void main(String[] args) {
     MyHeap<String> a = new MyHeap<>(false);
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

     boolean isCorrect = true;
     for(int i = 0; i < 20; i++){
       //System.out.println("size: " + a.size());
       //System.out.println("heap before: " + a.toT());
       String temp = a.remove();
       if(!(temp.equals(b[i]))){
         System.out.println("there is an error");
         System.out.println(temp);
         System.out.println(b[i]);
         System.out.println(a);
         isCorrect = false;
       }
     }

     if(isCorrect){
       System.out.println("Your heap is correct!");
     }
     else{
       System.out.println("There are error(s)");
     }
   }
   @SuppressWarnings("unchecked")
  public MyHeap(){
    setBool(true);
    data = (T[]) new Comparable[10];
  }
   @SuppressWarnings("unchecked")
  public MyHeap(boolean bool){
    setBool(bool);
    data = (T[]) new Comparable[10];
  }
  public void setBool(boolean bool){
    minOrMax = bool;
  }
  public int size(){
    return size;
  }
  public void add(T s){
   if(size() == data.length - 1){
     resize();
   }
    if(size() == 0){
      data[0] = s;
    }
    else{
    data[size()] = s;
     if(minOrMax){
      pushUpMax(s, size());
    }
     else{
       pushUpMin(s, size());
     }
   }
     size++;
}
public void pushUpMin(T s, int loc){
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
  public void pushUpMax(T s, int loc){
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
  /*public String remove(){
  String answer = peek();
   swap(data, 0, size - 1);
   size--;
   if(minOrMax){
     pushDownMax(0);
   }
   else{
     pushDownMin(0);
   }
   return answer;
 }*/
 public T remove(){
   T answer = peek();
  swap(data, 0, size - 1);
  size--;
  if(minOrMax){
    pushDownMax(0);
  }
  else{
    pushDownMin(0);
  }
  return answer;
}
    public void pushDownMax(int index){
 int c = index*2;
 if (c + 1 < size()&& data[index].compareTo(data[c+1]) < 0 && (c+2 >= size() || data[c+2].compareTo(data[c+1]) <= 0))
  {
     swap(data, index, c+1);
     pushDownMax(c+1);
 }

 else if (c+2 < size() && data[index].compareTo(data[c+2]) < 0 && (c+1 >= size() || data[c+1].compareTo(data[c+2]) <= 0))
 {
     swap(data,index, c+2);
     pushDownMax(c+2);
 }
   }
   public void pushDownMin(int index){
int c = index*2;
if (c + 1 < size()&& data[index].compareTo(data[c+1]) > 0 && (c+2 >= size() || data[c+2].compareTo(data[c+1]) >= 0)
    ){
    swap(data, index, c+1);
    pushDownMin(c+1);
}

else if (c+2 < size()&& data[index].compareTo(data[c+2]) > 0 && (c+1 >= size() || data[c+1].compareTo(data[c+2]) >= 0)
   ){
    swap(data,index, c+2);
    pushDownMin(c+2);
}
  }

 public T peek(){
   return data[0];
 }
 /*public void pushDownMax(int loc){
   int l = 2 * loc;
   if(l + 1 < size() && data[loc].compareTo(data[l + 1]) < 0 &&
   (l + 2 >= size() || data[l+2].compareTo(data[l + 1]) <= 0)) {
     swap(data, l + 1, loc);
     pushDownMax(l + 1);
   }
   else if(l+ 2 < size() && data[loc].compareTo(data[l + 2]) < 0 &&
   (l + 1 >= size() || data[loc+1].compareTo(data[loc + 2]) <= 0)){
     swap(data, l + 2, loc);
     pushDownMax(l + 2);
   }
 }
 public void pushDownMin(int loc){
   int l = 2 * loc;
   if(l + 1 < size() && data[loc].compareTo(data[l + 1]) > 0 &&
   (l + 2 >= size() || data[l+2].compareTo(data[l + 1]) >= 0)) {
     swap(data, l + 1, loc);
     pushDownMax(l + 1);
   }
   else if(l+ 2 < size() && data[loc].compareTo(data[l + 2]) > 0 &&
   (l + 1 >= size() || data[loc+1].compareTo(data[loc + 2]) >= 0)) {
     swap(data, l + 2, loc);
     pushDownMax(l + 2);
   }
 }*/
  @SuppressWarnings("unchecked")
  public void resize(){
    T[] newData = (T[]) new Comparable[2 * size()];
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
  public void swap(T[] ary, int a, int b){
    T c = ary[a];
    ary[a] = ary[b];
    ary[b] = c;
  }
}
