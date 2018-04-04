public class Node{
  public static void main(String[] args){
    Node test = new Node();
    test.setValue(1);
    Node n = new Node();
    n.setValue(2);
    Node p = new Node(0);
    test.setNext(n);
    test.setPrev(p);
    System.out.println(test.getValue());
    System.out.println(test.getNext().toString());
    System.out.println(test.getPrev().toString());
  }
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
