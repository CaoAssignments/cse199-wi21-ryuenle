public class BessieSlowsDown {
    public static final int DESIRED_DISTANCE = 1000; 

    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new FileReader(""));

        int n = Integer.parseInt(br.readLine());
        int[] amount = new int[n];
        char[] timeDistance new char[n];

        for (int i = 0; i < n; i++) {
            timeDistance[i] = Integer.parseInt(br.readLine());
            amount[i]  = Integer.parseInt(br.readLine());
        }

        int currentSpeed = 1; 
        int currentDistance = 0; 
        int time = 0; 
        

        for (int i = 0; i < n; i++) {
            // Time
            if (timeDistance[i] == 'T') {
                currentDistance += currentSpeed * ()
            } 
            // Distance
            else {

            }
        }
    }
}