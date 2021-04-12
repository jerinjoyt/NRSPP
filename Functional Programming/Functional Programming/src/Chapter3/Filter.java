package Chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Filter {

	public static void main(String[] args)
	{
		Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> intList = new ArrayList<>(Arrays.asList(intArray));
		List <Integer> evens = new ArrayList <>();
		List <Integer> evenNums = new ArrayList <>();
//		 Predicates have boolean values, here we say isEven true when numbers are even.
		Predicate <Integer> isEven = (x) -> x % 2 == 0;
		
//		The following lines use the conventional for loop to sort the array of numbers.
		for (int i =0; i < intList.size();i++)
		{
			Boolean val = intList.get(i) % 2 ==0;
			
			if (val)
			{
				evens.add(intList.get(i));
			}
		}
		
		evenNums = intList
				.stream()
				.filter(isEven)
				.collect(Collectors.toList());
		
		System.out.println(evenNums);
		System.out.println(evens);
		
		String [] wordsarray = {"Hello","Functional", "Programming", "is", "Cool"};
		List <String> words = new ArrayList <>(Arrays.asList(wordsarray));
		
		Function <Integer,Predicate <String> > predicateCreator = (x) -> (y) -> y.length() >x ;
		Predicate <String> big3 = predicateCreator.apply(3);
//		System.out.println(" Please enter the number by which we needs to filter");
		Predicate <String> isbig = (string) -> string.length() >5;
		List <String> bigwords = new ArrayList <>();
		bigwords = words
				.stream()
				.filter(isbig)
				.collect(Collectors.toList());
		List <String> bigger3 = words
				.stream()
				.filter(big3)
				.collect(Collectors.toList());
		System.out.println(bigger3);
				
		
		System.out.println(bigwords);
		
		
		
		
	}

}
