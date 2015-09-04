package practiceproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 *
 * @author Gunnar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Reverse string question
        String stringAnswer = reverseString("Where are you now?");
        System.out.println(stringAnswer);
   
        nthFibonacci(10);
        
        printMultiplicationTable(12);
        
        int intAnswer = sumLines("ints.txt");
        System.out.println(intAnswer);
        
        printOddNumbers(13);
        
        int numArray[] = {1, 2, 3, 4, 5};
        intAnswer = findMax(numArray);
        System.out.println(intAnswer);
        
        System.out.println(formatRGB(122, 121, 34));
        
        arrayRotateOneByOne(numArray, 3);
        
        if (balancedDelimiter("{()}{([]})[]")) {
            System.out.println("String was unbalanced");
        }
        else {
            System.out.println("String was balanced");
        }
        
        System.out.println(factorial(5));
    }
    
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        for (int i = (charArray.length- 1)/2; i >= 0; i--) {
            int swapPosition = (charArray.length - 1)  - i;
            char tmp = str.charAt(swapPosition);
            charArray[swapPosition] = charArray[i];
            charArray[i] = tmp;
        }
        
        return new String(charArray);
    }
    
    // Attempting to do this not recursively as recursively takes forever with high numbers
    public static void nthFibonacci(int n) {
        int firstNumber = 0;
        int secondNumber = 1;
        int temp;
        System.out.print(firstNumber + ", " + secondNumber + ", ");
        for (int i = 1; i < n; i++) {
            temp = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
            System.out.print(secondNumber + ", ");
        }
    }
    
    public static void printMultiplicationTable(int size) {
        for (int i = 0; i <= size; i++) {
            for(int j = 0; j <= size; j++) {
                System.out.printf("%3d ", i * j);
            }
            System.out.println();
        }
    }
    
    public static int sumLines(String filename) {
        int sum = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            br.close();
        }
        catch (IOException | NumberFormatException e) {
            System.out.println("ERRR");
        }
        
        return sum;
    }
    
    public static void printOddNumbers(int stopPoint) {
        for (int i = 0; i <= stopPoint; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    public static String formatRGB(int r, int g, int b) {
        return (toHex(r) + toHex(g) + toHex(b)).toUpperCase();
    }
    
    public static String toHex(int num) {
        String s = Integer.toHexString(num);
        return (s.length() == 1) ? "0" + s : s;
    }
    
    public static void arrayRotateOneByOne(int[] array, int n) {
        printArray(array);
        n = n % array.length;
        for (int i = 0; i < n; i++) {
            rotateOnePlace(array, array.length);
        }
        printArray(array);
    }
    
    public static void rotateOnePlace(int[] array, int length){
        int i, temp = array[0];
        for (i = 0; i < length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[i] = temp;
    }
    
    public static void printArray(int[] array) {
        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    
    public static boolean balancedDelimiter(String str) {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char currentCharacter = str.charAt(i);
            if (currentCharacter == '[' ||
                currentCharacter == '(' ||
                currentCharacter == '{'
                ) {
                stack.push(currentCharacter);
            }
            else {
                if ((currentCharacter == ']' && (char)stack.peek() == '[') ||
                    (currentCharacter == '}' && (char)stack.peek() == '{') ||
                    (currentCharacter == ')' && (char)stack.peek() == '(')
                   ) {
                    stack.pop();
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }
}
