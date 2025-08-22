import java.io.*;
import java.util.*;
public class Guess
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("guess.in"));
        PrintWriter pw = new PrintWriter("guess.out");

        int n = Integer.parseInt(r.readLine());
        ArrayList<HashSet<String>> rows = new ArrayList<HashSet<String>>();
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            s.nextToken();
            int k = Integer.parseInt(s.nextToken());
            rows.add(new HashSet<String>());
            for(int j = 0; j < k; ++j)
            {
                rows.get(i).add(s.nextToken());
            }
        }

        int maxYes = 0;
        for(int i = 0; i < n; ++i)
        {
            for(int j = i + 1; j < n; ++j)
            {
                int count = 0;
                for(String s : rows.get(i))
                {
                    if(rows.get(j).contains(s))
                    {
                        ++count;
                    }
                }
                maxYes = Math.max(count + 1, maxYes);
            }
        }
        pw.println(maxYes);

        pw.close();
    }
}
