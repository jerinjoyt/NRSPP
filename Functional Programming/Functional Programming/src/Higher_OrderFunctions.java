import java.util.function.BiFunction;
import java.util.function.Function;

public class Higher_OrderFunctions {

	public static void main(String[] args) 
	{
//		this is a simple bifunction
		BiFunction <Float,Float,Float> divide = (x,y) -> x/y;
//		 This function takes a bifunction and returns another bifunction
		Function <BiFunction <Float, Float, Float>, BiFunction <Float, Float, Float>> SecondArgIsZero =
				(func) -> (x,y) ->  // here func is the bifunction taken and x and y are its parameters
				
		{
			if (y==0)
			{
				System.out.println(" The second argument is zero ");
				return (float) 0;
			}
			
				return func.apply(x,y);
		};
		
		BiFunction <Float,Float,Float> divideSafe = SecondArgIsZero.apply(divide);
		
		System.out.println(divideSafe.apply(6f, 3f));
		System.out.println(divideSafe.apply(6f, 0f));
		
		
		

	}

}
