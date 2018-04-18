import java.util.*;
public class Eval{
    public static void main(String[] args){
	System.out.println(Eval.eval("5 4 + 1000 * "));
	/*System.out.println(Eval.eval("5 4 - 10 * 2 -2 * 3 %"));
	System.out.println(Eval.eval("5 4 / 10 * 2 - 2 * 3 %"));
	System.out.println(Eval.eval("5 4 * 10 * 2 - 2 * 3 %"));
	System.out.println(Eval.eval("5 4 % 10 *2 - 2 * 3 %"));*/
    }
    public static String eval(String expression){
	LinkedList<String> data = new LinkedList<>();
	String temp = "";
	for(int c = 0; c < expression.length(); c++){
	    if(expression.charAt(c) == ' '){
		if(temp.equals('+')){
		double second = Double.parseDouble(data.pop());
		double first = Double.parseDouble(data.pop());
		data.add(second + first + "");
	    }
	        if(temp.equals('-')){
		double second = Double.parseDouble(data.pop());
		double first = Double.parseDouble(data.pop());
		data.add(second - first + "");
	    }
	        if(temp.equals('/')){
		double second = Double.parseDouble(data.pop());
		double first = Double.parseDouble(data.pop());
		data.add(second / first + "");
	    }
	        if(temp.equals ('*')){
		double second= Double.parseDouble(data.pop());
		double first  = Double.parseDouble(data.pop());
		data.add(second * first + "");
	    }
		else if(temp.equals('%')){
		double second= Double.parseDouble(data.pop());
		double first  = Double.parseDouble(data.pop());
		data.add(second % first + "");
		}
		
	    }
	    else{
		temp+= "" + expression.charAt(c);
		
	    else if(temp.length() > 0){
		data.add(temp);
		temp = "";
	    }
	}
	return data.getFirst();
    }
}
