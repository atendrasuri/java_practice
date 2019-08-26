package com.suri.java.java8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 *
 *
 * Stream flatMap(Function mapper) returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Stream flatMap(Function mapper) is an intermediate operation. These operations are always lazy.
 * Intermediate operations are invoked on a Stream instance and after they finish their processing, they give a Stream instance as output.
 *
 * Note : Each mapped stream is closed after its contents have been placed into this stream. If a mapped stream is null, an empty stream is used, instead.
 *
 * flatMap() V/s map() :
 * 1) map() takes a Stream and transform it to another Stream. It applies a function on each element of Stream and store return value into new Stream. It does not flatten the stream. But flatMap() is the combination of a map and a flat operation i.e, it applies a function to elements as well as flatten them.
 * 2) map() is used for transformation only, but flatMap() is used for both transformation and flattening.
 *
 * https://www.geeksforgeeks.org/stream-flatmap-java-examples/
 *
 * =============How does flatMap() work ?==========================
 * As already discussed in the post that flatMap() is the combination of a map and a flat operation i.e, it first applies map function and than flattens the result. Let us consider some examples to understand what exactly flattening a stream is.
 * Example 1 :
 * The list before flattening :
 *
 * [ [2, 3, 5], [7, 11, 13], [17, 19, 23] ]
 * The list has 2 levels and consists of 3 small lists. After Flattening, it gets transformed into “one level” structure as shown :
 *
 * [ 2, 3, 5, 7, 11, 13, 17, 19, 23 ]
 * Example 2 :
 * The list before flattening :
 *
 * [ ["G", "E", "E"], ["K", "S", "F"], ["O", "R", "G"], ["E", "E", "K", "S"] ]
 * The list has 3 levels and consists of 4 small lists. After Flattening, it gets transformed into “one level” structure as shown :
 *
 * ["G", "E", "E", "K", "S", "F", "O", "R", "G", "E", "E", "K", "S"]
 */

public class JavaStreamFlatMapAggregateExample {
  public static void main(String[] args) {
    State karnataka = new State();
    karnataka.addCity("Bangalore");
    karnataka.addCity("Mysore");

    State punjab = new State();
    punjab.addCity("Chandigarh");
    punjab.addCity("Ludhiana");

    List<State> allStates = Arrays.asList(karnataka, punjab);

    //Java Stream flatMap way
    List<String> allCities = allStates.stream()
            .flatMap(e -> e.getCities().stream())
            .collect(Collectors.toList());

    System.out.println(allCities);

    //legacy way
    allCities = new ArrayList<String>();
    for (State state : allStates) {
      for (String city : state.getCities())
        allCities.add(city);
    }
    System.out.println(allCities);


    // Creating a List of Strings
    List<String> list = Arrays.asList("Geeks", "GFG",
            "GeeksforGeeks", "gfg");

    System.out.println("Dhanu");
    list.stream().map(m->m.charAt(2)).forEach(System.out::println);

    // Using Stream flatMap(Function mapper)
    list.stream().flatMap(str ->
            Stream.of(str.charAt(2))).
            forEach(System.out::println);


    List<Integer> numbers1= Arrays.asList(1,3,5,6,8,9);
    List<Integer> numbers2= Arrays.asList(0,2,4,6,7,10);


    List<List<Integer>> numbers = Arrays.asList(numbers1, numbers2);


    numbers.stream().flatMap(l->Stream.of(l.get(3))).forEach(System.out::println);



    // Creating a list of Prime Numbers
    List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);

    // Creating a list of Odd Numbers
    List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

    // Creating a list of Even Numbers
    List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

    List<List<Integer>> listOfListofInts =
            Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

    System.out.println("The Structure before flattening is : " +
            listOfListofInts);

    // Using flatMap for transformating and flattening.
    List<Integer> listofInts  = listOfListofInts.stream()
            .flatMap(list1 -> list1.stream())
            .collect(Collectors.toList());

    System.out.println("The Structure after flattening is : " +
            listofInts);


    List<Integer>l1 = Arrays.asList(0,2,4,6,8,10);

    List<Integer>l2 = Arrays.asList(1,3,5,7,9);

    List<List<Integer>>l3 = Arrays.asList(l1,l2);
    System.out.println("Test===");
    l3.parallelStream().flatMap(x->x.parallelStream()).collect(Collectors.toList()).forEach(System.out::println);


  }

}

class State {
  private List<String> cities = new ArrayList<>();

  public void addCity(String city) {
    cities.add(city);
  }

  public List<String> getCities() {
    return this.cities;
  }
}
