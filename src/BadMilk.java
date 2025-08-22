import java.io.*;
import java.util.*;
public class BadMilk
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new FileReader("badmilk.in"));
        PrintWriter pw = new PrintWriter("badmilk.out");

        StringTokenizer s = new StringTokenizer(r.readLine());
        int cows = Integer.parseInt(s.nextToken());
        int milk = Integer.parseInt(s.nextToken());
        int drink = Integer.parseInt(s.nextToken());
        int sick = Integer.parseInt(s.nextToken());
        ArrayList<Drink>[] log = new ArrayList[cows];
        for(int i = 0; i < cows; ++i)
        {
            log[i] = new ArrayList<Drink>();
        }
        for(int i = 0; i < drink; ++i)
        {
            StringTokenizer s1 = new StringTokenizer(r.readLine());
            int index = Integer.parseInt(s1.nextToken()) - 1;
            log[index].add(new Drink(Integer.parseInt(s1.nextToken()), Integer.parseInt(s1.nextToken())));
        }
        Map<Integer, Integer> sickPeople = new HashMap<Integer, Integer>();
        for(int i = 0; i < sick; ++i)
        {
            StringTokenizer s2 = new StringTokenizer(r.readLine());
            sickPeople.put(Integer.parseInt(s2.nextToken()) - 1, Integer.parseInt(s2.nextToken()));
        }

        int max = 0;
        for(int i = 1; i <= milk; ++i)
        {
            int count = 0;
            boolean possible = true;
            for(Map.Entry<Integer, Integer> set : sickPeople.entrySet())
            {
                boolean thisSick = false;
                int person = set.getKey();
                int time = set.getValue();
                for(int j = 0; j < log[person].size(); ++j)
                {
                    Drink d = log[person].get(j);
                    if(d.drink == i && d.time < time)
                    {
                        thisSick = true;
                        break;
                    }
                }
                if(!thisSick)
                {
                    possible = false;
                    break;
                }
            }
            if(possible)
            {
                for(int j = 0; j < cows; ++j)
                {
                    for(int k = 0; k < log[j].size(); ++k)
                    {
                        if(log[j].get(k).drink == i)
                        {
                            ++count;
                            break;
                        }
                    }
                }
            }
            max = Math.max(count, max);
        }
        pw.println(max);

        pw.close();
    }

    static class Drink
    {
        int drink;
        int time;
        Drink(int drink, int time)
        {
            this.drink = drink;
            this.time = time;
        }
    }

}
