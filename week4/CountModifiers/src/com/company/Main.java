package com.company;
import java.lang.Class;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        Field[] fields = SomeClass.class.getDeclaredFields();
        List<String> filedModifiers = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            filedModifiers.add(Modifier.toString(f.getModifiers()));
        }
        System.out.println(
                "public: " + filedModifiers.stream().filter(s -> s.equals("public")).count()+"\n"+
                        "private: " + filedModifiers.stream().filter(s -> s.equals("private")).count()+"\n"+
                        "protected: " + filedModifiers.stream().filter(s -> s.equals("protected")).count()
        );
    }
}
