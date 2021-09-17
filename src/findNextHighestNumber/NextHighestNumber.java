package findNextHighestNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class NextHighestNumber {

    static void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static String finalNumber(char arr[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(String.valueOf(arr[i]));
        }
        return sb.toString();
    }

    static long findNext(char[] ar, int n, long inputNumber) {
        int i = 0;
        long nextHighestNumber = 0;
        long givenNumber = inputNumber;
        // I) the first place from the right where the left-digit is less than the right
        //         Digit "x"
        for (i = n - 1; i > 0; i--) {
            //System.out.println("Array value " + ar[i] + " " + "Array - 1 value " + ar[i - 1] + "Value of I " + i);
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all digits are in descending order means
        // there cannot be a greater number with same set of digits
        if (i == 0) {
            System.out.print("Give Number "+inputNumber+" Next number with same" +
                    " set of digits is " + " (Not Possible) \n" );
            return -1;
        } else {
            int x = ar[i - 1], min = i;

            // II) find the smallest digit larger than the digit found at 1 step to the right
            for (int j = i + 1; j < n; j++) {
                // System.out.println("Array value " + ar[j] + " " + "Value of I " + j);
                if (ar[j] > x && ar[j] < ar[min]) {
                    min = j;
                }
            }

            // III) Swap the above found smallest digit with number[i-1]
            swap(ar, i - 1, min);

            // IV) Sort the digits after (i-1) in ascending order
            Arrays.sort(ar, i, n);

            nextHighestNumber = Long.parseLong(finalNumber(ar));
            System.out.print("Give Number "+inputNumber+" Next number with same" +
                    " set of digits is " + nextHighestNumber + "\n");

        }
        return nextHighestNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number :");
        long inputNumber = sc.nextLong();
        char digits[] = String.valueOf(inputNumber).toCharArray();
        int n = digits.length;
        findNext(digits, n,inputNumber);
        System.out.println("\n-------------Pre Defined Test Scenarios------------------");
        test();
        System.out.println("-------------Thank You------------------");
    }

    @Test
    public static void test() {
        final long input1 = 34722641;
        final long expected1 = 34724126;
        final long output1 = findNext((Long.toString(input1).toCharArray()), 8, input1);
        assertEquals(expected1, output1);

        final long input2 = 38276;
        final long expected2 = 38627;
        final long output2 = findNext((Long.toString(input2).toCharArray()), 5, input2);
        assertEquals(expected2, output2);

        final long input3 = 54321;
        final long expected3 = -1;
        final long output3 = findNext((Long.toString(input3).toCharArray()), 5, input3);
        assertEquals(expected3, output3);

        final long input4 = 123456784987654321L;
        final long expected4 = 123456785123446789L;
        final long output4 = findNext((Long.toString(input4).toCharArray()), 18, input4);
        assertEquals(expected4, output4);

        final long input5 = 9999;
        final long expected5 = -1;
        final long output5 = findNext((Long.toString(input5).toCharArray()), 4, input5);
        assertEquals(expected5, output5);
    }
}
