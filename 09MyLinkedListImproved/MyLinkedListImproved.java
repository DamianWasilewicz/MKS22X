public class MyLinkedListImproved <T>{
  private Node start, end;
  private int size = 0;
  public MyLinkedListImproved(){
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
  public void add(int index, T value){
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
     remove(counter);
   }
  else if(counter != 0 && counter != size() - 1){
    getNode(counter - 1).setNext(getNode(counter + 1));
  getNode(counter + 1).setPrev(getNode(counter - 1));
 }
 size-=1;
 return true;
 }
 public T remove(int index){
   if(index < 0 || index >= size){
     throw new IndexOutOfBoundsException();
   }
   Node answer;
   if(index == 0){
     answer = start;
     start = start.getNext();
   }
   else if (index == size() -1){
     answer = end;
     end = answer.getPrev();
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
