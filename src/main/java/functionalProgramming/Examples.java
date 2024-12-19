package functionalProgramming;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Examples {

  static Function<String, Integer> stringLength = String::length;
  static Predicate<String> stringContainsA = s -> s.contains("a");
  static Predicate<String> stringContainsB = s -> s.contains("b");
  static BiFunction<String, String, Integer> stringsLengthSum = (a, b) -> a.length() + b.length();
  static Supplier<Set<String>> stringSupplier = () -> Set.of("Hello", "World");
  static Consumer<Set<String>> stringConsumer = strings -> strings.forEach(System.out::println);
  static UnaryOperator<String> unaryOperator = s -> "Hello " + s;
  static BinaryOperator<String> binaryOperator = (a, b) -> "Hello " + a + " " + b;

  public static void main(String[] args) {
    // Use Function
    System.out.println("stringLength: " + stringLength.apply("hello"));

    // Use Predicate
    System.out.println("String 'hello_a_b' contains a and b " + stringContainsA.and(stringContainsB).test("hello_a_b"));

    // Use BiFunction
    System.out.println("stringsLengthSum for 'Hello' and 'Buy': " + stringsLengthSum.apply("Hello", "Buy"));

    // Use Supplier
    System.out.println("Supply stringSupplier: " + stringSupplier.get());

    // Use Consumer
    stringConsumer.accept(stringSupplier.get());

    // Use Operators
    System.out.println("Supply unaryOperator: " + unaryOperator.apply("Bill"));
    System.out.println("Supply binaryOperator: " + binaryOperator.apply("Bill", "Johns"));
  }
}
