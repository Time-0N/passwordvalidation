package org.example;
import java.net.PasswordAuthentication;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static String autoGenPassword(int lenght) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(lenght);
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = ".*[^a-zA-Z0-9\\s].*";
        String characters = uppercase + lowercase + digits + specialCharacters;

        for (int i = 0; i < lenght; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public static boolean passwordRequirements(String password, ArrayList<String> oldPassword) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean specialFlag = false;
        boolean usedFlag = true;
        String eightLetterFlag = "TheCook";
        String specialCharacters = ".*[^a-zA-Z0-9\\s].*";

        for (String check : oldPassword) {
            if (check.equals(password)) usedFlag = false;
        }

        if (eightLetterFlag.length() < password.length() && password.matches(specialCharacters)) {
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
        oldpassword.add("Password1");
        oldpassword.add("Aa345678");
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("Do you want to automatically generate a password?");
            String start = sc.next();
            String password = "";
            int length;

            switch (start) {
                case "no":
                    System.out.println("Set your Password");
                    password = sc.next();
                    break;
                case "yes":
                    while (true) {
                        System.out.println("How long do you want your password to be? (min.8 max.20)");
                        length = sc.nextInt();
                        if (length >= 8 && length <= 20) {
                            break;
                        }
                    }
                    while (true) {
                        password = autoGenPassword(length);
                        if (passwordRequirements(password, oldpassword)) {
                            break;
                        }
                    }
                    System.out.println("Your generated password is: " + password);
                    break;
            }
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