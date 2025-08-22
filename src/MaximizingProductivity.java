import java.io.*;
import java.util.*;
public class MaximizingProductivity
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer s = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(s.nextToken());
        int q = Integer.parseInt(s.nextToken());

        s = new StringTokenizer(r.readLine());
        int[] close = new int[n];
        for(int i = 0; i < n; ++i)
        {
            close[i] = Integer.parseInt(s.nextToken());
        }

        s = new StringTokenizer(r.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i)
        {
            arr[i] = close[i] - Integer.parseInt(s.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i < q; ++i)
        {
            s = new StringTokenizer(r.readLine());
            int V = Integer.parseInt(s.nextToken());
            int S = Integer.parseInt(s.nextToken());

            if(S < arr[n - V])
                pw.println("YES");
            else
                pw.println("NO");
        }

        pw.close();
    }
}
