import java.io.*;
import java.util.*;
public class WhiteSheet
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer s3 = new StringTokenizer(r.readLine());
        int wx1 = Integer.parseInt(s3.nextToken());
        int wy1 = Integer.parseInt(s3.nextToken());
        int wx2 = Integer.parseInt(s3.nextToken());
        int wy2 = Integer.parseInt(s3.nextToken());
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

        //pw.println(wx2 - wx1);
        //pw.println(wy2 - wy1);
        long whiteArea = ((long)wx2 - (long)wx1) * ((long)wy2 - (long)wy1);
        boolean aOverlap = overlap(wx1, wy1, wx2, wy2, ax1, ay1, ax2, ay2);
        boolean bOverlap = overlap(wx1, wy1, wx2, wy2, bx1, by1, bx2, by2);
        //pw.println(whiteArea);
        //pw.println(aOverlap);
        //pw.println(bOverlap);

        if(aOverlap && bOverlap)
        {
            int aOx1 = Math.max(ax1, wx1);
            int aOy1 = Math.max(ay1, wy1);
            int aOx2 = Math.min(ax2, wx2);
            int aOy2 = Math.min(ay2, wy2);

            int bOx1 = Math.max(bx1, wx1);
            int bOy1 = Math.max(by1, wy1);
            int bOx2 = Math.min(bx2, wx2);
            int bOy2 = Math.min(by2, wy2);

            long whiteOverlap = (long)Math.max(0, Math.min(aOy2, bOy2) - Math.max(aOy1, bOy1)) * (long)Math.max(0, Math.min(aOx2, bOx2) - Math.max(aOx1, bOx1));
            long totalArea = (long)(aOx2 - aOx1) * (long)(aOy2 - aOy1) + (long)(bOx2 - bOx1) * (long)(bOy2 - bOy1) - whiteOverlap;
            if(whiteArea > totalArea)
                pw.println("YES");
            else
                pw.println("NO");
        }
        else if(aOverlap)
        {
            int aOx1 = Math.max(ax1, wx1);
            int aOy1 = Math.max(ay1, wy1);
            int aOx2 = Math.min(ax2, wx2);
            int aOy2 = Math.min(ay2, wy2);

            long totalArea = (long)(aOx2 - aOx1) * (long)(aOy2 - aOy1);
            //pw.println(totalArea);
            if(whiteArea > totalArea)
                pw.println("YES");
            else
                pw.println("NO");
        }
        else if(bOverlap)
        {
            int bOx1 = Math.max(bx1, wx1);
            int bOy1 = Math.max(by1, wy1);
            int bOx2 = Math.min(bx2, wx2);
            int bOy2 = Math.min(by2, wy2);

            long totalArea = (long)(bOx2 - bOx1) * (long)(bOy2 - bOy1);
            if(whiteArea > totalArea)
                pw.println("YES");
            else
                pw.println("NO");
        }
        else
        {
            pw.println("YES");
        }
        pw.close();
    }

    static boolean overlap(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2)
    {
        int yTop = Math.min(ay2, by2);
        int yBot = Math.max(ay1, by1);
        int xRight = Math.min(ax2, bx2);
        int xLeft = Math.max(ax1, bx1);

        if(yTop > yBot && xRight > xLeft)
            return true;
        return false;
    }
}
