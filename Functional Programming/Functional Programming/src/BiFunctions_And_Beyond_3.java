import java.util.function.BiFunction;

public class BiFunctions_And_Beyond_3 {

	public static void main(String[] args) {
		// two int vals and the return value in int
		BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;

		System.out.println(add.apply(4, 3) + " <<--Result of add function with values 4 and 3 ");

		// to create functions that take more than 2 values or no values we need to
		// create a custom interface first.

		TriFunction_Interface<Integer, Integer, Integer, Integer> addTri = (x, y, z) -> x + y + z;

		System.out.println(addTri.apply(2, 5, 6) + " <<--Result of addTri function with values 2,5 and 6");

		No_Arg_Interface<String> SayHi = () -> "Hi Everyone";
		System.out.println(SayHi.apply() + " <<-- hi using the sayHi function, which implements a no argument interface and returns something, string in this instance");
	}

}
