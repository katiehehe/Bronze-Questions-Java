import java.io.*;
import java.util.*;

public class Test
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        pw.println(5 + "hi" + 3);

        pw.close();
    }
}