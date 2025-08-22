import javax.swing.*;
import java.io.*;
import java.util.*;

public class Billboard2
{
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter("billboard.out");

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

        int maxY = Math.min(ay2, by2);
        int minY = Math.max(ay1, by1);
        int maxX = Math.min(ax2, bx2);
        int minX = Math.max(ax1, bx1);
        int areaLawn = (ax2 - ax1) * (ay2 - ay1);
        int areaOverlap = (maxY - minY) * (maxX - minX);

        if (maxY - minY <= 0 || maxX - minX <= 0)
        {
            pw.println((ax2 - ax1) * (ay2 - ay1));
        }
        else if (((minY == ay1) && (maxX == ax2) && (maxY == ay2)))
        {
            pw.println(areaLawn - areaOverlap);
        }
        else if (((minX == ax1) && (maxX == ax2) && (maxY == ay2)))
        {
            pw.println(areaLawn - areaOverlap);
        }
        else if (((minX == ax1) && (minY == ay1) && (maxY == ay2)))
        {
            pw.println(areaLawn - areaOverlap);
        }
        else if (((minX == ax1) && (minY == ay1) && (maxX == ax2)))
        {
            pw.println(areaLawn - areaOverlap);
        }
        else
        {
            pw.println(areaLawn);
        }

        pw.close();
    }
}
