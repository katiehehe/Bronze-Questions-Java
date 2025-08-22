import java.io.*;
import java.util.*;

public class Billboard
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter("billboard.out");

        int[][] arr = new int[3][4];
        for(int i = 0; i < 3; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            for(int j = 0; j < 4; ++j)
            {
                arr[i][j] = Integer.parseInt(s.nextToken());
            }
        }
        int yOverlap = Math.max(Math.min(arr[0][3], arr[2][3]) - Math.max(arr[0][1], arr[2][1]), 0);
        int xOverlap = Math.max(Math.min(arr[0][2], arr[2][2]) - Math.max(arr[0][0], arr[2][0]), 0);
        int area1 = yOverlap * xOverlap;

        int yOverlap2 = Math.max(Math.min(arr[1][3], arr[2][3]) - Math.max(arr[1][1], arr[2][1]), 0);
        int xOverlap2 = Math.max(Math.min(arr[1][2], arr[2][2]) - Math.max(arr[1][0], arr[2][0]), 0);
        int area2 = yOverlap2 * xOverlap2;

        int rect1 = (arr[0][2] - arr[0][0]) * (arr[0][3] - arr[0][1]);
        int rect2 = (arr[1][2] - arr[1][0]) * (arr[1][3] - arr[1][1]);

        pw.println(rect1 + rect2 - area1 - area2);

        pw.close();
    }
}
