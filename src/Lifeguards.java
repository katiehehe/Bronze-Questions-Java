import java.io.*;
import java.util.*;
public class Lifeguards
{
    public static void main(String[] args) throws IOException
    {
        final int N = 1000;

        BufferedReader r = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter("lifeguards.out");

        int n = Integer.parseInt(r.readLine());
        int[] time = new int[N];
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            int t1 = Integer.parseInt(s.nextToken());
            int t2 = Integer.parseInt(s.nextToken());
            arr[i][0] = t1;
            arr[i][1] = t2;
            for(int j = t1; j < t2; ++j)
            {
                ++time[j];
            }
        }
        int covered = 0;
        for(int i = 0; i < N; ++i)
        {
            if(time[i] > 0)
                ++covered;
        }

        int min = N;
        for(int i = 0; i < n; ++i)
        {
            int only = 0;
            int t1 = arr[i][0];
            int t2 = arr[i][1];
            for(int j = t1; j < t2; ++j)
            {
                if(time[j] == 1)
                    ++only;
            }
            min = Math.min(min, only);
        }
        pw.println(covered - min);

        pw.close();
    }
}
