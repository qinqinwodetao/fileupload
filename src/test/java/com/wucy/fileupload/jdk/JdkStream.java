package com.wucy.fileupload.jdk;

import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * Jdk Steam demo
 */
public class JdkStream {

	private static Logger logger = LoggerFactory.getLogger(JdkStream.class);

	private static List<Apple> apples = Lists.newArrayList();

	private static IntStream intStream ;

	@Before
	public void addApples(){
		apples.clear();
		Long l1 = System.currentTimeMillis();
		//构造器引用
		AppleFactory<Apple> appleFactory = Apple::new;
		for(int i=0;i<1000000;i++){
			apples.add(appleFactory.create("001","green", 8, 6));
			apples.add(appleFactory.create("002","red", 3, 3));
			apples.add(appleFactory.create("003","red", 7, 9.3f));
			apples.add(appleFactory.create("004","red", 1, 1.3f));
			apples.add(appleFactory.create("005","red", 5, 7.3f));
			apples.add(appleFactory.create("006","red", 3, 8f));
			apples.add(appleFactory.create("007","green", i+9, 10.6f));

		}
		intStream = IntStream.range(0, 99);

		logger.info("size:" + apples.size() +"| time:" + (System.currentTimeMillis()- l1));
	}

	@Test
	public void functionalInterface(){

		//谓词
		Predicate<String> predicate = s -> s.contains("i");
		Predicate<String> predicate1 = s -> s.contains("x");

		logger.info("predicate value:" + predicate.test("exits"));
		logger.info("predicate value:" + predicate.negate().test("exits"));
		//与
		logger.info("predicate value:" + predicate.and(predicate1).test("exits"));
		//或
		logger.info("predicate value:" + predicate.or(predicate1).test("exits"));
		logger.info("predicate value:" + predicate.or(predicate1).test("ex"));
		logger.info("predicate value:" + predicate.or(predicate1).test("e"));

		//函数
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<Integer, String> toString = String::valueOf;
		Function<String, Double> toDouble = Double::valueOf;
		int a = toInteger.apply("123");
		String aaa = toString.apply(123);

		String aa = toInteger.andThen(toString).apply("213");
		int aaaa  = toString.andThen(toInteger).apply(213);
		double aaaaa  = toString.andThen(toDouble).apply(213);

		logger.info("Function value:" + toInteger.apply("213"));
		logger.info("Function value:" + toInteger.andThen(toString).apply("213"));




	}


	@Test
	public void functionalInterfaceI(){
		Supplier<Apple> appleSupplier = Apple::new;
		logger.info(appleSupplier.get().toString());

		Supplier<String> stringSupplier = new Apple("001","green", 8, 6)::toString;
		logger.info(stringSupplier.get());

		logger.info("-------------- Comparator --------------");

		Comparator<Apple> appleComparator = (o1, o2) -> Float.compare(o1.getWeight(), o2.getWeight());
		apples.sort(appleComparator);
		apples.forEach((apple)-> logger.info(apple.toString()));

		//Optional
		Optional<String> stringOptional = Optional.empty();

	}

	@Test
	public void functionalInterfaceO(){
		Functional<Apple> functional = apple -> {
			apples.add(apple);
			return apples;
		};

		functional.change(new Apple("001","xxx", 9, 10.6f));

		logger.info("size:" + apples.size());

		functional.add(new Apple("002","xxx", 9, 10.6f), apples);
		logger.info("size:" + apples.size());

		//apples.stream().filter();
		//apples.sort();
		apples.forEach(System.out::println);
		logger.info(Functional.staticMethod());




	}

