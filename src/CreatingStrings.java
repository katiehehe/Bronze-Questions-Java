import java.io.*;
import java.util.*;
public class CreatingStrings
{
    static Set<String> total;

    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String s = r.readLine();
        total = new HashSet<>();
        List<String> perms = new ArrayList<>();
        permutations("", s);
        pw.println(total.size());
        int n = total.size();
        List<String> list = new ArrayList<>();
        for(String x : total)
        {
            list.add(x);
        }
        Collections.sort(list);
        for(int i = 0; i < n; ++i)
        {
            pw.println(list.get(i));
        }

        pw.close();
    }

    static void permutations(String cur, String s)
    {
        if(s.length() == 0) {
            total.add(cur);
        }
        else {
            permutations(cur + s.substring(0, 1), s.substring(1));
            permutations(cur + s.substring(s.length() - 1, s.length()), s.substring(0, s.length() - 1));
            for (int i = 1; i < s.length() - 1; ++i) {
                permutations(cur + s.substring(i, i + 1),s.substring(0, i) + s.substring(i + 1, s.length()));
            }
        }
    }
}
