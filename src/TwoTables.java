import java.io.*;
import java.util.*;
public class TwoTables
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        for(int i = 0; i < n; ++i) {
            StringTokenizer s = new StringTokenizer(r.readLine());
            int W1 = Integer.parseInt(s.nextToken());
            int H1 = Integer.parseInt(s.nextToken());
            StringTokenizer s2 = new StringTokenizer(r.readLine());
            int x1 = Integer.parseInt(s2.nextToken());
            int y1 = Integer.parseInt(s2.nextToken());
            int x2 = Integer.parseInt(s2.nextToken());
            int y2 = Integer.parseInt(s2.nextToken());
            StringTokenizer s3 = new StringTokenizer(r.readLine());
            int W2 = Integer.parseInt(s3.nextToken());
            int H2 = Integer.parseInt(s3.nextToken());

            int minX = Math.max(W2, x2 - x1);
            int maxX = W2 + x2 - x1;
            int minY = Math.max(H2, y2 - y1);
            int maxY = H2 + y2 - y1;
            boolean fitX = W1 >= maxX && H1 >= minY;
            boolean fitY = H1 >= maxY && W1 >= minX;
            if (fitX || fitY)
            {
                int minDist = Integer.MAX_VALUE;
                if(fitX)
                {
                    int moveXleft = Math.max(0, W2 - x1);
                    int moveXright = Math.max(0, x2 - W1 + W2);
                    int minMove = Math.min(moveXright, moveXleft);
                    minDist = Math.min(minDist, minMove);
                }
                if(fitY)
                {
                    int moveYbot = Math.max(0, H2 - y1);
                    int moveYtop = Math.max(0, y2 - H1 + H2);
                    int minMove = Math.min(moveYbot, moveYtop);
                    minDist = Math.min(minDist, minMove);
                }
                pw.println(minDist);
            }
            else
                pw.println(-1);
        }

        pw.close();
    }
}
