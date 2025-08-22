import java.io.*;
import java.util.*;
public class DaisyChains
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        StringTokenizer s = new StringTokenizer(r.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i)
        {
            arr[i] = Integer.parseInt(s.nextToken());
        }

        int count = 0;
        for(int i = 0; i < n; ++i)
        {
            for(int j = i; j < n; ++j)
            {
                int totalSum = 0;
                for(int k = i; k <= j; ++k)
                {
                    totalSum += arr[k];
                }
                for(int k = i; k <= j; ++k)
                {
                    if(arr[k] * (j - i + 1) == totalSum)
                    {
                        ++count;
                        break;
                    }
                }
            }
        }
        pw.println(count);
        pw.close();
    }
}
