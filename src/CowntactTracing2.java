import java.io.*;
import java.util.*;
public class CowntactTracing2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer s = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(s.nextToken());
        String cows = r.readLine();

        ArrayList<Integer> arr = new ArrayList<>();
        int run = 0;
        int minRun = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i)
        {
            if (cows.charAt(i) == '1')
                ++run;
            else if (run > 0)
            {
                arr.add(run);
                run = 0;
            }
        }
        if (run > 0)
            arr.add(run);

        for (int i = 1; i < arr.size() - 1; ++i)
        {
            minRun = Math.min(minRun, arr.get(i));
        }
        if (arr.size() > 0)
        {
            // include things if needed
            if (cows.charAt(0) == '0')
                minRun = Math.min(minRun, arr.get(0));
            if (cows.charAt(n - 1) == '0')
                minRun = Math.min(minRun, arr.get(arr.size() - 1));

            int maxNights = (minRun - 1) / 2;

            // ends
            if (cows.charAt(0) == '1')
                maxNights = Math.min(maxNights, arr.get(0) - 1);
            if (cows.charAt(n - 1) == '1')
                maxNights = Math.min(maxNights, arr.get(arr.size() - 1) - 1);

            int minCows = 0;
            for (int i = 0; i < arr.size(); ++i)
            {
                minCows += (arr.get(i) - 1) / (2 * maxNights + 1) + 1;
            }
            pw.println(minCows);
        }
        else
            pw.println(0);

        pw.close();
    }
}
