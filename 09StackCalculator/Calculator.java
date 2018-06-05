import java.util.*;
public class Calculator{
  public static void main(String[] args) {
    System.out.println(eval("6 6 +"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("6 "));
    System.out.println(eval("-6 "));
    System.out.println(eval("-6"));
    System.out.println(eval("6"));
}
    public static double eval(String expression){
	Stack<String> data = new Stack<>();
	String temp = "";
  int spaces = 0;
  for(int counter = 0; counter < expression.length(); counter++){
    if(expression.charAt(counter) == ' '){
      spaces++;
    }
  }
  if(spaces == 0 || spaces == 1){
    return Double.parseDouble(expression);
  }
  else{
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
      return Double.parseDouble(evaluate(temp, first, second));
    }
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
