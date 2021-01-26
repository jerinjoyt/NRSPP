import java.util.function.BiFunction;

public class Passing_FunctionAsArgument {
	protected static class Math
	{
		public static Integer add (Integer x, Integer y)
		{
			return x +y;
		}
		public static Integer subtract (Integer x, Integer y)
		{
			return x -y;
		}
		public static Integer combine2n3 (BiFunction <Integer, Integer, Integer> combined)
		{
			
			return combined.apply(2,3);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(Math.combine2n3(Math::add));
System.out.println(Math.combine2n3(Math::subtract));
System.out.println(Math.combine2n3((x,y) -> 2*x+2*y));
	}

}
