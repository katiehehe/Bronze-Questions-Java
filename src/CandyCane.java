import java.io.*;
import java.util.*;

public class CandyCane
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer s = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(s.nextToken());
        int m = Integer.parseInt(s.nextToken());
        long[] height = new long[n];

        StringTokenizer s2 = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; ++i)
        {
            height[i] = Long.parseLong(s2.nextToken());
        }
        StringTokenizer s3 = new StringTokenizer(r.readLine());
        for (int i = 0; i < m; ++i)
        {
            long bot = 0;
            long top = Long.parseLong(s3.nextToken());
            for (int j = 0; j < n; ++j)
            {
                if (bot < height[j])
                {
                    long eat = Math.min(height[j], top) - bot;
                    if (height[j] >= top)
                    {
                        height[j] += eat;
                        break;
                    }
                    else
                    {
                        bot = height[j];
                        height[j] += eat;
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i)
        {
            pw.println(height[i]);
        }

        pw.close();
    }
}
