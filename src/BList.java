import java.io.*;
import java.util.*;
public class BList
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        int[][] arr = new int[n][3];
        int start = 1000;
        int end = 1;
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            for(int j = 0; j < 3; ++j)
            {
                arr[i][j] = Integer.parseInt(s.nextToken());
            }
            if(arr[i][0] < start)
                start = arr[i][0];
            if(arr[i][1] > end)
                end = arr[i][1];
        }
        int[] buck = new int[end - start + 1];
        for(int i = 0; i < n; ++i)
        {
            for(int j = arr[i][0] - start; j <= arr[i][1] - start; ++j)
            {
                buck[j] += arr[i][2];
            }
        }
        int max = 0;
        for(int i = 0; i < end - start + 1; ++i)
        {
            if(buck[i] > max)
                max = buck[i];
        }
        pw.print(max);
        pw.close();
    }
}
