import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int start;
    private int end;
    private int size = 0;
    public static void main(String[] args){
      MyDeque<Integer> test = new MyDeque<>();
      for(int c = 50; c > 0; c--){
        test.addFirst(c);
      }
      /*test.addFirst(10);
      test.addFirst(9);
      test.addFirst(8);
      test.addFirst(7);
      test.addFirst(6);
      test.addFirst(5);
      test.addFirst(4);
      test.addFirst(3);
      test.addFirst(2);
      test.addFirst(1);
      test.addFirst(0)*/
      //test.addFirst("1");*/
    //  System.out.println(test.end);
      System.out.println(test.size());
    //  System.out.println(test.len());
     System.out.println(test.toStringOrdered());
    }
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
    public int len(){
      return data.length;
    }
    public String toStringOrdered(){
      String ans = "[";
      if(start < end){
        for (int i = start; i <= end; i++){
          if(data[i] != null){
        ans += data[i] + " , ";
        }
      }
      }
      else{
        for(int i = start; i < data.length; i++){
            if(data[i] != null){
          ans += data[i] + ", ";
        }
      }
        for(int i = 0; i <= end; i++){
            if(data[i] != null){
          ans += data[i] + ", ";
        }
      }
      }
      ans = ans.substring(0, ans.length() - 2) + "]";
      return ans;
    }
    public String toString(){
      String ans = "[";
      for(E counter : data){
        if(counter != null){
        ans+= counter + " ";
      }
    }
      return ans + "]";
    }
    @SuppressWarnings("unchecked")
    private void resize(){
      E[] temp = (E[]) new Object[2 * data.length];
      int old = start;
      int neww = 0;
      while(old != end){
        temp[neww] = data[old];
        old = (old + 1) % data.length;
        neww++;
      }
      temp[neww] = data[end];
      data = temp;
      start = 0;
      end = neww;
    }
    public void addFirst(E element){
	     if(element == null){
	        throw new NullPointerException();
	       }
	     if(size == data.length -1 || start - 1 == end){
	          resize();
	         }
      if(start == 0){
          if(data[data.length - 1] == null){
            data[data.length - 1] = element;
            start = data.length - 1;
          }
          else{
            resize();
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
      if(size == data.length || start - 1 == end) {
  	         resize();
  	     }
      if(size == 0){
        data[end] = element;
      }
      else if(end == data.length - 1){
         if(data[0] == null){
           data[0] = element;
           end = 0;
         }
         else{
           resize();
           data[end + 1] = element;
           end++;
         }
       }
       else{
         data[end + 1] = element;
	        end++;
        }
        size+= 1;
    }
    public int size(){
      return size;
    }
    /*
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
      if(size == 0){
        throw new NoSuchElementException();
      }
      E answer = data[start];
      if(start == size - 1){
        start = 0;
      }
      else{
        start+=1;
      }
      size-=1;
      return answer;
      }
      public E removeLast(){
        if(size == 0){
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
      }*/
    }
