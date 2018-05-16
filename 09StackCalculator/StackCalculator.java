import java.util.*;
public class StackCalculator{
  public static void main(String[] args) {
System.out.println(eval("5 1 -"));
}
    public static String eval(String expression){
	Stack<String> data = new Stack<>();
	String temp = "";
	for(int c = 0; c < expression.length(); c++){
	  if(expression.charAt(c) == ' '){
		   if(temp.equals("+") || temp.equals("-") || temp.equals("/") || temp.equals("%") || temp.equals("*")){
         double first = Double.parseDouble(data.pop());
         double second = Double.parseDouble(data.pop());
         data.push(evaluate(temp, first, second));
       }
          else{
                 data.push(temp);
               }
               temp = "";
	            }
	  else{
      temp += expression.charAt(c);
    }
	    }
      double first = Double.parseDouble(data.pop());
      double second = Double.parseDouble(data.pop());
      return evaluate(temp, first, second);
    }
    public static String evaluate(String op, double first, double second){
      if(op.equals("+")){
        return (second + first) + "";
      }
      else if(op.equals("-")){
        return (second - first) + "";
      }
      else if(op.equals("*")){
        return (second * first) + "";
      }
      else if(op.equals("/")){
        return (second / first) + "";
      }
      else{
        return (second % first) + "";
      }
    }
}
