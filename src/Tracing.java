import java.io.*;
import java.util.*;
public class Tracing
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("tracing.in"));
        PrintWriter pw = new PrintWriter("tracing.out");

        //BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer s = new StringTokenizer(r.readLine());
        int cows = Integer.parseInt(s.nextToken());
        int numEntries = Integer.parseInt(s.nextToken());
        int[] real = new int[cows];
        String end = r.readLine();
        for(int i = 0; i < cows; ++i)
        {
            real[i] = end.charAt(i) - '0';

            //pw.println(real[i] + " ");

        }
        int[][] entries = new int[numEntries][3];
        for(int i = 0; i < numEntries; ++i)
        {
            StringTokenizer s1 = new StringTokenizer(r.readLine());
            for(int j = 0; j < 3; ++j)
            {
                entries[i][j] = Integer.parseInt(s1.nextToken());
            }
        }
        Arrays.sort(entries, Comparator.comparingInt(x -> x[0]));
        //int timeRange = entries[numEntries - 1][0] - entries[0][0];

        //pw.println(timeRange);

        int possN = 0;
        int minK = 250;
        int maxK = 0;
        for(int i = 0; i < cows; ++i)
        {
            if(real[i] == 0)
                continue;
            boolean possible = false;
            for(int K = 0; K <= numEntries; ++K)
            {
                int[] infectPower = new int[cows];
                int[] infectStatus = new int[cows];
                infectPower[i] = K;
                infectStatus[i] = 1;
                for (int j = 0; j < numEntries; ++j)
                {
                    int cow1 = entries[j][1] - 1;
                    int cow2 = entries[j][2] - 1;
                    if(infectPower[cow1] > 0 && infectPower[cow2] == 0)
                    {
                        if(infectStatus[cow2] == 0)
                        {
                            infectStatus[cow2] = 1;
                            infectPower[cow2] = K;
                        }
                        --infectPower[cow1];
                    }
                    else if(infectPower[cow2] > 0 && infectPower[cow1] == 0)
                    {
                        if(infectStatus[cow1] == 0)
                        {
                            infectStatus[cow1] = 1;
                            infectPower[cow1] = K;
                        }
                        --infectPower[cow2];
                    }
                    else if(infectPower[cow1] > 0 && infectPower[cow2] > 0)
                    {
                        --infectPower[cow1];
                        --infectPower[cow2];
                    }
                    /*
                    for(int x = 0; x < cows; ++x)
                    {
                        pw.print(infectStatus[x] + " ");
                    }
                    pw.println();
                    for(int x = 0; x < cows; ++x)
                    {
                        pw.print(infectPower[x] + " ");
                    }
                    pw.println();
                     */
                }

                /*
                pw.println("Cow: "  + i);
                pw.println(K);
                for(int x = 0; x < cows; ++x)
                {
                    pw.print(infectStatus[x] + " ");
                }
                pw.println(Arrays.equals(real, infectStatus));
                pw.println();
                */

                if(Arrays.equals(real, infectStatus))
                {
                    possible = true;
                    minK = Math.min(minK, K);
                    maxK = Math.max(maxK, K);
                }
            }
            possN += possible ? 1 : 0;
        }
        if(maxK == numEntries)
        {
            pw.print(possN + " " + minK + " " + "Infinity");
        }
        else
        {
            pw.print(possN + " " + minK + " " + maxK);
        } 

        pw.close();
    }
}
