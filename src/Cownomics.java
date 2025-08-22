import java.io.*;
import java.util.*;
public class Cownomics
{
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter("cownomics.out");

        StringTokenizer s = new StringTokenizer(r.readLine());
        int cows = Integer.parseInt(s.nextToken());
        int genome = Integer.parseInt(s.nextToken());
        char[][] spotty = new char[cows][genome];
        char[][] plain = new char[cows][genome];

        for (int i = 0; i < cows; ++i)
        {
            String s1 = r.readLine();
            for(int j = 0; j < genome; ++j)
            {
                spotty[i][j] = s1.charAt(j);
            }
        }
        for (int i = 0; i < cows; ++i)
        {
            String s1 = r.readLine();
            for(int j = 0; j < genome; ++j)
            {
                plain[i][j] = s1.charAt(j);
            }
        }
        int count = 0;
        for(int i = 0; i < genome; ++i)
        {
            /*
            pw.print(!share(spotty, plain, i, 'A'));
            pw.print(!share(spotty, plain, i, 'T'));
            pw.print(!share(spotty, plain, i, 'C'));
            pw.println(!share(spotty, plain, i, 'G'));
             */
            if(!share(spotty, plain, i, 'A')
            && !share(spotty, plain, i, 'T')
            && !share(spotty, plain, i, 'C')
            && !share(spotty, plain, i, 'G'))
                ++count;
        }
        pw.println(count);

        pw.close();
    }
    static boolean share(char[][] spotty, char[][] plain, int column, char c)
    {
        boolean spottyHas = false;
        for(int i = 0; i < spotty.length; ++i)
        {
            if(spotty[i][column] == c)
                spottyHas = true;
        }
        boolean plainHas = false;
        for(int i = 0; i < plain.length; ++i)
        {
            if(plain[i][column] == c)
                plainHas = true;
        }
        if(spottyHas && plainHas)
            return true;
        return false;
    }
}
