import java.io.*;
import java.util.*;
public class MaxDist
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        int[][] arr = new int[2][n];
        for(int j = 0; j < 2; ++j)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            for(int i = 0; i < n; ++i)
            {
                arr[j][i] = Integer.parseInt(s.nextToken());
            }
        }
        int maxDist = 0;
        for(int i = 0; i < n - 1; ++i)
        {
            for(int j = i + 1; j < n; ++j)
            {
                int dist = (arr[0][i] - arr[0][j]) * (arr[0][i] - arr[0][j]) + (arr[1][i] - arr[1][j]) * (arr[1][i] - arr[1][j]);
                maxDist = Math.max(maxDist, dist);
            }
        }
        pw.println(maxDist);

        pw.close();
    }
}
