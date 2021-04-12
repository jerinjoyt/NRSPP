package Chapter3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Map {

	public static void main(String[] args) 
	{
		Integer [] intArray = {1,2,3,4,5,6,7,8,9,10};
		List <Integer> nums = new ArrayList <> ();
        for (int i =1;i <101;i ++) 
        {
			nums.add(i);
		};
		List <Integer> intList = new ArrayList <> (Arrays.asList(intArray));
		
		List <Integer> doubled = new ArrayList <>();
		for (int i =0; i<intList.size(); i++)
		{
			Integer result = intList.get(i)*2;
			doubled.add(result);
		}
		
		Function <Integer, Integer> timestwo = (x) -> x*2;
		Function <Integer,String> fizbuz = (x) ->
		{
			if (x%3==0 && x%5==0)
				return "FizzBuzz";
			if  (x%3==0)
				return "Fizz";
			if  ( x%5==0)
				return "Buzz";
			else return x.toString();
			
		
			
		};
		
		List <Integer> doublednew = intList 
				.stream()  // Converts the list in to a stream
				.map(timestwo)  //maps the items in the list and apply the function inside it to all the elements
				.collect(Collectors.toList()); // Converts the stream back to a list
		
		List <String> numsNew =  nums
				                  .stream()
				                  .map(fizbuz)
				                  .collect(Collectors.toList());
		System.out.println(intList);
		System.out.println(doubled);
		System.out.println("This is with stream and map and inside map we used function\n"+doublednew);
		
		System.out.println("We are doing the fiz buz with functional programming");
		System.out.println(nums);
		System.out.println(numsNew);
	}

}
