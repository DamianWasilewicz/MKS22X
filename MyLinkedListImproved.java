public class MyLinkedListImproved<T>{
  public static void main(String[] args){
    LinkedList test = new MyLinkedListImproved<Integer>();
    Integer adder = 0;
    while(adder < 100){
      test.add(adder);
      adder+=1;
    }
   test.add(0, -5000);
    test.add(test.size() - 1, 1000000);
    test.add(5, 1000);
    System.out.println(test.getNode(0).toString());
    System.out.println(test.toString());
    Integer t = new Integer(-5000);
    test.remove(t);
    //System.out.println(test.toString());
    //test.remove(0);
    //System.out.println(test.toString());
    //test.remove(test.size() - 1);
    System.out.println(test.toString());
  }
  private Node start, end;
  private int size = 0;
  public MyLinkedListImproved(){
    }
  public String toString(){
	   String answer = new String ("[");
	    for(Node counter = this.start; counter != end; counter = counter.getNext()){
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
    while(data.getValue() != value){
      data = data.getNext();
      counter++;
    }
    return counter;
  }
  public <T> get(int index){
	   Node answer = getNode(index);
	    return answer.getValue();
    }
 public void set(int index, <T> next){
    getNode(index - 1).setNext(next);
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
  public void add(<T> value){
    if(size == 0){
      Node data = new Node(value);
      start = data;
      end = data;
      size = size + 1;
    }
    else{
    Node next = new Node(value);
    size = size + 1;
    end.setNext(next);
    end = next;
  }
  }
  public void add(int index, <T> value){
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    Node data = new Node(value);
    size = size + 1;
    if(index == 0){
      start.setPrev(data);
      data.setNext(start);
      start = data;
    }
    else if(index == size() - 1){
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
}
 public void remove(<T> value){
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
 }
 public void remove(int index){
   if(index < 0 || index >= size){
     throw new IndexOutOfBoundsException();
   }
   if(index == 0){
     start = start.getNext();
   }
   else if (index == size() -1){
     end = end.getPrev();
   }
   else{getNode(index - 1).setNext(getNode(index + 1));
   getNode(index + 1).setPrev(getNode(index - 1));
   size-=1;
 }
 }
  }
