import java.io.*;
import java.util.*;

public class MilkExchange
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer s = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(s.nextToken());
        long m = Long.parseLong(s.nextToken());

        s = new StringTokenizer(r.readLine());
        String pass = s.nextToken();
        long[] milk = new long[n];
        s = new StringTokenizer(r.readLine());
        long total = 0;
        long lost = 0;
        for(int i = 0; i < n; ++i)
        {
            milk[i] = Long.parseLong(s.nextToken());
            total += milk[i];
        }

        /*
        // if the 1st cow is increasing
        if(pass.charAt(n - 1) == 'R' && pass.charAt(1) == 'L')
        {
            long chain = 0;
            int index = 0;
            if(pass.charAt(0) == 'R')
            {
                index = n - 1;
                while(pass.charAt(index) == 'R')
                {
                    chain += milk[index];
                    --index;
                }
                lost += Math.min(chain, m);
            }
            else
            {
                index = 1;
                while(pass.charAt(index) == 'L')
                {
                    chain += milk[index];
                    ++index;
                }
                lost += Math.min(chain, m);
            }
        }
        // if the last cow is increasing
        if(pass.charAt(n - 2) == 'R' && pass.charAt(0) == 'L')
        {
            long chain = 0;
            int index = 0;
            if(pass.charAt(n - 1) == 'R')
            {
                index = n - 2;
                while(pass.charAt(index) == 'R')
                {
                    chain += milk[index];
                    --index;
                }
                lost += Math.min(chain, m);
            }
            else
            {
                index = 0;
                while(pass.charAt(index) == 'L')
                {
                    chain += milk[index];
                    ++index;
                }
                lost += Math.min(chain, m);
            }
        }
        */

        for(int i = 0; i < n; ++i)
        {
            long chain = 0;
            int index = 0;
            if(pass.charAt((i - 1 + n) % n) == 'R' && pass.charAt((i + 1 + n) % n) == 'L')
            {
                if(pass.charAt(i) == 'R')
                {
                    index = i - 1;
                    while(pass.charAt((index + n) % n) == 'R')
                    {
                        chain += milk[(index + n) % n];
                        --index;
                    }
                    lost += Math.min(chain, m);
                }
                else
                {
                    index = i + 1;
                    while(pass.charAt((index + n) % n) == 'L')
                    {
                        chain += milk[(index + n) % n];
                        ++index;
                    }
                    lost += Math.min(chain, m);
                }
            }
        }

        pw.println(total - lost);

        pw.close();
    }
}
