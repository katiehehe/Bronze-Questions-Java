import java.io.*;
import java.util.*;

public class Censor
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("censor.in"));
        PrintWriter pw = new PrintWriter("censor.out");

        String s = r.readLine();
        String c = r.readLine();

        /*
        if(s.equals(remove(s, c)))
            pw.println(s);
        else
        {
            boolean clear = false;
            while(!clear)
            {
                String s1 = remove(s, c);
                if(s.equals(s1))
                {
                    clear = true;
                }
                else
                {
                    s = s1;
                }
            }
            pw.println(s);
        }
         */

        /*
        String censored = "";
        for(int i = 0; i < s.length(); ++i)
        {
            censored += s.substring(i, i + 1);
            if(censored.length() >= c.length())
            {
                if((censored.substring(censored.length() - c.length())).equals(c))
                    censored = censored.substring(0, censored.length() - c.length());
            }
        }
        pw.println(censored);
        */

        StringBuilder censored = new StringBuilder();
        for(int i = 0; i < s.length(); ++i)
        {
            censored = censored.append(s.charAt(i));
            if(censored.length() >= c.length())
            {
                if((censored.substring(censored.length() - c.length())).equals(c))
                    censored.delete(censored.length() - c.length(), censored.length());
            }
        }
        pw.println(censored);
        pw.close();
    }

    /*
    @return The string that results when the first censored string is removed, if any
     */
    static String remove(String s, String c)
    {
        String newString = s;
        if(s.length() < c.length())
            return s;
        boolean found = false;
        for(int i = 0; i <= s.length() - c.length(); ++i)
        {
            if(!found)
            {
                boolean match = true;
                for (int j = i; j < i + c.length(); ++j)
                {
                    if(!(s.charAt(j) == c.charAt(j - i)))
                        match = false;
                }
                if(match)
                {
                    found = true;
                    newString = s.substring(0, i) + s.substring(i + c.length());
                }
            }
        }
        return newString;
    }
}
