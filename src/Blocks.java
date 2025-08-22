import java.io.*;
import java.util.*;
public class Blocks
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        int[] arr = new int[26];
        for(int i = 0; i < n; ++i)
        {
            StringTokenizer s = new StringTokenizer(r.readLine());
            String s1 = s.nextToken();
            String s2 = s.nextToken();
            int[] arr1 = countFreq(s1);
            int[] arr2 = countFreq(s2);
            for(int j = 0; j < 26; ++j)
            {
                arr[j] += Math.max(arr1[j], arr2[j]);
            }
        }
        for(int i : arr)
            pw.println(i);

        pw.close();
    }

    /*
    @return An array of length 26, containing the frequency of each character in the given string.
     */
    static int[] countFreq(String s)
    {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); ++i)
        {
            arr[s.charAt(i) - 'a'] += 1;
        }
        return arr;
    }
}
