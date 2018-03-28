public class Node{
    Integer data;
    Node next = null;
    Node prev = null;
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
