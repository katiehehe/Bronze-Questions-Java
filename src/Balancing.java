import java.io.*;
import java.util.*;
public class Balancing
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter("balancing.out");

        StringTokenizer s = new StringTokenizer(r.readLine());
        int cows = Integer.parseInt(s.nextToken());
        int max = Integer.parseInt(s.nextToken());
        int[][] arr = new int[cows][2];
        for(int i = 0; i < cows; ++i)
        {
            StringTokenizer s1 = new StringTokenizer(r.readLine());
            arr[i][0] = Integer.parseInt(s1.nextToken());
            arr[i][1] = Integer.parseInt(s1.nextToken());
        }
        /*
        Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));
        int[][] sortX = arr.clone();
        Arrays.sort(arr, Comparator.comparingInt(x -> x[1]));
        int[][] sortY = arr.clone();
         */

        int min = cows;
        for(int i = 0; i < cows; ++i)
        {
            for (int j = 0; j < cows; ++j)
            {
                int xLine = arr[i][0] + 1;
                int yLine = arr[j][1] + 1;
                int topLeft = 0;
                int topRight = 0;
                int botLeft = 0;
                int botRight = 0;
                for(int k = 0; k < cows; ++k)
                {
                    if(arr[k][0] < xLine && arr[k][1] > yLine)
                        ++topLeft;
                    else if(arr[k][0] > xLine && arr[k][1] > yLine)
                        ++topRight;
                    else if(arr[k][0] < xLine && arr[k][1] < yLine)
                        ++botLeft;
                    else if(arr[k][0] > xLine && arr[k][1] < yLine)
                        ++botRight;
                }
                int max1 = Math.max(topLeft, topRight);
                int max2 = Math.max(botLeft, botRight);
                int totMax = Math.max(max1, max2);
                min = Math.min(min, totMax);
            }
        }
        pw.println(min);

        pw.close();
    }
}
