import java.io.*;
import java.util.*;
public class BCS
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("bcs.in"));
        PrintWriter pw = new PrintWriter("bcs.out");

        StringTokenizer s = new StringTokenizer(r.readLine());
        int dim = Integer.parseInt(s.nextToken());
        int n = Integer.parseInt(s.nextToken());
        int[][][] arr = new int[dim][dim][n];
        int[][] fig = new int[dim][dim];
        for(int i = 0; i < dim; ++i)
        {
            String s2 = r.readLine();
            for(int j = 0; j < dim; ++j)
            {
                if(s2.charAt(j) == '.')
                    fig[i][j] = 0;
                else
                    fig[i][j] = 1;
            }
        }
        /*
        for(int i = 0; i < dim; ++i)
        {
            for(int j = 0; j < dim; ++j)
            {
                pw.print(fig[i][j] + " ");
            }
            pw.println();
        }
         */
        for(int i = 0; i < n; ++i)
        {
            int[][] temp = new int[dim][dim];
            for(int j = 0; j < dim; ++j)
            {
                String s2 = r.readLine();
                for(int k = 0; k < dim; ++k)
                {
                    if(s2.charAt(k) == '.')
                        temp[j][k] = 0;
                    else
                        temp[j][k] = 1;
                }
            }
            arr[i] = temp;
        }

        for(int a = 0; a < n; ++a)
        {
            for(int b = a + 1; b < n; ++b)
            {
                boolean fits = false;

                int minX1 = dim - 1;
                int maxX1 = 0;
                int minY1 = dim - 1;
                int maxY1 = 0;
                int minX2 = dim - 1;
                int maxX2 = 0;
                int minY2 = dim - 1;
                int maxY2 = 0;
                for(int i = 0; i < dim; ++i) {
                    for (int j = 0; j < dim; ++j) {
                        if (arr[a][i][j] == 1) {
                            minX1 = Math.min(minX1, j);
                            maxX1 = Math.max(maxX1, j);
                            minY1 = Math.min(minY1, i);
                            maxY1 = Math.max(maxY1, i);
                        }
                        if (arr[b][i][j] == 1) {
                            minX2 = Math.min(minX2, j);
                            maxX2 = Math.max(maxX2, j);
                            minY2 = Math.min(minY2, i);
                            maxY2 = Math.max(maxY2, i);
                        }
                    }
                }

                //System.out.println(n);
                //System.out.println(minX1 + " " + maxX1 + " " + minY1 + " " + maxY1);
                //System.out.println(minX2 + " " + maxX2 + " " + minY2 + " " + maxY2);

                for(int i = (-1) * minX1; i < dim - maxX1; ++i)
                {
                    for(int j = (-1) * minY1; j < dim - maxY1; ++j)
                    {
                        for(int k = (-1) * minX2; k < dim - maxX2; ++k)
                        {
                            for(int l = (-1) * minY2; l < dim - maxY2; ++l)
                            {
                                boolean tempFits = true;
                                for(int y = 0; y < dim; ++y)
                                {
                                    for(int x = 0; x < dim; ++x)
                                    {
                                        boolean arr1Has = false;
                                        boolean arr2Has = false;
                                        if((x - i >= 0) && (x - i) < dim && (y - j) >= 0 && (y - j) < dim && arr[a][y - j][x - i] == 1)
                                            arr1Has = true;
                                        if((x - k >= 0) && (x - k < dim) && (y - l >= 0) && (y - l < dim) && arr[b][y - l][x - k] == 1)
                                            arr2Has = true;
                                        if(tempFits)
                                        {
                                            if(fig[y][x] == 1)
                                            {
                                                if(!(arr1Has || arr2Has) || (arr1Has && arr2Has))
                                                {
                                                    tempFits = false;
                                                    //System.out.println(arr1Has + " " + arr2Has);
                                                    //System.out.println(1 + " " + i + " " + j + " " + k + " " + l + " " + y + " " + x);
                                                }
                                            }
                                            else if(fig[y][x] == 0)
                                            {
                                                if(arr1Has || arr2Has)
                                                {
                                                    tempFits = false;
                                                    //System.out.println(0 + " " + i + " " + j + " " + k + " " + l + " " + y + " " + x);
                                                }
                                            }
                                        }
                                    }
                                }
                                if(tempFits)
                                    fits = true;
                            }
                        }
                    }
                }
                if(fits)
                {
                    int ind1 = a + 1;
                    int ind2 = b + 1;
                    pw.println(ind1 + " " + ind2);
                }
            }
        }
        pw.close();
    }

    private static boolean fit(int[][] arr1, int[][] arr2, int[][] piece, int n)
    {
        boolean fits = false;

        int minX1 = n - 1;
        int maxX1 = 0;
        int minY1 = n - 1;
        int maxY1 = 0;
        int minX2 = n - 1;
        int maxX2 = 0;
        int minY2 = n - 1;
        int maxY2 = 0;
        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (arr1[i][j] == 1) {
                    minX1 = Math.min(minX1, j);
                    maxX1 = Math.max(maxX1, j);
                    minY1 = Math.min(minY1, i);
                    maxY1 = Math.max(maxY1, i);
                }
                if (arr2[i][j] == 1) {
                    minX2 = Math.min(minX2, j);
                    maxX2 = Math.max(maxX2, j);
                    minY2 = Math.min(minY2, i);
                    maxY2 = Math.max(maxY2, i);
                }
            }
        }

        //System.out.println(n);
        //System.out.println(minX1 + " " + maxX1 + " " + minY1 + " " + maxY1);
        //System.out.println(minX2 + " " + maxX2 + " " + minY2 + " " + maxY2);

        for(int i = (-1) * minX1; i < n - maxX1; ++i)
        {
            for(int j = (-1) * minY1; j < n - maxY1; ++j)
            {
                for(int k = (-1) * minX2; k < n - maxX2; ++k)
                {
                    for(int l = (-1) * minY2; l < n - maxY2; ++l)
                    {
                        boolean tempFits = true;
                        for(int y = 0; y < n; ++y)
                        {
                            for(int x = 0; x < n; ++x)
                            {
                                boolean arr1Has = false;
                                boolean arr2Has = false;
                                if((x - i >= 0) && (x - i) < n && (y - j) >= 0 && (y - j) < n && arr1[y - j][x - i] == 1)
                                    arr1Has = true;
                                if((x - k >= 0) && (x - k < n) && (y - l >= 0) && (y - l < n) && arr2[y - l][x - k] == 1)
                                    arr2Has = true;
                                if(tempFits)
                                {
                                    if(piece[y][x] == 1)
                                    {
                                        if(!(arr1Has || arr2Has) || (arr1Has && arr2Has))
                                        {
                                            tempFits = false;
                                            //System.out.println(arr1Has + " " + arr2Has);
                                            //System.out.println(1 + " " + i + " " + j + " " + k + " " + l + " " + y + " " + x);
                                        }
                                    }
                                    else if(piece[y][x] == 0)
                                    {
                                        if(arr1Has || arr2Has)
                                        {
                                            tempFits = false;
                                            //System.out.println(0 + " " + i + " " + j + " " + k + " " + l + " " + y + " " + x);
                                        }
                                    }
                                }
                            }
                        }
                        if(tempFits)
                            fits = true;
                    }
                }
            }
        }

        //System.out.println(String.valueOf(fits));
        return fits;
    }
}
