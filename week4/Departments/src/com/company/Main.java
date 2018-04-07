package com.company;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Collection <Student> students = Arrays.asList(
                new Student("Вася", "ФАКИ"), new Student("Саша", "ФУПМ"),
                new Student("Петя","ФУПМ"), new Student("Лена", "ФРТК"),
                new Student("Оля","ФИВТ"), new Student("Женя", "ФИВТ"),
                new Student("Ваня","ФУПМ"), new Student("Соня", "ФРТК"));

        // Сортируем по названию факультетов в алфавитном порядке
        Collection <Student> sortedDepartments = students.stream()
                .filter(distinctByKey(Student::getDepartment))
                .sorted(Comparator.comparing(Student::getDepartment))
                .collect(Collectors.toList());
        // Вывод названий факультетов по алфавиту
        System.out.println("Список факультетов по алфавиту");
        sortedDepartments.forEach(student -> System.out.println(student.getDepartment()));

        //Группируем по факультетам, считаем сколько учеников на каждом
        Map<String, Long> countDepts = students.stream().collect(
                Collectors.groupingBy(Student::getDepartment, Collectors.counting()));

        //Сортируем по значению, берем первые 3
        System.out.println("Рейтинг факультетов");
        countDepts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(dept -> System.out.println(dept.getKey()+" Количество учеников: " + dept.getValue()));
    }
    public static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
        Map<Object,String> seen = new ConcurrentHashMap<>();
        return t -> seen.put(keyExtractor.apply(t), "") == null;
    }
}
