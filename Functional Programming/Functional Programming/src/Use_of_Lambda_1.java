import java.util.function.Function;

public class Use_of_Lambda_1 {

	public static void main(String[] args) {
		// after the function inside the "< " the first type is the argument/ input type and the second type is the return type of the method
		Function <Integer, Integer> absoluteValue = (x) -> {
			if (x < 0) {
				return -x;
			}
			else {
				return x;
			}
				
		};
		
		System.out.println(absoluteValue.apply(-24));
		System.out.println(absoluteValue.apply(24));
	}

}
