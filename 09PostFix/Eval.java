import java.util.*;
public class Eval{
    public static void main(String[] args){
	System.out.println(Eval.eval("5 4 + "));
    }
    public static String eval(String expression){
	LinkedList<String> data = new LinkedList<>();
	String temp = "";
	for(int c = 0; c < expression.length(); c++){
	  if(expression.charAt(c) == ' '){
		   if(temp.equals("+") || temp.equals("-") || temp.equals("/") || temp.equals("%") || temp.equals("*")){
         double second = Double.parseDouble(data.pop());
         double first = Double.parseDouble(data.pop());
         data.add(evaluate(temp, first, second));
       }
          else{
                 data.add(temp);
               }
               temp = " ";
	            }
	  else{
      temp += expression.charAt(c);
    }
	    }
      if(temp.equals("+") || temp.equals("-") || temp.equals("/") || temp.equals("%") || temp.equals("*")){
              double second = Double.parseDouble(data.pop());
              double first = Double.parseDouble(data.pop());
              data.add(evaluate(temp, first, second));
            }
	return data.getFirst();
    }
    public static String evaluate(String op, double first, double second){
      if(op.equals("+")){
        return (first + second) + "";
      }
      else if(op.equals("-")){
        return (first - second) + "";
      }
      else if(op.equals("*")){
        return (first * second) + "";
      }
      else if(op.equals("/")){
        return (first / second) + "";
      }
      else{
        return (first % second) + "";
      }
    }
}
