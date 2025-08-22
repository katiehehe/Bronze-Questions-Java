import java.io.*;
import java.util.*;
public class PalindromeGame
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer s = new StringTokenizer(r.readLine());
        long n = Long.parseLong(s.nextToken());
        for(int i = 0; i < n; ++i)
        {
            s = new StringTokenizer(r.readLine());
            String num = s.nextToken();
            if(num.charAt(num.length() - 1) == '0')
                pw.println("E");
            else
                pw.println("B");
        }
        pw.close();
    }
}
