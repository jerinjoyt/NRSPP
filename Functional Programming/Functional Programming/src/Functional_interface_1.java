import java.util.function.Function;
// here we are using the function as an object.we use the functional 
public class Functional_interface_1 
{
protected static class myclass {
	private static Integer tri (Integer a) {
		return a*3;
	}
}
public static void main (String []args) {
 	Function <Integer , Integer> mytri = myclass :: tri;
// 	Function <Integer , Integer> mytri = (x) -> x*3;
	Integer res= mytri.apply(4);
	System.out.println(res);
}
}

/* Basically, what we just did here is we treated another classes method as an object and called it. 
 * And again, the apply thing that you see here is a method that all function objects have, 
 * that basically just calls the function with whatever arguments we pass to it.
 *  Another point of interest here is the function interface itself.
 *   The function interface is generic with two types that we can choose. 
 *   The first type is the type of the argument that the function accepts. 
 *   So for example, our triple function here takes an integer as an argument.
 *    So the first generic type here is integer. And then the second generic type here is the type of the return value of the function.
 *     So in the case of our triple function, which returns an integer, this would be integer as well. 
 *     The main point here is that in functional programming, 
 *     we're allowed to sort of break functions out of their normal role in Java
 *      of just being class methods and work with them in a very similar way to how we'd work with any other type of data.
 */
