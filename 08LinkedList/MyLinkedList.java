public class MyLinkedList{
  public static void main(String[] args){
    MyLinkedList a = new MyLinkedList();

    System.out.println("Testing add(Integer value)");
    for (int i = 0; i < 10; i++){
      a.add(new Integer(i));
      System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
    } //adds the integers from 0 to 9 inclusive and prints out the LinkedList

    System.out.println("\nTesting get(int index)");
    for (int i = 0; i < 10; i++){
      System.out.println("index: " + i + " data: " + a.get(i));
    } //prints the integers from 0 to 9 inclusive

    System.out.println("\nTesting exception for get(int index)");
    try{
      System.out.println(a.get(10));
      System.out.println(a.size());
    }catch(IndexOutOfBoundsException e){
      System.out.println("This size is out of bounds");
    } //prints "This size is out of bounds"
    try{
      System.out.println(a.get(-1));
    }catch(IndexOutOfBoundsException e){
      System.out.println("This size is out of bounds");
    } //prints "This size is out of bounds"

    for (int i = 0; i < 10; i++){
      a.add(new Integer(i));
    }

    System.out.println("\nTesting indexOf(Integer value)");
    for (int i = 0; i < 10; i++){
      System.out.println("Value: " + i + " Index: " + a.indexOf(i));
    } //prints 0 to 9 inclusive

    System.out.println("\nTesting remove(Integer value)");
    for(int i = 0; i < 10; i++){
      a.remove(new Integer(i));
      System.out.println(a);
    } //removes first half of the LinkedList

    System.out.println("\nTesting set(int index, Integer value)");
    for (int i = 0; i < 10; i++){
      a.set(i, new Integer(i * 10));
      System.out.println(a);
    } //sets the data of each node to 10 * index

    System.out.println("\nTesting exceptions for set(int index, Integer value)");
    try{
      System.out.println(a.set(-1, new Integer(1)));
    }catch(IndexOutOfBoundsException e){
      System.out.println("This size is out of bounds");
    } //prints "This size is out of bounds"
    try{
      System.out.println(a.set(10, new Integer(1)));
    }catch(IndexOutOfBoundsException e){
      System.out.println("This size is out of bounds");
    } //prints "This size is out of bounds"

    System.out.println("\nTesing add(int index, Integer value)");
    for (int i = 0; i < 9; i++){
      a.add(i, new Integer(i * 3));
      System.out.println("index added: " + i + " LinkedList: " + a.toString());
    } //adds multiples of 3 up to 24 to the LinkedList at the beginning
    a.add(18, new Integer(100)); //adds 100 to the LinkedList at the end
    System.out.println("index added: " + 18 + " LinkedList: " + a.toString());

    System.out.println("\nTesting exceptions for add(int index, Integer value)");
    try{
      a.add(-1, new Integer(5));
    }catch(IndexOutOfBoundsException e){
      System.out.println("This size is out of bounds");
    } //prints "This size is out of bounds"
    try{
      a.add(21, new Integer(5));
    }catch(IndexOutOfBoundsException e){
      System.out.println("This size is out of bounds");
    } //prints "This size is out of bounds"

    System.out.println("\nTesting remove(int index)");
    System.out.println("Original LinkedList: " + a.toString());
    System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
    System.out.println("LinkedList: " + a.toString());
    System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
    System.out.println("LinkedList: " + a.toString());
    System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
    System.out.println("LinkedList: " + a.toString());

    System.out.println("\nTesting exceptions for remove(int index)");
    try{
      System.out.println(a.remove(-1));
    }catch(IndexOutOfBoundsException e){
      System.out.println("This size is out of bounds");
    } //prints "This size is out of bounds"
    try{
      System.out.println(a.remove(17));
    }catch(IndexOutOfBoundsException e){
      System.out.println("This size is out of bounds");
    } //prints "This size is out of bounds"

    System.out.println("\nTesting clear()");
    a.clear();
    System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
  }
  private Node start, end;
  private int size = 0;
  public MyLinkedList(){
    }
  private class Node{
        Integer data;
        Node next = null;
        Node prev = null;
        public Node(){
        }
        public Node(Integer value){
    	data = value;
        }
        public Node getNext(){
    	return next;
        }
        public Node getPrev(){
    	return prev;
        }
        public Integer getValue(){
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
        public void setValue(Integer data){
    	this.data = data;
        }
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
  public int indexOf(Integer value){
    Node data = start;
    int counter = 0;
    while(!data.getValue().equals(value)){
      data = data.getNext();
      counter++;
    }
    return counter;
  }
  public Integer get(int index){
	   Node answer = getNode(index);
	    return answer.getValue();
    }
 public Integer set(int index, Integer value){
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
  public void add(Integer value){
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
  public void add(int index, Integer value){
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
    else if (index != 0 && index != size() - 1){
      Node p = getNode(index - 1);
      Node n = getNode(index);
      data.setNext(n);
      data.setPrev(p);
      p.setNext(data);
      n.setPrev(data);
    }
    size+=1;
}
 public boolean remove(Integer value){
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
     remove(counter);
   }
  else if(counter != 0 && counter != size() - 1){
    getNode(counter - 1).setNext(getNode(counter + 1));
  getNode(counter + 1).setPrev(getNode(counter - 1));
 }
 size-=1;
 return true;
 }
 public Integer remove(int index){
   if(index < 0 || index >= size){
     throw new IndexOutOfBoundsException();
   }
   Node answer;
   if(index == 0){
     answer = start;
     start = start.getNext();
   }
   else if (index == size() - 1){
     answer = end;
     end = end.getPrev();
     end.setNext(null);
   }
   else{
     answer = getNode(index);
   getNode(index - 1).setNext(getNode(index + 1));
   getNode(index + 1).setPrev(getNode(index - 1));
 }
   size-=1;
   return answer.getValue();
 }
 }
