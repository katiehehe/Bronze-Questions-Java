import java.io.*;
import java.util.*;
public class CountingLiars
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            if(s.nextToken().equals("G"))
            {
                arr[i][0] = 1;
            }
            else
            {
                arr[i][0] = 0;
            }
            arr[i][1] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(u -> u[1]));

        int maxTruth = 0;
        for(int i = 0; i < n; ++i)
        {
            int truth = 0;
            for(int j = 0; j < n; ++j)
            {
                if(j < i && arr[j][0] == 1)
                    ++truth;
                else if(j > i && arr[j][0] == 0)
                    ++truth;
                else if(arr[j][1] == arr[i][1])
                    ++truth;
            }
            maxTruth = Math.max(maxTruth, truth);
        }
        pw.println(n - maxTruth);

        /*
        int initial = 1;
        for(int i = 1; i < n; ++i)
        {
            if(arr[i][0] == 0 || arr[i][1] == arr[0][1])
                ++initial;
        }
        int maxTruth = initial;
        int currentTruth = initial;
        for(int i = 1; i < n; ++i)
        {
            if(arr[i - 1][1] == arr[i][1])
            {
                ++currentTruth;
                maxTruth = Math.max(maxTruth, currentTruth);
            }
            else if(arr[i - 1][0] == 1 && arr[i][0] == 1)
            {
                ++currentTruth;
                maxTruth = Math.max(maxTruth, currentTruth);
            }
            else if(arr[i - 1][0] == 0 && arr[i][0] == 0)
            {
                --currentTruth;
            }
        }
         */

        pw.close();
    }
}
