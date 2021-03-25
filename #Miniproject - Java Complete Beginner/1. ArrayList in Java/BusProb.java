package com.fresco;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.*;
import java.math.*;
import java.text.DecimalFormat;
class Passanger
{
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
    float fare;
    public Passanger(int id, float fare)
    {
        this.id=id;
        this.fare=fare;
    }
}
class BusProb {

    public String output(int capacity, int stops, List<String> listOfInputStrings, String query)
    {
        
        //Write your code here
        ArrayList<String>   dummy     =     new ArrayList<>();
        Map<String,Integer> hash = new HashMap<String,Integer>();
        Map<String,Double> cust_fare = new HashMap<String,Double>();
        Map<String,Integer> times=new HashMap<String,Integer>();
        int a=0,b=0,c=0;
        // Set<String> hash_Set= new HashSet<String>();
        double[][] arr=new double[stops][6];
        int k=0;
        int cnt=0;
        int totalin=0,totalout=0;
        int in=0,out=0;
        int demp=0;
        for(String f:listOfInputStrings)
        {
          StringTokenizer st = new StringTokenizer(f," ");
          in=0;
          out=0;
          while (st.hasMoreTokens()) {
            String tok=st.nextToken();
            String tok2=tok.substring(1,tok.length());
            if(tok.charAt(0)=='+')
            {
              in++;
              
              hash.put(tok2,hash.getOrDefault(tok2, 0)+1);
              times.put(tok2,times.getOrDefault(tok2, 0)+1);
            }
            else{
              out++;
              hash.put(tok2,hash.getOrDefault(tok2, 0)-1);
            }
            if(hash.get(tok2)<=0)
            hash.remove(tok2);
            
          }
          double val=0.0;
          cnt+=in;
          cnt-=out;

          if(cnt<=Math.ceil(((double)capacity/4)))
          {val=1.6*capacity;a+=in;}
          else if(cnt>Math.ceil(((double)capacity/4))&&cnt<=Math.ceil(((double)capacity/2)))
          {val=1.3*capacity;b+=in;}
          else if(cnt>Math.ceil(((double)capacity/2)))
          {val=capacity;c+=in;}


          StringTokenizer st2 = new StringTokenizer(f," ");
          while (st2.hasMoreTokens()) {
            String tok=st2.nextToken();
            String tok2=tok.substring(1,tok.length());
            if(tok.charAt(0)=='+'){
            cust_fare.put(tok2,cust_fare.getOrDefault(tok2,0.0)+val);
            // System.out.print(cust_fare.get(tok2)+ " ");
            }
            
          }
          totalin+=in;
          totalout+=out;
          k++;
        }

        System.out.println(demp+" "+a+" "+b+" "+c+"\n");

        StringTokenizer st3 = new StringTokenizer(query,",");
        while(st3.hasMoreTokens())
        {
          String q=st3.nextToken();
          System.out.println(q);
          if(q.compareTo("1")==0)
          {
            System.out.println(cust_fare.size()+" waw");
            return totalin+" passengers got on the bus and "+totalout+" passengers got out of the bus";
          }
          else if(q.compareTo("2")==0)
          {
            DecimalFormat df=new DecimalFormat("###.#");
            // return a+" passenger spent a fare of "+1.6*capacity+", "+b+" passengers spent a fare of "+1.3*capacity+" and "+c+" passengers spent a fare of "+capacity;
            // return a+" passengers traveled with a fare of "+1.6*capacity+", "+b+" passengers traveled with a fare of "+1.3*capacity+" and "+c+" passengers traveled with a fare of "+capacity;
            String xx=a+" passengers traveled with a fare of "+(Math.round(1.6*capacity * 100.0) / 100.0)+", "+b+" passengers traveled with a fare of "+(Math.round(1.3*capacity * 100.0) / 100.0)+" and "+c+" passengers traveled with a fare of "+(Math.round(capacity * 100.0) / 100.0);
            System.out.println(xx.hashCode());
            System.out.println(a+" passengers traveled with a fare of "+(Math.round(1.6*capacity * 10.0) / 10.0)+", "+b+" passengers traveled with a fare of "+(Math.round(1.3*capacity * 10.0) / 10.0)+" and "+c+" passengers traveled with a fare of "+(Math.round(capacity * 10.0) / 10.0));
            return a+" passengers traveled with a fare of "+(Math.round(1.6*capacity * 10.0) / 10.0)+", "+b+" passengers traveled with a fare of "+(Math.round(1.3*capacity * 10.0) / 10.0)+" and "+c+" passengers traveled with a fare of "+(Math.round(capacity * 10.0) / 10.0);
          }
          else if(q.compareTo("3")==0)
          {
              String tex=st3.nextToken();
              tex=tex.trim();
              System.out.println(cust_fare.get(tex)+" waw");
              return "Passenger "+tex+" spent a total fare of "+(Math.round(cust_fare.get(tex) * 10.0) / 10.0);
          }
          else if(q.compareTo("4")==0)
          {
              String tex=st3.nextToken();
              tex=tex.trim();
              System.out.println(times.get(tex)+" waw"+" ");
              return "Passenger "+tex+" has got on the bus for "+times.get(tex)+" times";
              
          }
          else
          {
              String tex=st3.nextToken();
              tex=tex.trim();
              String available;
              if(hash.containsKey(tex))
              available="inside";
              else
              available="not inside";
              return "Passenger "+tex+" was "+available+" the bus at the end of the trip";
          }

        }




        return "";
    }
    
}
