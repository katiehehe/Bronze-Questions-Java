import java.io.*;
import java.util.*;
public class Pails
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter("pails.out");

        StringTokenizer s = new StringTokenizer(r.readLine());
        int X = Integer.parseInt(s.nextToken());
        int Y = Integer.parseInt(s.nextToken());
        int M = Integer.parseInt(s.nextToken());

        int empty = M;
        for(int i = 0; i <= M / X; ++i)
        {
            int remain = M - i * X;
            empty = Math.min(empty, remain % Y);
        }
        pw.println(M - empty);

        pw.close();
    }
}
