import java.io.*;
import java.util.*;
public class Lifeguards {
	public static void main(String[] args) throws IOException {


		for (int fileNum = 1; fileNum <= 10; fileNum++) {
            BufferedReader br = new BufferedReader(new FileReader("Tests/input/" + fileNum + ".in"));
            BufferedReader brO = new BufferedReader(new FileReader("Tests/output/" + fileNum + ".out"));
            
            // read in the information about the life guards
            int n = Integer.parseInt(br.readLine());
            int[] start = new int[n];
            int[] end = new int[n];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                start[i] = Integer.parseInt(st.nextToken());
                end[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("Number " + fileNum);
            System.out.println(brO.readLine());
            System.out.println(solve(n, start, end));
        }
    }

    public static int solve(int numLifeguards, int[] start, int[] end) {
        int[] shifts = new int[1000];
        for (int i = 0; i < numLifeguards; i++) {
            for (int j = start[i]; j < end[i]; j++) {
               shifts[j]++;
            }
        } 

        int maxHours = 0;

        for(int i = 0; i < numLifeguards; i++) {
            // Fire a cow
            for(int j = start[i]; j < end[i]; j++) {
                shifts[j]--;
            }

            int current = 0; 
            for (int j = 0; j < 1000; j++) {
                current += shifts[j] > 0 ? 1 : 0;
            }

            maxHours = Math.max(current, maxHours); 

            // Rehire the cow
            for(int j = start[i]; j < end[i]; j++) {
                shifts[j]++;
            }
        
        }

        return maxHours; 
    }
}