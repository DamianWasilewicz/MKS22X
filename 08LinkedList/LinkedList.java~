public class MyLinkedList{
    private Node start, end;
    private int size;
    public MyLinkedList(){
    }
    public String toString(){
	String answer = String ("[");
	for(int counter = this.start; counter <= end; counter++){
	    Node data = getNode(counter);
	    answer+= data.getValue() + " ";
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
    public Integer get(int index){
    private Node getNode(int index){
	if(index > length || index < 0){
	    throw new IndexOutOfBoundsException() e;
	}
	Node counter = this.start;
	while(index > 0){
	    counter = counter.getNext();
	    index--;
	}
	return counter;
    }
