package com.fresco;

import java.util.*;
import java.util.StringTokenizer;

public class Hashset
{
    public static String getOut(int numberOfMatches, String squads, int squad1, int squad2)
    {
        HashSet<String> hash  = new HashSet<String>();
        //write your code here
        StringTokenizer st = new StringTokenizer(squads,"#");
        int cnt=1;
        HashMap<Integer, HashSet<String>> mapp = new HashMap<Integer, HashSet<String>>();
        while (st.hasMoreTokens()) {
            String squad=st.nextToken();
            StringTokenizer st2 = new StringTokenizer(squad," ");
            HashSet<String> temp  = new HashSet<String>();
            while (st2.hasMoreTokens()) {
              String player=st2.nextToken();
              temp.add(player);
              hash.add(player);
            }
            mapp.put(cnt,temp);
            cnt++;
        }
        String allmatches="";
        String somematches="";

        for(String player:hash)
        {
          int flag=0;
          for(HashSet<String> squad:mapp.values())
          {
            if(!squad.contains(player))
            {
              flag=1;
              break;
            }
          }
          if(flag==0)
          allmatches+=player+" ";
        }
        for(String squady:mapp.get(squad2))
        {
          if(!mapp.get(squad1).contains(squady))
          somematches+=squady+" ";
        }
        System.out.println(numberOfMatches);
        System.out.println(squads);
        System.out.println(squad1);
        System.out.println(squad2);

        return allmatches+", "+somematches;
    }
}
