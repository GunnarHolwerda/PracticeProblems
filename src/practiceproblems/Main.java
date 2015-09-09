package practiceproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import practiceproblems.MergeSort;

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
        String stringAnswer = reverseString("Am I backwards yet?");
        System.out.println(stringAnswer);
   
        nthFibonacci(10);
        System.out.println();
        
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
        
        int[] coupleArray = {1, 2, 3, 4, 5, 99, 1, 2, 3, 4, 5};
        System.out.println(findUncoupled(coupleArray));
        
        int[] targetSumArray = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        targetSum(targetSumArray, 10);
        
        Node testList = new Node(1, new Node(2, new Node(3)));
        printLinkedList(testList);
        testList = reverseLinkedList(testList);
        System.out.println();
        printLinkedList(testList);
        System.out.println();
        
        int[] sortArray = {7, 12, 3, 4, 19, 1, 53, 8, 6, 5};
        MergeSort ms = new MergeSort();
        printArray(sortArray);
        ms.sort(sortArray);
        printArray(sortArray);
        
        int[] addArray = {9, 9, 9, 9};
        printArray(addOneToIntegerArray(addArray));
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
    
    public static int findUncoupled(int[] list) {
        int unpaired = 0;
        for (int i : list)
            unpaired ^= i;
        
        return unpaired;
    }
    
    public static void targetSum(int[] numbers, int sum) {
        // Sort the array
        Arrays.sort(numbers);
        
        int start = 0;
        int end = numbers.length - 1;
        
        while (start < end) {
            int currentSum = numbers[start] + numbers[end];
            
            if (currentSum == sum) {
                System.out.println(numbers[start] + ", " + numbers[end]);
                return;
            }
            else if (currentSum < sum) {
                start++;
            }
            else {
                end--;
            }
        }
        System.out.println("No integers found to total: " + sum);
    }
    
    public static Node reverseLinkedList(Node root) {
       Node reversedPart = null;
       Node current = root;
       while (current != null) {
           // Break off rest of list
           Node restOfList = current.getNext();
           // Set the next of the current node to the reversed LinkedList
           current.setNext(reversedPart);
           // The reversed Linked list is now started with the current node
           reversedPart = current;
           // Start over with the rest of the list
           current = restOfList;
       }
       root = reversedPart;
       return root;
    }
    
    public static void printLinkedList(Node root) {
        while (root != null) {
            System.out.print(root.getValue() + ", ");
            root = root.getNext();
        }
    }
    
    public static int[] addOneToIntegerArray(int[] array) {
        boolean increaseArraySize = false;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < 9) {
                array[i] += 1;
                return array;
            }
            else {
                // We have to carry down the array and set current to 0
                array[i] = 0;
                if (i == 0) {
                    increaseArraySize = true;
                }
            }
        }
        
        if (increaseArraySize) {
            int[] newArray = new int[array.length + 1];
            newArray[0] = 1;
            for (int i = 0; i < array.length; i++) {
                newArray[i + 1] = array[i];
            }
            array = newArray;
        }
        return array;
    }
}
