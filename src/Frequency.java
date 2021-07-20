
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Frequency {
    private static Object output;

    public static void main(String[] args) throws IOException {
        File file = new File("..\\Numbers.txt");
        Scanner sc = new Scanner (file);
        File f = new File("..\\output.txt");
        FileWriter fw = new FileWriter(f);
        int n = 0;
        int[] responces = new int[100];

        try {
            while (sc.hasNextLine()){
                responces[n] = sc.nextInt();
                n++;
            }
        }
        catch(Exception e){}

        int frequency[] = new int[n];
        for (int i=0; i< n-1; i++){
            ++frequency[responces[i]];
        }
        System.out.printf("%s%10s\n", "Rating", "Frequency");
        fw.write("Rating Frequency\r\n");
        for(int i=1; i<n; i++){
            fw.write(i+"     "+responces[i]);
            fw.write("\r\n");
        }
        fw.close();
    }

}
