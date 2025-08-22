import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AppleDivision
{
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        n = Integer.parseInt(r.readLine());
        StringTokenizer s = new StringTokenizer(r.readLine());
        arr = new int[n];
        for(int i = 0; i < n; ++i)
        {
            arr[i] = Integer.parseInt(s.nextToken());
        }
        pw.println(recurseApples(1, arr[0], 0));
        pw.close();
    }

    static int recurseApples(int index, int sum1, int sum2)
    {
        if(index == n)
        {
            return Math.abs(sum1 - sum2);
        }
        return(Math.min(recurseApples(index + 1, sum1 + arr[index], sum2),
                        recurseApples(index + 1, sum1, sum2 + arr[index])));
    }
}
