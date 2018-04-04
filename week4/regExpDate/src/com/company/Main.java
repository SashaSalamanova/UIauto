package com.company;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static String buildRegExp(String stringFormat){
        String formatRegExp = stringFormat.toLowerCase().replace("/", "[- /.]")
                .replace(".", "\\.")
                .replace("yyyy", "[0-9]{4}")
                .replace("yy", "[0-9]{2}")
                .replace("dd", "(0[1-9]|1[0-9]|2[0-9]|3[01])")
                .replace("mm", "(0[1-9]|1[012])");
        formatRegExp = "^" + formatRegExp + "$";

        return formatRegExp;
    }

    public static void checkRegExp(String dateFormat, String dateString){
        Pattern pattern = Pattern.compile(buildRegExp(dateFormat));
        Matcher matcher = pattern.matcher(dateString);

        if(matcher.find()){
            System.out.println("Дата " + dateString + " соответствует шаблону " + dateFormat);
        }
        else { System.out.println("Дата " + dateString + " не соответствует шаблону " + dateFormat); };
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату: ");
        String dateString = in.nextLine();
        System.out.print("Введите формат даты: ");
        String dateFormat = in.nextLine();

        checkRegExp(dateFormat, dateString);
    }
}
