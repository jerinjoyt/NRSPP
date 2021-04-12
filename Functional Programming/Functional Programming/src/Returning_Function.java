import java.util.Scanner;
import java.util.function.Function;

public class Returning_Function {
	
protected static class Math
	
	{
		public static Integer times2 (Integer x)
		{
			return x*2;
		}
		public static Integer times3 (Integer x)
		{
			return x*3;
		}
		public static Integer times4 (Integer x)
		{
			return x*4;
		}

		public static Function <Integer, Integer> createMultiplier (Integer y)
		{
			return (Integer x) -> x*y;
//			 the above line is the new functions definition
//			so this will create a new function that takes an integer and 
//			multiplies it to the integer used to create the function.
		}
	}
		
	public static void main(String[] args) 
	{
		No_Arg_Interface<No_Arg_Interface<String> > creator = () ->{
			return () -> "Hi functions";
		};
		
		No_Arg_Interface<No_Arg_Interface<String> > SimpleCreator = () -> () -> "Hi functions, this is from the simple creator";
	
		No_Arg_Interface<String>  greeter = creator.apply();
		No_Arg_Interface<String>  greeter1 = SimpleCreator.apply();
		
		System.out.println(greeter.apply());
		System.out.println(greeter1.apply());
//		This will create a new function that takes a number and multiplies it by 2
		Function <Integer, Integer> twice = Math.createMultiplier(2);
		System.out.println(twice.apply(5));
//		The following lines creates methods that multiplies the input by three and four respectively.
		
		Function <Integer, Integer> thrice = Math.createMultiplier(3);
		Function <Integer, Integer> timesFour = Math.createMultiplier(4);
		System.out.println(thrice.apply(5));
		System.out.println(timesFour.apply(5));
		
		
		Function <Integer,Function <Integer, Integer>> Xm = (x) -> (y)-> x*y;
		Function <Integer, Integer> fives = Xm.apply(5);
		System.out.println(fives.apply(5));
	}
	
	
		

	
	}


