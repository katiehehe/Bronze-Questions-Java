import java.io.*;
import java.util.*;
public class Paint
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter("paint.out");

        StringTokenizer s = new StringTokenizer(r.readLine());
        int a = Integer.parseInt(s.nextToken());
        int b = Integer.parseInt(s.nextToken());
        StringTokenizer s1 = new StringTokenizer(r.readLine());
        int c = Integer.parseInt(s1.nextToken());
        int d = Integer.parseInt(s1.nextToken());

        if(c < a)
        {
            int cCopy = c;
            int dCopy = d;
            c = a;
            d = b;
            a = cCopy;
            b = dCopy;
        }

        if(c > b)
        {
            pw.println(b - a + d - c);
        }
        else if(d > b)
        {
            pw.println(d - a);
        }
        else
        {
            pw.println(b - a);
        }

        pw.close();
    }
}
