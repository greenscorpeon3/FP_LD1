package imperative;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {
	
	public enum STATE{
		ABUNDANT,
		PERFECT,
		DEFICIENT
	}
	
	public static STATE process(int i) {
		int sum = PerfectNumber.divisors(i).stream()
				.mapToInt(Integer::intValue)
				.filter(x -> x != i)
				.sum();
		
		return sum == i ? STATE.PERFECT : sum < i ? STATE.DEFICIENT : STATE.ABUNDANT;
	}
	
	public static Set<Integer> divisors(int i){
		return IntStream.rangeClosed(1, i)
				.filter(x -> i % x == 0)
				.boxed()
				.collect(Collectors.toSet());
	}
	
	
	
}
