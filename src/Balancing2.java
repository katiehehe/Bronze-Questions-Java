import java.io.*;
import java.util.*;
public class Balancing2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter("balancing.out");

        int n = Integer.parseInt(r.readLine());
        int minOfMax = n;
        Cow[] arr = new Cow[n];
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            int x = Integer.parseInt(s.nextToken());
            int y = Integer.parseInt(s.nextToken());
            arr[i] = new Cow(x,y);
        }
        Arrays.sort(arr, Comparator.comparingInt(k -> k.x));
        for(int i = 0; i < n; ++i)
        {
            ArrayList<Cow> below = new ArrayList<>();
            ArrayList<Cow> above = new ArrayList<>();
            for(int j = 0; j < n; ++j)
            {
                if(arr[j].y <= arr[i].y)
                {
                    below.add(arr[j]);
                }
                else
                    above.add(arr[j]);
            }
            int belowIndex = 0;
            int aboveIndex = 0;
            while (belowIndex < below.size() || aboveIndex < above.size())
            {
                int xBorder = Integer.MAX_VALUE;
                if(belowIndex < below.size())
                    xBorder = Math.min(xBorder, below.get(belowIndex).x);
                if(aboveIndex < above.size())
                    xBorder = Math.min(xBorder, above.get(aboveIndex).x);
                while(belowIndex < below.size() && below.get(belowIndex).x == xBorder)
                    ++belowIndex;
                while(aboveIndex < above.size() && above.get(aboveIndex).x == xBorder)
                    ++aboveIndex;
                minOfMax = Math.min(minOfMax, Math.max(Math.max(belowIndex, below.size() - belowIndex), Math.max(aboveIndex, above.size() - aboveIndex)));
            }
        }
        pw.println(minOfMax);
        pw.close();
    }

    static class Cow implements Comparable<Cow>
    {
        int x;
        int y;

        Cow(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Cow c)
        {
            return x - c.x;
        }
    }
}