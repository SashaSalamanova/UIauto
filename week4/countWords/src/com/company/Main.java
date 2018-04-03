package com.company;
import java.util.stream.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String str = "like the flame that burns the candle The candle feeds the flame";
        Stream<String> streamFromString = Stream.of(str.split(" "));
        List<String> filteredStrings =
                streamFromString
                        .filter(s -> s.toLowerCase().startsWith("t"))
                        .filter(s -> s.length() < 5)
                        .collect(Collectors.toList());
        filteredStrings.forEach(value -> System.out.println(value + ": " + value.length()));
    }
}
