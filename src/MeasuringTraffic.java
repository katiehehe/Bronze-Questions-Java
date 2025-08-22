import java.io.*;
import java.util.*;
public class MeasuringTraffic
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            String k = s.nextToken();
            if(k.equals("on"))
                arr[i][0] = 1;
            else if(k.equals("none"))
                arr[i][0] = 0;
            else
                arr[i][0] = -1;
            arr[i][1] = Integer.parseInt(s.nextToken());
            arr[i][2] = Integer.parseInt(s.nextToken());
        }

        int firstNone = 0;
        while(arr[firstNone][0] != 0)
            ++firstNone;
        int priorLow = arr[firstNone][1];
        int priorHigh = arr[firstNone][2];
        for(int i = firstNone; i < n - 1; ++i)
        {
            if(arr[i + 1][0] == 0)
            {
                priorLow = Math.max(priorLow, arr[i + 1][1]);
                priorHigh = Math.min(priorHigh, arr[i + 1][2]);
            }
            else if(arr[i + 1][0] == 1)
            {
                priorLow = priorLow + arr[i + 1][1];
                priorHigh = priorHigh + arr[i + 1][2];
            }
            else
            {
                priorLow = priorLow - arr[i + 1][2];
                priorHigh = priorHigh - arr[i + 1][1];
                priorLow = Math.max(0, priorLow);
            }
        }

        int lastNone = n - 1;
        while(arr[lastNone][0] != 0)
            --lastNone;
        int lastLow = arr[lastNone][1];
        int lastHigh = arr[lastNone][2];
        for(int i = lastNone; i > 0; --i)
        {
            if(arr[i - 1][0] == 0)
            {
                lastLow = Math.max(lastLow, arr[i - 1][1]);
                lastHigh = Math.min(lastHigh, arr[i - 1][2]);
            }
            else if(arr[i - 1][0] == 1)
            {
                lastLow = lastLow - arr[i - 1][2];
                lastHigh = lastHigh - arr[i - 1][1];
                lastLow = Math.max(0, lastLow);
            }
            else
            {
                lastLow = lastLow + arr[i - 1][1];
                lastHigh = lastHigh + arr[i - 1][2];
            }
        }
        pw.println(lastLow + " " + lastHigh);
        pw.print(priorLow + " " + priorHigh);

        pw.close();
    }
}
