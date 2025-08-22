import java.io.*;
import java.util.*;
public class Measurement_
{
    static class Update
    {
        public int day;
        public String cow;
        public int change;
        public Update(int day, String cow, int change)
        {
            this.day = day;
            this.cow = cow;
            this.change = change;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter("measurement.out");

        int n = Integer.parseInt(r.readLine());
        Update[] updates = new Update[n];
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            updates[i] = new Update(Integer.parseInt(s.nextToken()), s.nextToken(), Integer.parseInt(s.nextToken()));
        }
        Arrays.sort(updates, Comparator.comparingInt(x -> x.day));

        int[] outputs = new int[3];
        boolean[] picture = {true, true, true};
        int totalChanges = 0;

        for(Update u : updates)
        {
            if (u.cow.equals("Bessie"))
                outputs[0] += u.change;
            else if (u.cow.equals("Elsie"))
                outputs[1] += u.change;
            else
                outputs[2] += u.change;
            int maxOutput = 0;
            for(int i : outputs)
            {
                maxOutput = Math.max(i, maxOutput);
            }
            boolean[] newPicture = new boolean[3];
            for(int i = 0; i < 3; ++i)
            {
                if(outputs[i] == maxOutput)
                {
                    newPicture[i] = true;
                }
            }
            if(!Arrays.equals(picture, newPicture))
            {
                ++totalChanges;
            }
            picture = newPicture;
        }
        pw.println(totalChanges);
        pw.close();
    }
}
