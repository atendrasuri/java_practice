package com.suri.java.java8;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 17/08/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 * Functional Interface is an Interface which allows only one Abstract method within the Interface scope. There are some predefined functional interface in Java like Predicate, consumer, supplier etc.
 *
 * The Functional Interface PREDICATE is defined in the java.util.Function package.It improves manageability of code, helps in unit-testing them separately, and contain some methods like:
 *
 * isEqual(Object targetRef) : Returns a predicate that tests if two arguments are equal according to Objects.equals(Object, Object).
 * static  Predicate isEqual(Object targetRef)
 * Returns a predicate that tests if two arguments are
 * equal according to Objects.equals(Object, Object).
 * T : the type of arguments to the predicate
 * Parameters:
 * targetRef : the object reference with which to
 * compare for equality, which may be null
 * Returns: a predicate that tests if two arguments
 * are equal according to Objects.equals(Object, Object)
 * and(Predicate other) : Returns a composed predicate that represents a short-circuiting logical AND of this predicate and another.
 * default Predicate and(Predicate other)
 * Returns a composed predicate that represents a
 * short-circuiting logical AND of this predicate and another.
 * Parameters:
 * other: a predicate that will be logically-ANDed with this predicate
 * Returns : a composed predicate that represents the short-circuiting
 * logical AND of this predicate and the other predicate
 * Throws: NullPointerException - if other is null
 * negate() : Returns a predicate that represents the logical negation of this predicate.
 * default Predicate negate()
 * Returns:a predicate that represents the logical
 * negation of this predicate
 * or(Predicate other) : Returns a composed predicate that represents a short-circuiting logical OR of this predicate and another.
 * default Predicate or(Predicate other)
 * Parameters:
 * other : a predicate that will be logically-ORed with this predicate
 * Returns:
 * a composed predicate that represents the short-circuiting
 * logical OR of this predicate and the other predicate
 * Throws : NullPointerException - if other is null
 * test(T t) : Evaluates this predicate on the given argument.boolean test(T t)
 * test(T t)
 * Parameters:
 * t - the input argument
 * Returns:
 * true if the input argument matches the predicate, otherwise false
 */
public class PedicateExample {


  public static void main(String[] args) {

    Predicate<Integer> p1= i->i%2==0;


    System.out.println(p1.test(8));

    System.out.println(p1.test(9));

    Function p;
  }
}