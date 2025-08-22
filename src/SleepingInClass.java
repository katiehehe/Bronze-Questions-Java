import java.io.*;
import java.util.*;
public class SleepingInClass
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        for(int i = 0; i < n; ++i)
        {
            int N = Integer.parseInt(r.readLine());
            int[] arr = new int[N];
            Set<Integer> sums = new HashSet<>();
            StringTokenizer s = new StringTokenizer(r.readLine());
            arr[0] = Integer.parseInt(s.nextToken());
            sums.add(arr[0]);
            for(int j = 1; j < N; ++j)
            {
                arr[j] = arr[j - 1] + Integer.parseInt(s.nextToken());
                sums.add(arr[j]);
            }
            int totSum = arr[N - 1];
            if(totSum == 0)
            {
                pw.println(0);
            }
            else
            {
                /*
                for(int j = 0; j < N; ++j)
                {
                    pw.print(arr[j]);
                }
                pw.println();
                 */
                for(int j = 1; j <= totSum; ++j)
                {
                    if(totSum % j == 0)
                    {
                        //pw.println(j);
                        int numMults = totSum / j;
                        boolean b = true;
                        for(int k = 1; k <= numMults; ++k)
                        {
                            if(!sums.contains(k * j))
                            {
                                b = false;
                                break;
                            }
                        }
                        if(b)
                        {
                            pw.println(N - numMults);
                            break;
                        }
                    }
                }
            }
        }

        pw.close();
    }
}
