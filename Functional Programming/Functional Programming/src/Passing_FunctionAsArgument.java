import java.util.Scanner;
import java.util.function.BiFunction;

public class Passing_FunctionAsArgument {
	protected static class Math
	
	{
		static Scanner input = new Scanner (System.in);
		public static Integer add (Integer x, Integer y)
		{
			return x +y;
		}
		public static Integer subtract (Integer x, Integer y)
		{
			return x -y;
		}
//		 what this function do is, it actually takes another function as argument 
//		Only thing to make sure is they both should have the same syntax and return type
//		here the name combined could be any name
		public static Integer combine2n3 (BiFunction <Integer, Integer, Integer> combined)
		{
			System.out.println("Enter an integer ");
			int x = input.nextInt();
			
			System.out.println("Enter an integer ");
			int y = input.nextInt();
			return combined.apply(x,y);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(Math.combine2n3(Math::add));
System.out.println(Math.combine2n3(Math::subtract));
System.out.println(Math.combine2n3((x,y) -> 2*x+2*y));
	}

}
