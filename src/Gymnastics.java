import java.io.*;
import java.util.*;
public class Gymnastics
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter("gymnastics.out");

        StringTokenizer s = new StringTokenizer(r.readLine());
        int K = Integer.parseInt(s.nextToken());
        int N = Integer.parseInt(s.nextToken());
        int[][] arr = new int[N][K];
        for(int i = 0; i < K; ++i)
        {
            StringTokenizer s1 = new StringTokenizer(r.readLine());
            for(int j = 0; j < N; ++j)
            {
                arr[Integer.parseInt(s1.nextToken()) - 1][i] = j;
            }
        }
        int consistent = 0;
        for(int i = 0; i < N; ++i)
        {
            for(int j = i + 1; j < N; ++j)
            {
                boolean same = true;
                boolean b = arr[i][0] > arr[j][0];
                for(int k = 0; k < K; ++k)
                {
                    if(arr[i][k] > arr[j][k] != b)
                    {
                        same = false;
                        break;
                    }
                }
                consistent += same ? 1 : 0;
            }
        }
        pw.println(consistent);

        pw.close();
    }
}
