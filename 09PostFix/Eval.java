import java.util.*;
public class Eval{
  public static void main(String[] args){
    System.out.println(Eval.eval("5 5 + 10 / 10 + 10 %"));
  }
  public static String eval(String expression){
    LinkedList<String> data = new LinkedList<>();
    String temp = new String("");
    for(int c = 0; c < expression.length(); c++){
      System.out.println(data);
      if(expression.charAt(c) == '+'){
        double first = Double.parseDouble(data.pop());
        double second = Double.parseDouble(data.pop());
        data.add(second + first + "");
      }
      else if(expression.charAt(c) == '-'){
        double first = Double.parseDouble(data.pop());
        double second = Double.parseDouble(data.pop());
        data.add(second - first + "");
      }
      else if(expression.charAt(c) == '/'){
        double first = Double.parseDouble(data.pop());
        double second = Double.parseDouble(data.pop());
        data.add(second / first + "");
      }
      else if(expression.charAt(c) == '*'){
        double first = Double.parseDouble(data.pop());
        double second = Double.parseDouble(data.pop());
        data.add(second * first + "");
      }
      else if(expression.charAt(c) == '%'){
        double first = Double.parseDouble(data.pop());
        double second = Double.parseDouble(data.pop());
        data.add(second % first + "");
      }
      else if(expression.charAt(c) != ' '){
       temp+= expression.charAt(c);
      }
      else if(temp.length() > 0){
        data.add(temp);
        temp = "";
      }
    }
    return data.getFirst();
  }
}
