package com.company;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static <T, R> Function<T, R> ternaryOperator( Predicate<T> condition, Function<T, R> ifTrue, Function<T, R> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 7, 6);

        Predicate<Integer> condition = x -> x % 2 != 0;
        Function<Integer, Integer> ifTrue = number -> number*5;
        Function<Integer, Integer> ifFalse = number -> number*3;

        numbers.forEach(value -> System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(value)));
    }
}
