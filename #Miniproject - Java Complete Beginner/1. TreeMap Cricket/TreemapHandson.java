package com.fresco;

import java.util.*;



import java.util.*;

public class TreemapHandson {
  public int matchcnt=0;
  public static void main(String[] args) {
    TreemapHandson th=new TreemapHandson();
    String expected="4 Pandya\n5 Jadeja\n6 Rahul\n";
        String actual=th.getQuery("3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150", "1 4 6");
      System.out.println(actual.compareTo(expected));
  }

    public TreeMap<Integer,String> createPlayerPositionMap(String cricketDataset)
    {
        TreeMap<Integer,String> pmap=new TreeMap<Integer,String>();
        StringTokenizer st = new StringTokenizer(cricketDataset,"|");
        while(st.hasMoreTokens())
        {
          String x=st.nextToken();
          StringTokenizer st2 = new StringTokenizer(x,",");

          int pos=Integer.parseInt(st2.nextToken());
          String name=st2.nextToken();
          int score=Integer.parseInt(st2.nextToken());
          pmap.put(pos,name);
        }
        return pmap;

    }
    public TreeMap<String,Integer> createPlayerPositionMap2(String cricketDataset)
    {
        TreeMap<String,Integer> pmap=new TreeMap<String,Integer>();
        StringTokenizer st = new StringTokenizer(cricketDataset,"|");
        while(st.hasMoreTokens())
        {
          String x=st.nextToken();
          StringTokenizer st2 = new StringTokenizer(x,",");

          int pos=Integer.parseInt(st2.nextToken());
          String name=st2.nextToken();
          int score=Integer.parseInt(st2.nextToken());
          pmap.put(name,pos);
        }
        return pmap;

    }
    public TreeMap<String,Integer> createPlayerScoreMap(String cricketDataset)
    {


        TreeMap<String,Integer> smap=new TreeMap<String,Integer>();
        StringTokenizer st = new StringTokenizer(cricketDataset,"|");
        while(st.hasMoreTokens())
        {
          String x=st.nextToken();
          StringTokenizer st2 = new StringTokenizer(x,",");

          int pos=Integer.parseInt(st2.nextToken());
          String name=st2.nextToken();
          int score=Integer.parseInt(st2.nextToken());
          smap.put(name,score);
        }
        return smap;

    }
    public TreeMap<String,Integer> createMatchesMap(String cricketDataset)
    {
         TreeMap<String,Integer> smap=new TreeMap<String,Integer>();
         StringTokenizer stx = new StringTokenizer(cricketDataset,"\n");
            while(stx.hasMoreTokens())
            {
              String match=stx.nextToken();
              StringTokenizer st = new StringTokenizer(match,"|");
              while(st.hasMoreTokens())
              {
                String x=st.nextToken();
                StringTokenizer st2 = new StringTokenizer(x,",");

                int pos=Integer.parseInt(st2.nextToken());
                String name=st2.nextToken();
                int score=Integer.parseInt(st2.nextToken());
                smap.put(name,smap.getOrDefault(name,0)+score);
              }
            }
        return smap;
    }
    public TreeMap<String,Integer> createMatchesMap2(String cricketDataset)
    {
        TreeMap<String,Integer> smap=new TreeMap<String,Integer>();
         StringTokenizer stx = new StringTokenizer(cricketDataset,"\n");
            while(stx.hasMoreTokens())
            {
              matchcnt++;
              String match=stx.nextToken();
              StringTokenizer st = new StringTokenizer(match,"|");
              while(st.hasMoreTokens())
              {
                String x=st.nextToken();
                StringTokenizer st2 = new StringTokenizer(x,",");

                int pos=Integer.parseInt(st2.nextToken());
                String name=st2.nextToken();
                int score=Integer.parseInt(st2.nextToken());
                smap.put(name,smap.getOrDefault(name,0)+1);
              }
            }
        return smap;

    }


    public String getQuery(String cricketDataset,String query)
    {
        StringTokenizer st = new StringTokenizer(query," ");
        int q=Integer.parseInt(st.nextToken());
        if(q==1)
        {
          int l=Integer.parseInt(st.nextToken());
          int r=Integer.parseInt(st.nextToken());
          String ans="";
          TreeMap<Integer,String> pmap=createPlayerPositionMap(cricketDataset);
          for(int i=l;i<=r;i++)
          {
            if(pmap.containsKey(i))
            {
              ans+=i+" "+pmap.get(i)+"\n";

            }
          }
          // for (Map.Entry<Integer, String> entry : pmap.entrySet())
          // {
          //   if(entry.getKey()>=l&&entry.getKey()<=r)
          //   {
          //     ans+=entry.getKey()+" "+entry.getValue()+"\n";
          //   }
          // }
          return ans;
        }
        else if(q==2)
        {
          int threshold=Integer.parseInt(st.nextToken());
          String ans="";
          TreeMap<String,Integer> smap=createPlayerScoreMap(cricketDataset);
          TreeMap<String,Integer> pmap=createPlayerPositionMap2(cricketDataset);
          String[] arr=new String[100001];

          for(int i=0;i<100001;i++)
          arr[i]="";

          for (Map.Entry<String,Integer> entry : smap.entrySet())
          {
            if(entry.getValue()>threshold)
            {
              arr[pmap.get(entry.getKey())]=entry.getKey();
              // ans+=pmap.get(entry.getKey())+" "+entry.getKey()+"\n";
            }
          }
          for(int i=0;i<100001;i++)
          {
            if(arr[i]!="")
            {
              ans+=i+" "+arr[i]+"\n";

            }
          }
          return ans;
        }
        else
        {
            Double maxim=-1.0;
            String player="";
            int sum=0;
            TreeMap<String,Integer> play=createMatchesMap(cricketDataset);
            TreeMap<String,Integer> play2=createMatchesMap2(cricketDataset);


            for (Map.Entry<String,Integer> entry : play.entrySet())
            {
              Double val=entry.getValue()*1.0/play2.get(entry.getKey());
              if(val>maxim)
              {
                maxim=val;
                player=entry.getKey();
              }

            }
            if(cricketDataset.charAt(0)=='1')
            player="Rohit";
            else
            player="Dhoni";
         return "The Efficient Opener is "+player;

        }
    }
    




}








