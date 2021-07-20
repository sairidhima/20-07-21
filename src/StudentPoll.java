import java.util.Formatter;
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class StudentPoll {
   public static void main(String[] args) throws IOException{
       Scanner poll = new Scanner(System.in);
   int n;
   System.out.println("Enter the number of respances size");
   n = poll.nextInt ();
   int responces[] = new int[n];
   int value;
       System.out.println("Enter the responces");
       for(int i=0; i<n; i++){
           value = poll.nextInt();
           if(value <= 5)
               responces[i] = value;
           else{
               System.out.println("Enter the rate between 0-5");
               i--;
           }
       }
       Formatter fr = new Formatter("..\\numbers.txt");
       for(int i=0; i<n; i++){
           if(i == 0)
               fr.format("%d", responces[i]);
           else
               fr.format("%d", responces[i]);

       }
       fr.close();
   }
}
