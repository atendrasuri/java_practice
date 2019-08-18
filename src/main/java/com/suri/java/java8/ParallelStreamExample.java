package com.suri.java.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
/**
 * Returns a possibly parallel {@code Stream} with this collection as its
 * source.  It is allowable for this method to return a sequential stream.
 *
 * This method should be overridden when the {@link spliter()}
 * method cannot return a spliterator that is {@code IMMUTABLE},
 * {@code CONCURRENT}, or <em>late-binding</em>. (See {@link #spliterator()}
 * for details.)
 *
 * @implSpec
 * The default implementation creates a parallel {@code Stream} from the
 * collection's {@code Spliterator}.
 *
 * @return a possibly parallel {@code Stream} over the elements in this
 * collection
 * @since 1.8
 *
 * You can execute streams in serial or in parallel. When a stream executes in parallel, the Java runtime partitions the stream into multiple substreams.
 * Aggregate operations iterate over and process these substreams in parallel and then combine the results.
 */
public class ParallelStreamExample {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

     list.parallelStream().filter(e->e%2==0).forEach(System.out::println);
  }
}