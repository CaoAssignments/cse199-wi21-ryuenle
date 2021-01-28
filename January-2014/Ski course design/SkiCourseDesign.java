import java.io.*;
import java.util.*;

public class SkiCourseDesign {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new FileReader(""));

        int n = Integer.parseInt(br.readLine());
        int[] hills = new int[n];
        for (int i = 0; i < n; i++) {
            hills[i]  = Integer.parseInt(br.readLine());
        }

        int min = MATH.MAX_VALUE; 

        for (int i = 0; i <= 100 - 17; i++) {
            int curr = 0; 
            for (int hill: hills) {
                if (hill < i) {
                    curr += Math.pow(i - hill, 2);
                }
                else if (hill > i+17) {
                    curr += Math.pow(hill - i, 2); 
                }
            }
            min = Math.min(min, curr); 
        }
        
        System.out.println(min);

    }
}