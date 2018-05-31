package com.frank.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {

	
	@Test
	public void test1() {

		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		List<Integer> squareNums = nums.stream().map(n -> n+n).collect(Collectors.toList());
		System.out.println(squareNums);

	}
	
	@Test
	public void test2() {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		nums = nums.stream().filter(t -> t%2 == 0).collect(Collectors.toList());
		System.out.println(nums);
	}
	
	@Test
	public void test3() {
		
		List<String> nums = new ArrayList<>();
		nums.add("a");
		nums.add("b");
		System.out.println(nums.stream().map(String::toUpperCase).collect(Collectors.toList()));
		System.out.println(nums.stream().map(t -> t.toUpperCase()).collect(Collectors.toList()));
	}
	
	/**
	 * map 和 flatMap之间的区别
	 */
	@Test
	public void test4() {
		
		List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",  
	            "hello world welcome"); 
//		list = list.stream().flatMap(str->Arrays.stream(str.split(""))).distinct().collect(Collectors.toList());
//		System.out.println(list);
		
		
		list = list.stream().flatMap(str->Arrays.stream(str.split(""))).distinct().collect(Collectors.toList());
		System.out.println(list);
		
		
//		list.forEach(e -> System.out.println(e));  
	    
	}
	
	@Test
	public void test5() {
		Stream.of("one", "two", "three", "four")
		 .filter(e -> e.length() > 3)
		 .peek(e -> System.out.println("Filtered value: " + e))
		 .map(String::toUpperCase)
		 .peek(e -> System.out.println("Mapped value: " + e))
		 .collect(Collectors.toList());
	}
	
	@Test
	public void test6() {
		
		// 字符串连接，concat = "ABCD"
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat); 
		System.out.println(concat);
		
		// 求最小值，minValue = -3.0
		double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min); 
		System.out.println(minValue);
		
		// 求和，sumValue = 10, 有起始值
		int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		System.out.println(sumValue);
		
		// 求和，sumValue = 10, 无起始值
		sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
		// 过滤，字符串连接，concat = "ace"
		concat = Stream.of("a", "B", "c", "D", "e", "F").
		 filter(x -> x.compareTo("Z") > 0).
		 reduce("", String::concat);
	}
	
	
}
