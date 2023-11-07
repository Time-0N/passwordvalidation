package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {


    public static boolean passwordRequirements(String password, ArrayList<String> oldPassword) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean usedFlag = true;
        String eightLetterFlag = "TheCook";

        for (String check : oldPassword) {
            if (check.equals(password)) usedFlag = false;
        }

        if (eightLetterFlag.length() < password.length()) {
            for (int i = 0; i < password.length(); i++) {
                ch = password.charAt(i);
                if (Character.isDigit(ch)) {
                    numberFlag = true;
                } else if (Character.isUpperCase(ch)) {
                    capitalFlag = true;
                } else if (Character.isLowerCase(ch)) {
                    lowerCaseFlag = true;
                }
            }
        }
        if (numberFlag && capitalFlag && lowerCaseFlag && usedFlag) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> oldpassword = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("Set your Password");
            String password = sc.next();
            boolean requirements = passwordRequirements(password, oldpassword);
            oldpassword.add(password);

            if (requirements) {
                while (true) {
                    System.out.println("Enter your Password");
                    String input = sc.next();
                    if (input.equals(password)) {
                        System.out.println("Access: Password correct");
                        break;
                    } else {
                        System.out.println("Access denied: Incorrect Password");
                    }
                }
            } else {
                System.out.println("The Requirements have not been met");
            }
        }
    }
}