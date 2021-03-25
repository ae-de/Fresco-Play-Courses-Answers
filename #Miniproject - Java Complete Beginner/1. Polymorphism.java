import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Parent
{
    
    String filter(int startElement,int endElement)
    {
        
        return null;
    }
}
class ChildOne extends Parent
{
    String filter(int startElement,int endElement)
    {
        String ans="";
        
        for(int i=startElement;i<=endElement;i++)
        {
            boolean flag=false;
            for(int j=2;j<i;j++)
            {
                if(i%j==0){flag=true;break;}
            }
            if(!flag&&i>=2)
            ans+=Integer.toString(i)+" ";
        }
        return ans;
    }
}
class ChildTwo extends Parent
{
    public boolean isHappy(int n) {
        int res;
        HashSet<Integer> h = new HashSet<Integer>();
        while (!h.contains(n))
        {
            h.add(n);
            res = 0;
            while (n > 0) {
                res += Math.pow(n%10, 2);
                n/=10;
            }
            if (res == 1)
                return true;
            n = res;
        }
        return false;
    }
    String filter(int startElement,int endElement)
    {
        String ans="";
        for(int i=startElement;i<=endElement;i++)
        {
            if(isHappy(i))
            ans+=Integer.toString(i)+" ";
            
        }
        return ans;   
    }
}
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc=new Scanner(System.in);
        int start=sc.nextInt();
        int end=sc.nextInt();
        Parent p;
        p=new ChildOne();
        System.out.println(p.filter(start,end));
        p=new ChildTwo();
        System.out.println(p.filter(start,end));
        
    }
}