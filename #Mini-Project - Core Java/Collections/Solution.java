import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        HashMap<Integer, String> ppl = new HashMap<Integer, String>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0)
        {
            // System.out.println(sc.nextInt());
            int num=sc.nextInt();
            String val=sc.nextLine();
            // System.out.println(val);
            val=val.trim();
            ppl.put(num,val);
        }
        int num=sc.nextInt();
        if(ppl.containsKey(num))
            System.out.println(ppl.get(num));
        else
            System.out.println(-1);
        
        
    }
}