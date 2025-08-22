import java.io.*;
import java.util.*;
public class Triangles
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter pw = new PrintWriter("triangles.out");

        int n = Integer.parseInt(r.readLine());
        Point[] arr = new Point[n];
        for (int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            arr[i] = new Point(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
        }
        /*
        for(int i = 0; i < n; ++i)
        {
            pw.println(arr[i].x + " " + arr[i].y);
        }
         */

        int max = 0;
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                for(int k = 0; k < n; ++k)
                {
                    //w.println(i + " " + j + " " + k);
                    if(arr[j].x == arr[i].x && arr[k].y == arr[i].y)
                    {
                        //pw.println(arr[j].x - arr[i].x);
                        //pw.println(arr[k].y - arr[i].y);
                        int area = Math.abs((arr[j].y - arr[i].y) * (arr[k].x - arr[i].x));
                        max = Math.max(max, area);
                        //pw.println(area);
                    }
                    else if(arr[j].y == arr[i].y && arr[k].x == arr[i].x)
                    {
                        //pw.println(arr[j].y - arr[i].y);
                        //pw.println(arr[k].x - arr[i].x);
                        int area = Math.abs((arr[j].x - arr[i].x) * (arr[k].y - arr[i].y));
                        max = Math.max(max, area);
                        //pw.println(area);
                    }
                }
            }
        }
        pw.println(max);

        pw.close();
    }

    static class Point
    {
        int x;
        int y;
        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
