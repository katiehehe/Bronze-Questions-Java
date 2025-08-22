import java.io.*;
import java.util.*;

public class TeamTicTacToe
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter pw = new PrintWriter("tttt.out");

        int[][] arr = new int[3][3];
        for(int i = 0; i < 3; ++i)
        {
            String s = r.readLine();
            for(int j = 0; j < 3; ++j)
            {
                arr[i][j] = s.charAt(j) - 'A';
            }
        }
        /*
        for(int[] i : arr)
        {
            for(int j : i)
            {
                pw.print(j + " ");
            }
            pw.println();
        }
        */

        //individual victory count
        int indiv = 0;
        for(int i = 0; i < 26; ++i)
        {
            boolean b = false;
            //vertical and horizontal
            for(int j = 0; j < 3; ++j)
            {
                if((i == arr[j][0] && arr[j][0] == arr[j][1] && arr[j][1] == arr[j][2])
                || (i == arr[0][j] && arr[0][j] == arr[1][j] && arr[1][j] == arr[2][j]))
                    b = true;
            }
            //diagonal
            if(!b)
            {
                if((i == arr[0][0] && arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2])
                || (i == arr[2][0] && arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2]))
                    b = true;
            }
            if(b)
                ++indiv;
        }
        pw.println(indiv);

        //team victory count
        int team = 0;
        for(int i = 0; i < 25; ++i)
        {
            for(int j = i + 1; j < 26; ++j)
            {
                boolean b = false;
                //horizontal
                for(int k = 0; k < 3; ++k)
                {
                    boolean hori = true;
                    boolean horiSame = (arr[k][0] == arr[k][1] && arr[k][1] == arr[k][2]);
                    boolean vert = true;
                    boolean vertSame = (arr[0][k] == arr[1][k] && arr[1][k] == arr[2][k]);
                    for(int l = 0; l < 3; ++l)
                    {
                        if(arr[k][l] != i && arr[k][l] != j)
                            hori = false;
                        if(arr[l][k] != i && arr[l][k] != j)
                            vert = false;
                    }
                    if((hori && !horiSame) || (vert && !vertSame))
                        b = true;
                }
                //diagonal
                if(!b)
                {
                    boolean diag1 = true;
                    boolean diag1Same = arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2];
                    boolean diag2 = true;
                    boolean diag2Same = arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2];
                    if((arr[0][0] != i && arr[0][0] != j)
                    || (arr[1][1] != i && arr[1][1] != j)
                    || (arr[2][2] != i && arr[2][2] != j))
                        diag1 = false;
                    if((arr[0][2] != i && arr[0][2] != j)
                    || (arr[1][1] != i && arr[1][1] != j)
                    || (arr[2][0] != i && arr[2][0] != j))
                        diag2 = false;
                    if((diag1 && !diag1Same) || (diag2 && !diag2Same))
                        b = true;
                }
                if(b)
                {
                    ++team;
                    //pw.println(i + " " + j);
                }
            }
        }
        pw.println(team);

        pw.close();
    }
}
