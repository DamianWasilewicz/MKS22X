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
    public int size(){
	return size;
    }
    public void addFirst(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == data.length ||
	   start - 1 == end ||
	   (start == 0 && end == data.length - 1) ) {
	    resize();
	}
	data[start - 1] = element;
	start--;
    }
    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == data.length ||
	   start - 1 == end ||
	   (start == 0 && end == data.length - 1) ) {
	    resize();
	}
	data[end + 1] = element;
	end++;
    }
    public void resize(){
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
}
    
	
	
