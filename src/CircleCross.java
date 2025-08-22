import java.io.*;
import java.util.*;
public class CircleCross
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter("circlecross.out");

        String s = r.readLine();
        int[] arr = new int[52];
        for(int i = 0; i < 52; ++i)
        {
            arr[i] = s.charAt(i) - 'A';
        }

        int count = 0;
        for(int i = 0; i < 26; ++i)
        {
            for(int j = i + 1; j < 26; ++j)
            {
                int firstI = -1;
                boolean sawI = false;
                int firstJ = -1;
                boolean sawJ = false;
                int secondI = -1;
                int secondJ = -1;
                for(int k = 0; k < 52; ++k)
                {
                    if(arr[k] == i && !sawI)
                    {
                        firstI = k;
                        sawI = true;
                    }
                    else if(arr[k] == i && sawI)
                    {
                        secondI = k;
                    }
                    else if(arr[k] == j && !sawJ)
                    {
                        firstJ = k;
                        sawJ = true;
                    }
                    else if(arr[k] == j && sawJ)
                    {
                        secondJ = k;
                    }
                }
                if(firstI < firstJ && firstJ < secondI && secondI < secondJ)
                    ++count;
                else if(firstJ < firstI && firstI < secondJ && secondJ < secondI)
                    ++count;
            }
        }
        pw.println(count);

        pw.close();
    }
}
