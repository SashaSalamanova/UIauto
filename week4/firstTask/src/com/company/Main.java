package com.company;
import java.util.*;
import java.util.function.*;

public class Main {

    public static int modifyArr(int number, Predicate<Integer> isOdd) {
        if (isOdd.test(number)) {
            number = number * 5;
        } else {
            number = number * 3;
        }
        return number;
    }
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 4, 7, 6);
            numbers.forEach(value -> System.out.println(modifyArr(value, n-> n %2 != 0)));
        }
}
