import java.io.*;
import java.util.*;

public class Square
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("square.in"));
        PrintWriter pw = new PrintWriter("square.out");

        StringTokenizer s = new StringTokenizer(r.readLine());
        int ax1 = Integer.parseInt(s.nextToken());
        int ay1 = Integer.parseInt(s.nextToken());
        int ax2 = Integer.parseInt(s.nextToken());
        int ay2 = Integer.parseInt(s.nextToken());
        StringTokenizer s2 = new StringTokenizer(r.readLine());
        int bx1 = Integer.parseInt(s2.nextToken());
        int by1 = Integer.parseInt(s2.nextToken());
        int bx2 = Integer.parseInt(s2.nextToken());
        int by2 = Integer.parseInt(s2.nextToken());

        int maxY = Math.max(ay2, by2);
        int minY = Math.min(ay1, by1);
        int maxX = Math.max(ax2, bx2);
        int minX = Math.min(ax1, bx1);

        int dim = Math.max(maxY - minY, maxX - minX);
        pw.println(dim * dim);

        pw.close();
    }
}
