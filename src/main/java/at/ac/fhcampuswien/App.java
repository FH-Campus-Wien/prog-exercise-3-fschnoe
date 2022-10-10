package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        oneMonthCalendar(31,3);

        guessingGame(randomNumberBetweenOneAndHundred());

        int[] array = {3, 9, 1, 5, 8};
        int a = checkDigit(array);
    }

    public static void oneMonthCalendar(int days, int firstDay){
        int firstSpaces = firstDay * 3 - 3;

        for (int i = 0; i < firstSpaces; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i <= days -1; i++) {
            System.out.printf("%2d ", i+1);
            if ((i + firstDay) % 7 == 0) {
                System.out.println();
            }
        }

        if (firstDay == 2) {
            System.out.println();
        }
    }

    public static long[] lcg(long seed){
        long[] random = new long[10];

        final long M = (long) Math.pow(2, 31);
        final long A = 1103515245;
        final long C = 12345;

        for (int i = 0; i < random.length; i++) {
            if (i == 0) {
                random[i] = (A * seed + C) % M;
            } else {
                random[i] = (A * random[i - 1] + C) % M;
            }
        }

        return random;
    }

    public static void guessingGame(int numberToGuess){
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Guess number " + (i + 1) + ": ");
            int guess = scanner.nextInt();

            if (i == 9) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }

            if(guess == numberToGuess){
                System.out.println("You won wisenheimer!");
                break;
            } else if (guess < numberToGuess){
                System.out.println("The number AI picked is higher than your guess.");
            } else {
                System.out.println("The number AI picked is lower than your guess.");
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred(){
        Random r = new Random();
        return r.nextInt(100 - 1) + 1;
    }

    public static boolean swapArrays(int[] a, int[] b){
        if(a.length != b.length){
            System.out.println("Arrays are not the same length!");
            return false;
        } else {
            int[] temp = new int[a.length];

            for (int i = 0; i < a.length; i++) {
                temp[i] = a[i];
                a[i] = b[i];
                b[i] = temp[i];
            }

            return true;
        }
    }

    public static String camelCase(String text){
        char[] chars = text.toCharArray();
        StringBuilder camelCase = new StringBuilder();

        if(chars[0] >= 97 && chars[0] <= 122){
            char c = (char) (chars[0] - 32);
            camelCase.append(c);
        } else {
            camelCase.append(chars[0]);
        }

        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == '.' || chars[i] == '?' || chars[i] == '!'){
                i += 2;
                if(i > chars.length){
                    break;
                }
            } else if (chars[i] == '\''){
                i++;
            }

            if(chars[i] == ' '){
                i++;
                if(chars[i] >= 97 && chars[i] <= 122){
                    char c = (char) (chars[i] - 32);
                    camelCase.append(c);
                } else {
                    camelCase.append(chars[i]);
                }
            } else {
                if(chars[i] >= 65 && chars[i] <= 90){
                    char c = (char) (chars[i] + 32);
                    camelCase.append(c);
                } else {
                    camelCase.append(chars[i]);
                }
            }
        }
        return camelCase.toString();
    }

    public static int checkDigit(int[] digits){
        //Step 1
        int[] weights = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            weights[i] = i + 2;
        }

        //Step 2
        int[] products = new int[weights.length];

        for (int i = 0; i < weights.length; i++) {
            products[i] = weights[i] * digits[i];
        }

        int product = 0;
        for (int i = 0; i < products.length; i++) {
            product += products[i];
        }

        //Step 4
        int mod = product % 11;

        int checkDigit = 0;
        if(11-mod == 10){
            checkDigit = 0;
        } else if (11-mod == 11){
            checkDigit = 5;
        } else {
            checkDigit = 11 - mod;
        }

        return checkDigit;
    }
}