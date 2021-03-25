import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution{
    
    public static int charSearch(String str,char ch){
        //complete the code
        HashMap<Character,Integer> chrs = new HashMap<Character,Integer>();
        for(int i=0;i<str.length();i++)
        {
            chrs.put(str.charAt(i),chrs.getOrDefault(str.charAt(i),0)+1);
        }
        
        return chrs.getOrDefault(ch,0);
    }

public static void main(String[] args) throws IOException {