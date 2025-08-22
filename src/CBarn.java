import java.io.*;
import java.util.*;

public class CBarn
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter("cbarn.out");

        int n = Integer.parseInt(r.readLine());
        int[] circ = new int[n];
        int best = 10000;
        for(int i = 0; i < n; ++i)
        {
            circ[i] = Integer.parseInt(r.readLine());
        }
        for(int i = 0; i < n; ++i)
        {
            int total = 0;
            for(int j = 0; j < n; ++j)
            {
                total += j * circ[(i + j) % n];
            }
            if(total < best)
            {
                best = total;
            }
        }
        pw.println(best);
        pw.close();
    }
}


