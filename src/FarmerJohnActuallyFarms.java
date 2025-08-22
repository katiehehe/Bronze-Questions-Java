import java.io.*;
import java.util.*;

public class FarmerJohnActuallyFarms
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer s = new StringTokenizer(r.readLine());
        int t = Integer.parseInt(s.nextToken());
        for (int j = 0; j < t; ++j)
        {
            s = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(s.nextToken());
            long[][] arr = new long[n][3];
            s = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; ++i)
            {
                arr[i][1] = Long.parseLong(s.nextToken());
            }
            s = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; ++i)
            {
                arr[i][2] = Long.parseLong(s.nextToken());
            }
            s = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; ++i)
            {
                arr[i][0] = Long.parseLong(s.nextToken());
            }
            Arrays.sort(arr, Comparator.comparingLong(a -> a[0]));

            long minDay = 0;
            long maxDay = Long.MAX_VALUE;
            boolean possible = true;
            for (int i = 0; i < n - 1; ++i)
            {
                if (arr[i][2] > arr[i + 1][2])
                {
                    if (arr[i + 1][1] > arr[i][1])
                    {
                        minDay = Math.max(minDay, (arr[i + 1][1] - arr[i][1]) / (arr[i][2] - arr[i + 1][2]) + 1);
                        // pw.println("new minimum " + minDay);
                    }
                }
                else if (arr[i][2] == arr[i + 1][2])
                {
                    if (arr[i + 1][1] >= arr[i][1])
                    {
                        // pw.println("Same slope -> impossible");
                        possible = false;
                        break;
                    }
                }
                else if (arr[i][2] < arr[i + 1][2])
                {
                    if (arr[i + 1][1] >= arr[i][1])
                    {
                        // pw.println("smaller slope and smaller plant -> impossible");
                        possible = false;
                        break;
                    }
                    maxDay = Math.min(maxDay, (arr[i][1] - arr[i + 1][1] - 1) / (arr[i + 1][2] - arr[i][2]));
                    // pw.println("new maximum " + maxDay);
                    if (maxDay < minDay)
                    {
                        // pw.println("maximum is less than minimum");
                        possible = false;
                        break;
                    }
                }
            }
            if (possible)
                pw.println(minDay);
            else
                pw.println(-1);
        }

        pw.close();
    }
}