	@Test
	public void filterStream() {

//		apples.stream().filter((o)-> o.number > 6).forEach(System.out::println);
//		apples.stream().filter((o)-> o.number > 6).forEach(System.out::println);
//		apples.stream().map(apple -> apple.color).forEach(System.out::println);
//		apples.stream().sorted().forEach(System.out::println);
//		apples.stream().sorted((o1, o2) -> Float.compare(o1.weight,o2.weight)).forEach(System.out::println);
//		apples.stream().sorted((o1, o2) -> Float.compare(o1.weight, o2.weight)).collect(Collectors.toList());
//		apples.stream().count();
//		apples.stream().filter(apple -> apple.number > 1).distinct().forEach(System.out::println);
//		apples.stream().filter(apple -> apple.number > 1).limit(4).skip(2).forEach(System.out::println);
//		apples.stream().collect(Collectors.toMap(o -> o.id, o -> o)).forEach((key,value) -> System.out.println("key:"+key+"|"+"value:"+value));
//		String[] arrayOfWords = {"Goodbye", "World"};
//		Arrays.stream(arrayOfWords).map(w -> w.split("")).flatMap(Arrays::stream)	.collect(Collectors.toList()).forEach(System.out::println);
//		logger.info("xxxxxxxxxxxxxxxxxxxxxx");
//		logger.info("anyMatch contains red "+apples.stream().anyMatch(apple -> apple.color.equals("red")));
//		logger.info("allMatch contains red "+apples.stream().allMatch(apple -> apple.color.equals("red")));
//		logger.info("noneMatch contains xxx "+apples.stream().noneMatch(apple -> apple.color.equals("xxx")));
//		apples.stream().findAny().ifPresent(apple -> logger.info("apple:" + apple));
//		logger.info("stream reduce:" + apples.stream().map(apple -> apple.weight).reduce(0f,Float::sum));
		//暗藏装箱成本
//		Long l1 = System.currentTimeMillis();
//		float max = apples.stream().map(apple -> apple.weight).reduce(0f,Float::sum);
//		logger.info("max value:" + max +"|time:" + (System.currentTimeMillis() - l1));
//		Long l2 = System.currentTimeMillis();
//		double maxDoblue = apples.stream().mapToDouble(apple -> apple.weight).reduce(0d,Double::sum);
//		logger.info("max value:" + maxDoblue +"|time:" + (System.currentTimeMillis() - l2));
//
//
//		Long l3= System.currentTimeMillis();
//		float f = 0f;
//		for (Apple apple:apples) {
//			f += apple.weight;
//		}
//		logger.info("weight sum value:" + f +"|time:" + (System.currentTimeMillis() - l3));

/*
		intStream.forEach(value -> logger.info("intStream values:" + value));

		//int装箱
		intStream.boxed();

		//勾股数
		Stream<int[]> pythagoreanTriples =
				IntStream.rangeClosed(1, 100).boxed()
						.flatMap(a -> IntStream.rangeClosed(a, 100)
								.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
								.mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
						);
		pythagoreanTriples
				.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
*/
//		Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]}).limit(20).forEach(longs -> System.out.println(longs[0]));
//
//		String stringJoin = Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]}).limit(20).map(ints -> String.valueOf(ints[0])).collect(Collectors.joining(","));
//		logger.info("stringJoin:" + stringJoin);


//		Stream.generate(Math::random).limit(20).forEach(System.out::println);



		//Optional<Apple> xxx = apples.parallelStream().max(Apple::compareTo);
		//Optional<Apple> xxx = apples.stream().max(Apple::compareTo);
		//logger.info(xxx.get().toString());
		logger.info(apples.parallelStream().map(apple -> apple.weight).reduce(0f,Float::sum).toString());
		logger.info(apples.stream().map(apple -> apple.weight).reduce(0f,Float::sum).toString());
		//apples.stream().forEach(System.out::println);

	}

	@Test
	public void xxxx(){
		BigDecimal b = new BigDecimal(1).divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_UP);
		logger.info("xxx:"+b.toString());
		//b.setScale(2, BigDecimal.ROUND_HALF_UP);
		new BigDecimal(0.11);
		int xxx = b.compareTo(new BigDecimal("0.10"));
		logger.info("xxx:"+xxx);


	}


	/****************************interface***********************************/


	@FunctionalInterface
	interface Functional<T> {
		List<T> change(T t);

		default List<T> add(T t,List<T> list) {
			list.add(t);
			return list;
		}

		static String staticMethod(){
			return "interface staticMethod";
		}

	}
	@FunctionalInterface
	interface AppleFactory<P extends Apple>{

		P create(String id,String color, int number, float weight);



	}

	/****************************inner class***********************************/

	/**
	 * 1.成员内部类
	 * 成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
	 */
	class Apple implements Comparable<Apple>{

		private String id;
		private String color;
		private int number;
		private float weight;

		public Apple(String id, String color, int number, float weight) {
			this.id = id;
			this.color = color;
			this.number = number;
			this.weight = weight;
		}

		//无参构造器
		public Apple() {
			logger.info("Apple 构造器......");
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public float getWeight() {
			return weight;
		}

		public void setWeight(float weight) {
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Apple{" +
					"id='" + id + '\'' +
					", color='" + color + '\'' +
					", number=" + number +
					", weight=" + weight +
					'}';
		}
		@Override
		public int compareTo(@NotNull JdkStream.Apple o) {
			return this.number - o.number;
		}

	}

	/**
	 * 静态内部类
	 */
	static class Potato {

		public Potato() {
			logger.info("Potato 构造器......");

		}
	}
}


/**
 * 局部内部类
 */
class Orange{

	public Orange() {


	}
}
/**
 * 局部内部类
 * jdk 1.8 final限制已取消
 */
class InnerClass {

	public void test(final int b) {
		int a = 10;
		new Thread(){
			public void run() {
				System.out.println(a);
				System.out.println(b);
			};
		}.start();
	}
}