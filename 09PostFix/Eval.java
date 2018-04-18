import java.util.*;
public class Eval{
    public static void main(String[] args){
	System.out.println(Eval.eval("5 4 +"));
    }
    public static String eval(String expression){
	LinkedList<String> data = new LinkedList<>();
	String temp = "";
	for(int c = 0; c < expression.length(); c++){
	  if(expression.charAt(c) == ' '){
		    if(temp.equals("+")){
		        double second = Double.parseDouble(data.pop());
		          double first = Double.parseDouble(data.pop());
		            data.add(second + first + "");
                System.out.println(data);
	             }
	      else if(temp.equals("-")){
		       double second = Double.parseDouble(data.pop());
		         double first = Double.parseDouble(data.pop());
		           data.add(second - first + "");
	            }
	      else if(temp.equals("/")){
		       double second = Double.parseDouble(data.pop());
		         double first = Double.parseDouble(data.pop());
		           data.add(second / first + "");
	            }
	      else if(temp.equals ("*")){
		        double second= Double.parseDouble(data.pop());
		          double first  = Double.parseDouble(data.pop());
		            data.add(second * first + "");
	             }
		   else if(temp.equals("%")){
		       double second= Double.parseDouble(data.pop());
		         double first  = Double.parseDouble(data.pop());
		           data.add(second % first + "");
		           }
               else{
                 data.add(temp);
               }
               temp = " ";
	            }
	  else{
      temp += expression.charAt(c) + "";
    }
	    }
	return data.getFirst();
    }
}
