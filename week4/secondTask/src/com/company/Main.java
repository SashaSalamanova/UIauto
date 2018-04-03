package com.company;
import java.util.*;
import java.util.function.*;

public class Main {

    public static Function<Integer, String> ternaryOperator(Boolean condition,
                                                            Function<Integer, String> ifTrue,
                                                            Function<Integer, String> ifFalse) {
        if (condition) { return ifTrue;}
        else {return ifFalse;}
    }

    public static void main(String[] args) {
        Predicate<Integer> condition = x -> x > 0;
        Function<Integer, String> ifTrue = number -> String.format("Верно %d", number);
        Function<Integer, String> ifFalse = number -> String.format("Не верно %d", number);
        System.out.println(ternaryOperator(condition.test(-1), ifTrue, ifFalse).apply(10));
    }
}
