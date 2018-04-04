package com.company;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static <T, R> Function<T, R> ternaryOperator( Predicate<T> condition, Function<T, R> ifTrue, Function<T, R> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {

        Predicate<Integer> condition = x -> x >= 0;
        Function<Integer, String> ifTrue = number -> String.format("Число %d неотрицательное", number);
        Function<Integer, String> ifFalse = number -> String.format("Число %d отрицательное", number);
        Function<Integer, String> checkIfNegative= ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(checkIfNegative.apply(-1));
    }
}
