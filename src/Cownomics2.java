import java.io.*;
import java.util.*;
public class Cownomics2
{
    public static void main(String[] args) throws IOException
    {
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
            for(int j = i + 1; j < genome; ++j)
            {
                for(int k = j + 1; k < genome; ++k)
                {
                    Set<String> spottyGene = new HashSet<>();
                    Set<String> plainGene = new HashSet<>();
                    for(int l = 0; l < cows; ++l)
                    {
                        spottyGene.add(String.valueOf(spotty[l][i]) + String.valueOf(spotty[l][j]) + String.valueOf(spotty[l][k]));
                        plainGene.add(String.valueOf(plain[l][i]) + String.valueOf(plain[l][j]) + String.valueOf(plain[l][k]));
                    }
                    boolean share = false;
                    for(String str : spottyGene)
                    {
                        if(plainGene.contains(str))
                        {
                            share = true;
                        }
                    }
                    if(!share)
                        ++count;
                }
            }
        }
        pw.println(count);

        pw.close();
    }
}
