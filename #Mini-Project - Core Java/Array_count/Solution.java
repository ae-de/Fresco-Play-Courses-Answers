import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int[] arr=new int[10];
        for(int i=0;i<10;i++)
        arr[i]=0;
        Scanner sc=new Scanner(System.in);
        String text=sc.next();
        for(int i=0;i<text.length();i++)
        {
            arr[Integer.parseInt(text.substring(i,i+1))]++;
        }
        for(int i=0;i<10;i++)
        {
            if(arr[i]!=0)
            System.out.println(i+": "+arr[i]);
        }
    }
}