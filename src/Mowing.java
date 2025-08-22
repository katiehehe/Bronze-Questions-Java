import java.io.*;
import java.util.*;

public class Mowing
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter pw = new PrintWriter("mowing.out");

        int n = Integer.parseInt(r.readLine());
        int[][] arr = new int[n][2];
        int steps = 0;
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            String k = s.nextToken();
            if(k.equals("N"))
                arr[i][0] = 1;
            else if(k.equals("E"))
                arr[i][0] = 2;
            else if(k.equals("S"))
                arr[i][0] = 3;
            else
                arr[i][0] = 4;
            String m = s.nextToken();
            arr[i][1] = Integer.parseInt(m);
            steps += Integer.parseInt(m);
        }
        int[][] trail = new int[steps + 1][2];
        trail[0][0] = 0;
        trail[0][1] = 0;
        int t = 0;
        for(int i = 0; i < n; ++i)
        {
            if(arr[i][0] == 1)
            {
                for(int j = 1; j <= arr[i][1]; ++j)
                {
                    trail[t + j][0] = trail[t][0];
                    trail[t + j][1] = trail[t][1] + j;
                }
            }
            else if(arr[i][0] == 2)
            {
                for(int j = 1; j <= arr[i][1]; ++j)
                {
                    trail[t + j][0] = trail[t][0] + j;
                    trail[t + j][1] = trail[t][1];
                }
            }
            else if(arr[i][0] == 3)
            {
                for(int j = 1; j <= arr[i][1]; ++j)
                {
                    trail[t + j][0] = trail[t][0];
                    trail[t + j][1] = trail[t][1] - j;
                }
            }
            else
            {
                for(int j = 1; j <= arr[i][1]; ++j)
                {
                    trail[t + j][0] = trail[t][0] - j;
                    trail[t + j][1] = trail[t][1];
                }
            }
            t += arr[i][1];
        }
        int grow = Integer.MAX_VALUE;
        boolean hit = false;
        for(int i = 1; i < steps + 1; ++i)
        {
            for(int j = 0; j < i; ++j)
            {
                if(trail[i][0] == trail[j][0] && trail[i][1] == trail[j][1])
                {
                    hit = true;
                    grow = Math.min(grow, i - j);
                }
            }
        }
        if(!hit)
            grow = -1;
        pw.println(grow);
        pw.close();
    }
}
