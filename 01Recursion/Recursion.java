public class Recursion{
  //function takes in n and calls helper function with n and starting factorial;
  public int fact(int n){
    if(n < 0){
      throw new IllegalArgumentException();
    }
    return facthelp(n, 1);
  }
  //helper function, returns factorial of inputted number;
  public int facthelp(int n, int product){
    int answer = product;
    if(n == 0 || n == 1){
      return answer;
    }
    return facthelp(n-1, product * n);
  }
  //function takes in n and calls helper function with n and starting two numbers;
  public int fib(int n){
    if(n < 0){
      throw new IllegalArgumentException();
    }
    return fibhelp(n, 0, 1);
  }
  //helper function, returns nth term of fibonacci sequence;
  public int fibhelp(int n, int twoless, int oneless){
    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }
    if(n == 2){
      return oneless + twoless;
    }
    return fibhelp(n - 1, oneless, oneless+twoless);
  }
  //function takes in n and calls helper function with default guess;
  public double sqrt(double n){
    if(n < 0){
      throw new IllegalArgumentException();
    }
    return sqrthelp(n, 1.0);
  }
  //helper function returns guess for square root of n by using Euclid's method of guessing, to small percentage of error;
  public double sqrthelp(double n, double guess){
    if(n == 1){
      return 1;
    }
    if(n == 0){
      return 0;
    }
    if(100 * Math.abs((guess * guess - n)/n) <= .001){
      return guess;
    }
    return sqrthelp(n, (n/guess + guess)/2);
  }
}
