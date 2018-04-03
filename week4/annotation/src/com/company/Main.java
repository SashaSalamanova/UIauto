package com.company;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.lang.Class;

public class Main {

    public static void main(String[] args) {
        Class myClassObject = com.company.SimpleClass.class;
        /*Method[] methods = myClassObject.getMethods();
        for(Method method : methods) {
                System.out.println(method);
            }*/
        Method method = myClassObject.getMethod("sayHi", null);
        Annotation[] annotations = method.getDeclaredAnnotations();

        for(Annotation annotation : annotations) {
            if(annotation instanceof Argument) {
                Argument myAnnotation = (Argument) annotation;
                System.out.println("value: " + myAnnotation.value());
            }
        }

    }
}
