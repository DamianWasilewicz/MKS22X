import java.util.*;
public class MyLinkedListImproved <T extends Comparable<T>> implements Iterable<T>{
    public static void main(String[] args){
	MyLinkedListImproved<Integer> test = new MyLinkedListImproved<>();
	for(int i = 0; i < 10; i++  ){
	    Integer data = i * 10;
	    test.add(i,data);
	}
  test.add(4, 5000);
	for(Integer i : test){
	    System.out.println(i + " ");
	}
  System.out.println(test.max());
MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
  for(int i = 0; i < 10; i++  ){
	    Integer d = i * 100;
	    data.add(i,d);
	}
  test.extend(data);
  System.out.println(test.toString());
    }
    private Node start, end;
    private int size = 0;
    public MyLinkedListImproved(){
    }
    public class MyLLIterator implements Iterator<T>{
	private Node next;
	public MyLLIterator(MyLinkedListImproved<T> list){
	    next = start;
	}
	public T next(){
	    Node data = next;
	    next = next.getNext();
	    return data.getValue();
	}
	public boolean hasNext(){
	    return next != null;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    private class Node{
	T data;
	Node next = null;
	Node prev = null;
	public Node(){
	}
	public Node(T value){
	    data = value;
	}
	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return prev;
	}
	public T getValue(){
	    return data;
	}
	public String toString(){
	    String answer = new String("");
	    answer += this.getValue();
	    return answer;
	}
	public void setNext(Node next){
	    this.next = next;
	}
	public void setPrev(Node prev){
	    this.prev = prev;
	}
	public void setValue(T data){
	    this.data = data;
	}
}
 public void extend(MyLinkedListImproved<T> other){
     end.setNext(other.getStart());
     end = other.getEnd();
     other.setStart(null);
     other.setEnd(null);
   }
    public String toString(){
	String answer = new String ("[");
	for(Node counter = this.start; counter != null; counter = counter.getNext()){
 	    answer+= counter.getValue() + " ";
	}
	return answer+= "]";
    }
    public void clear(){
	start = null;
	end = null;
	size = 0;
    }
    public int size(){
	return this.size;
    }
    public void setStart(Node s){
      start = s;
    }
    public Node getStart(){
      return start;
    }
    public void setEnd(Node e){
      end = e;
    }
    public Node getEnd(){
      return end;
    }
    public int indexOf(T value){
	Node data = start;
	int counter = 0;
	while(!data.getValue().equals(value)){
	    data = data.getNext();
	    counter++;
	}
	return counter;
    }
    public T get(int index){
	Node answer = getNode(index);
	return answer.getValue();
    }
    public T set(int index, T value){
	getNode(index).setValue(value);
	return value;
    }
    private Node getNode(int index){
	if(index >= size || index < 0){
 	    throw new IndexOutOfBoundsException();
	}
	Node counter = this.start;
	while(index > 0){
 	    counter = counter.getNext();
 	    index--;
	}
	return counter;
    }
    public void add(T value){
	if(size == 0){
	    size+= 1;
	    Node data = new Node(value);
	    start = data;
	    end = data;
	}
	else{
	    Node next = new Node(value);
	    size = size + 1;
	    end.setNext(next);
	    next.setPrev(end);
	    end = next;
	}
    }
    public Iterator<T>iterator(){
	return new MyLLIterator(this);
    }
    public void add(int index, T value){
	Node data = new Node(value);
	if(size == 0 && index == 0){
	    start = data;
	    end = data;
	}
	if(index > size || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    start.setPrev(data);
	    data.setNext(start);
	    start = data;
	}
	else if(index == size()){
	    end.setNext(data);
	    data.setPrev(end);
	    end = data;
	}
	else if (index != 0 && index != size()){
	    Node p = getNode(index - 1);
	    Node n = getNode(index);
	    data.setNext(n);
	    data.setPrev(p);
	    p.setNext(data);
	    n.setPrev(data);
	}
	size+=1;
    }
    public boolean remove(T value){
	Node data = start;
	int counter = 0;
	while(!(data.getValue().equals(value))) {
	    data = data.getNext();
	    counter++;
	}
	if(counter == 0){
	    start = start.getNext();
	}
	else if(counter == size() - 1){
	    Node p = getNode(counter - 1);
	    p.setNext(null);
	    end = p;
	}
	else if(counter != 0 && counter != size() - 1){
	    Node n = getNode(counter + 1);
	    Node p = getNode(counter - 1);
	    p.setNext(n);
	    n.setPrev(p);
	}
	size-=1;
	return true;
    }
 public int max(){
	Node current = start;
  Node max = current;
   while(current != null){
	    if(current.getValue().compareTo(max.getValue()) > 0) {
        max = current;
      }
        current = current.getNext();
      }
return indexOf(max.getValue());
}
public int min(){
 Node current = start;
 Node min = current;
  while(current != null){
     if(current.getValue().compareTo(min.getValue()) < 0) {
       min = current;
     }
      current = current.getNext();}
return indexOf(min.getValue());
}
public T remove(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Node answer = null;
	if(index == 0){
	    answer = start;
	    start = start.getNext();
	    start.setPrev(null);
	    size-=1;
	}
	else if(index == size() - 1){
	    answer = end;
	    end = end.getPrev();
	    end.setNext(null);
	    size-=1;
	}
	else if(index != 0 && index!= size() - 1){
	    answer = getNode(index);
	    Node n = getNode(index + 1);
	    Node p = getNode(index - 1);
	    p.setNext(n);
	    n.setPrev(p);
	    size-=1;
	}
	return answer.getValue();
    }
}
