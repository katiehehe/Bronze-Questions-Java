import java.io.*;
import java.util.*;
public class StuckInARut
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        ArrayList<int[]> nCow = new ArrayList<>();
        ArrayList<int[]> eCow = new ArrayList<>();
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            String s1 = s.nextToken();
            int x = Integer.parseInt(s.nextToken());
            int y = Integer.parseInt(s.nextToken());
            if(s1.equals("N"))
                nCow.add(new int[] {i, x, y});
            else
                eCow.add(new int[] {i, x, y});
        }
        nCow.sort(Comparator.comparingInt(x -> x[1]));
        eCow.sort(Comparator.comparingInt(x -> x[2]));

        int[] stopPos = new int[n];
        Arrays.fill(stopPos, -1);
        for(int[] north : nCow)
        {
            for(int[] east : eCow)
            {
                if(north[1] > east[1] && north[2] < east[2] && stopPos[east[0]] == -1)
                {
                    int distNorth = east[2] - north[2];
                    int distEast = north[1] - east[1];
                    if(distNorth < distEast)
                    {
                        stopPos[east[0]] = distEast;
                    }
                    else if(distEast < distNorth)
                    {
                        stopPos[north[0]] = distNorth;
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < n; ++i)
        {
            if(stopPos[i] == -1)
            {
                pw.println("Infinity");
            }
            else
            {
                pw.println(stopPos[i]);
            }
        }

        pw.close();
    }
}
