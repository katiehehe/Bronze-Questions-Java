import java.io.*;
import java.util.*;
public class Shuffle
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] shuff = new int[n];
        int[] id = new int[n];
        StringTokenizer s = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; ++i)
        {
            shuff[i] = Integer.parseInt(s.nextToken()) - 1;
        }
        StringTokenizer s2 = new StringTokenizer(r.readLine());
        for(int i = 0; i < n; ++i)
        {
            int k = Integer.parseInt(s2.nextToken());
            id[i] = k;
        }
        for(int i = 0; i < 3; ++i)
        {
            int[] temp = new int[n];
            for(int j = 0; j < n; ++j)
            {
                temp[j] = id[shuff[j]];
            }
            id = temp;
        }
        for(int i = 0; i < n; ++i)
        {
            pw.println(id[i]);
        }
        pw.close();
    }
}
