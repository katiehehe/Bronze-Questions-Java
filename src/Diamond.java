import java.io.*;
import java.util.*;
public class Diamond
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter("diamond.out");

        StringTokenizer s = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(s.nextToken());
        int diff = Integer.parseInt(s.nextToken());
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i)
        {
            arr[i] = Integer.parseInt(r.readLine());
        }
        Arrays.sort(arr);

        if(diff >= arr[n - 1] - arr[0])
            pw.println(n);
        else
        {
            int max = 0;
            for(int i = arr[0]; i < arr[n - 1] - diff; ++i)
            {
                int count = 0;
                for(int j = 0; j < n; ++j)
                {
                    if(arr[j] >= i && arr[j] <= i + diff)
                        ++count;
                }
                max = Math.max(count, max);
            }
            pw.println(max);
        }

        pw.close();
    }
}
