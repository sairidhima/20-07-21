 import java.util.Scanner;
public class ReverseInteger{
    public static void main(String args[]){
        int input = 12345;
        int output = reverseInteger(12345);
        System.out.println("Input : " + input + " Output : " + output);

         }
         public static int reverseInteger(int number) {
        boolean isNegative = number < 0 ? true : false;
        if(isNegative){
            number = number * -1;
        }
        int reverse = 0;
        int lastDigit = 0;

        while (number >= 1) {
            lastDigit = number %10;
            reverse = reverse * 10 +lastDigit;
            number = number / 10;
        }
        return isNegative == true? reverse*-1 : reverse;
         }
}