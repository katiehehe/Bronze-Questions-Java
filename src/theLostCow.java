import java.io.*;
import java.util.*;
public class theLostCow
{
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = y - x;
        int steps = 0;
        boolean b = false;

        int reach = 1;
        while(!b)
        {
            if(reach > 0)
            {
                if(d <= reach && d >= 0)
                {
                    steps += d;
                    pw.print(steps);
                    b = true;
                }
                else
                {
                    steps = steps + 2 * Math.abs(reach);
                    reach = (-2) * reach;
                }
            }
            else
            {
                if(d >= reach && d <= 0)
                {
                    steps += Math.abs(d);
                    pw.print(steps);
                }
                else
                {
                    steps = steps + 2 * Math.abs(reach);
                    reach = (-2) * reach;
                }
            }
        }


        /*int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        pw.print("The sum of these three numbers is ");
        pw.println(a + b + c);
        */
        pw.close();
    }
}
