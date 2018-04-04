package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplicationTable {
    @Argument(value = 5)
    public void printMultiplicationTableToAnnotationValue(){
        Class<?> clazz = this.getClass();

        List<Argument> annotations = Arrays.stream(clazz.getMethods())
                .filter(method -> method.isAnnotationPresent(Argument.class))
                .map(method -> method.getAnnotation(Argument.class))
                .collect(Collectors.toList());

        annotations.stream().forEach(annotation -> printMultiplicationTable(annotation.value()));

    }
    public void printMultiplicationTable(int n){
        for(int i = 1; i < n + 1; i++){
            for(int k = 1; k < n + 1; k++){
                System.out.println(i + "x" + k + " = " + k * i );
            }
            System.out.println("\n");
        }
    }
}
