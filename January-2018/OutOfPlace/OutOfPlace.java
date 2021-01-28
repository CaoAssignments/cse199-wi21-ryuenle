import java.io.*;
import java.util.*;
public class OutOfPlace {
	public static void main(String[] args) throws IOException {


		for (int fileNum = 1; fileNum <= 10; fileNum++) {
            BufferedReader br = new BufferedReader(new FileReader("Tests/input/" + fileNum + ".in"));
            BufferedReader brO = new BufferedReader(new FileReader("Tests/output/" + fileNum + ".out"));
            
            // read in the information about the life guards
            int n = Integer.parseInt(br.readLine());
            int[] cows = new int[n];
            for(int i = 0; i < n; i++) {
                cows[i] = Integer.parseInt(br.readLine());
            }

            System.out.println("Number " + fileNum);
            System.out.println(brO.readLine());
            System.out.println(solve(n, cows));
        }
    }

    public static int solve(int numCows, int[] cows) {

        int bessieLocation = -1;
        int bessieValue = 0; 
        boolean forward = false;

        for (int i = 0; i < numCows - 1; i++) {
            if (cows[i] > cows[i+1]) {
                if (i == numCows - 2) {
                    bessieLocation = i + 1;
                    bessieValue = cows[i + 1];
                    forward = false; 
                } else if (cows[i] > cows[i + 2]) {
                    bessieLocation = i;
                    bessieValue = cows[i];
                    forward = true;
                } else {
                    bessieLocation = i + 1;
                    bessieValue = cows[i+1];
                    forward = false;
                }
                break;
            }
        }
        
        int currentLocation = bessieLocation;
        if (forward) {
            currentLocation++;
            while (currentLocation < numCows) {
                if (bessieValue > cows[currentLocation]) {
                    currentLocation++;
                } else {
                    break;
                }
            }
        } else {
            currentLocation--;
            while (currentLocation >= 0) {
                if (bessieValue < cows[currentLocation]) {
                    currentLocation--;
                } else {
                    break;
                }
            }
        }  

        currentLocation = Math.min(currentLocation, numCows-1);
        currentLocation = Math.max(currentLocation, 0);
        int numSwaps = Math.abs(currentLocation - bessieLocation);

        int start = Math.min(currentLocation, bessieLocation);
        int end = Math.max(currentLocation, bessieLocation);

        for (int i = start; i < end - 1; i++) {
            if (cows[i] == cows[i+1]) numSwaps--;
        }

        return --numSwaps;
    }
}
