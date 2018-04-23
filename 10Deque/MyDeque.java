import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int start;
    private int end;
    private int size = 0;
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
	size = 0;
        start = 5;
	end = 5;
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	data = (E[])new Object[initialCapacity];
	size = 0;
	start = initialCapacity/2;
	end = initialCapacity/2;
    }
    public String toString(){
    String ans = "[";
    if(start < end){
      for (int i = start; i <= end; i++){
        ans += data[i] + " , ";
      }
    }
    else{
      for(int i = start; i < data.length; i++){
        ans += data[i] + ", ";
      }
      for(int i = 0; i <= end; i++){
        ans += data[i] + ", ";
      }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }

  public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
  }
    public int size(){
	return size;
    }
    public void addFirst(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == data.length ||
	   start - 1 == end
	   //(start == 0 && end == data.length - 1)
     ){
	    resize();
	}
  if(start == 0){
    if(data[start] == null){
      data[start] = element;
    }
    else{
    data[data.length - 1] = element;
    start = data.length - 1;
  }
}
else{
	data[start - 1] = element;
	start--;
    }
    size+= 1;
  }
    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size() == data.length ||
	   start - 1 == end 
	   //(start == 0 && end == data.length - 1)
     ) {
	    resize();
	}
  /*if(end == data.length-1){
    data[0] = element;
    end = 0;
  }*/
	data[end + 1] = element;
	end++;
  size+= 1;
    }
    @SuppressWarnings("unchecked")
    private void resize(){
      E[] t = (E[]) new Object[2 * data.length];
      for(int counter = 0; counter < data.length; counter++){
        t[counter] = data[counter];
      }
      data = t;
      start = 0;
      end = size() - 1;
    }
    public E getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }
    public E getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }
    public E removeFirst(){
      if(size() == 0){
        throw new NoSuchElementException();
      }
      E answer = data[start];
      if(start == size() - 1){
        start = 0;
      }
      else{
        start+=1;
      }
      size-=1;
      return answer;
      }
      public E removeLast(){
        if(size() == 0){
          throw new NoSuchElementException();
        }
        E answer = data[end];
        if(end == 0){
          end = data.length - 1;
        }
        else{
          end = end - 1;
        }
        size-=1;
        return answer;
        }
    }
