import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Point;

public class BlockedBillboardII {

    public static void main(String[] args) {

        try {
            for (int i = 1; i <= 10; i++) {
                File file = new File("Tests/input/" + i + ".in");
                Scanner scan = new Scanner(file);

                String data = scan.nextLine();
                String[] firstRect = data.split(" ", 4);
                int[] arr1 = new int[4];
                for (int j = 0; j < firstRect.length; j++) {
                    arr1[j] = Integer.parseInt(firstRect[j]);
                }

                data = scan.nextLine();
                String[] secondRect = data.split(" ", 4);

                int[] arr2 = new int[4];
                for (int j = 0; j < firstRect.length; j++) {
                    arr2[j] = Integer.parseInt(secondRect[j]);
                }

                File out = new File("Tests/output/" + i + ".out");
                Scanner outScan = new Scanner(out);
                String output = outScan.nextLine();

                System.out.println("Number " + i);
                System.out.println(solve(arr1, arr2));
                System.out.println(output);

                scan.close();
                outScan.close();
            }

        } catch( FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static int solve(int[] unwanted, int[] wanted) {
        Point badBottomLeft = new Point(unwanted[0], unwanted[1]);
        Point badTopRight = new Point(unwanted[2], unwanted[3]);
        Point goodBottomLeft = new Point(wanted[0], wanted[1]);
        Point goodTopRight = new Point(wanted[2], wanted[3]);

        int badHeight = (badTopRight.y - badBottomLeft.y);
        int badWidth = (badTopRight.x - badBottomLeft.x);
        int area = badHeight * badWidth;

        if (goodTopRight.y >= badTopRight.y && goodBottomLeft.y <= badBottomLeft.y) {
          if (goodTopRight.x >= badTopRight.x && goodBottomLeft.x <= badBottomLeft.x) area = 0;
          else if (goodTopRight.x <= badTopRight.x && goodBottomLeft.x >= badBottomLeft.x) return area;

          else if (badBottomLeft.x < goodBottomLeft.x) {
            area = (goodBottomLeft.x - badBottomLeft.x) * badHeight;
          }
          else {
            area = (badTopRight.x - goodTopRight.x) * badHeight;
          }
        }
        else if (goodTopRight.x >= badTopRight.x && goodBottomLeft.x <= badBottomLeft.x) {
          if(badTopRight.y >= goodTopRight.y && goodBottomLeft.y >= badBottomLeft.y) return area;

          else if (badTopRight.y > goodTopRight.y) {
            area = (badTopRight.y - goodTopRight.y) * badWidth;
          }
          else {
            area = (goodBottomLeft.y - badBottomLeft.y) * badWidth;
          }
        }
        return area;
    }
}
