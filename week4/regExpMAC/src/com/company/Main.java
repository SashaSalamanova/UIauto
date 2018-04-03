package com.company;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите MAC адрес: ");
        String macAddress = in.nextLine();
        Pattern pattern = Pattern.compile("^(((\\p{XDigit}{2})[:-]){5}\\p{XDigit}{2})$");
        Matcher matcher = pattern.matcher(macAddress);

        if(matcher.find()){
            System.out.println("MAC адрес " + macAddress + " верный");
        }
        else { System.out.println("MAC адрес " + macAddress + " не верный"); };
    }
}