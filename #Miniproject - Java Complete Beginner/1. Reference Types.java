import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class CipherDecipher{
    /**
     * This method is used to cipher the message (normal) by following steps.
     * Swap the cases of String - UpperCase letters to LowerCase letters and viceversa.
     * Reverse the String
     * Replace the spaces of string with a star character("*")
     * Replace the characters in the even positions of the string
     * Append any integer at the last in that String
     * 
     * @param normal
     * @return the ciphered message
     */
    String key="3";
    String original;
    public String ciphering(String normal){
        //Write your code here
        String ciphered="";
        original=normal;
        for(int i=0;i<normal.length();i++)
        {
            char temp;
            if(Character.isLowerCase(normal.charAt(i)))
            {
                temp=Character.toUpperCase(normal.charAt(i));
            }
            else if(Character.isUpperCase(normal.charAt(i)))
            {
                temp=Character.toLowerCase(normal.charAt(i));
            }   
            else 
            temp=normal.charAt(i);
            ciphered+=temp;    
        }
        StringBuilder str = new StringBuilder(ciphered);
        ciphered=str.reverse().toString();
        String temp="";
        for(int i=0;i<normal.length();i++)
        {
            if(ciphered.charAt(i)==' ')
            temp+='*';
            else
            temp+=ciphered.charAt(i);
        }
        ciphered=temp;
        temp="";
        for(int i=0;i<normal.length();i++)
        {
            if(i%2==1){
            int num=ciphered.charAt(i);
            temp+=Integer.toString(num);
            }
            else
            temp+=ciphered.charAt(i);
        }
        ciphered=temp;
        ciphered+=key;
        return ciphered;
    }
    /**
     * This method is used to get the normal text by the reverse process of ciphering.
     * 
     * @param ciphered
     * @return the deciphered message
     */
    public String deciphering(String ciphered){
        //Write your code here
        String normal="";
        ciphered=ciphered.substring(0,ciphered.length()-1);
        String temp="";
        int i=0;
        while(i<ciphered.length())
        {
            if(Character.isDigit(ciphered.charAt(i)))
            {
                String xx=ciphered.charAt(i)+""+ciphered.charAt(i+1);
                int numxx=Integer.parseInt(xx);
                if(numxx<32)
                {
                    xx+=ciphered.charAt(i+2);
                    temp+=(char)Integer.parseInt(xx);
                    i+=3;
                }
                else
                {
                    temp+=(char)Integer.parseInt(xx);
                    i+=2;
                }
            }
            else{
                temp+=ciphered.charAt(i);
                i++;
            }
        }
        normal=temp;
        temp="";
        for(i=0;i<normal.length();i++)
        {
            if(normal.charAt(i)=='*')
            temp+=" ";
            else
            temp+=normal.charAt(i);
        }
        normal=temp;
        StringBuilder str = new StringBuilder(normal);
        normal=str.reverse().toString();
        temp="";
        for(i=0;i<normal.length();i++)
        {
            char temp2;
            if(Character.isLowerCase(normal.charAt(i)))
            {
                temp2=Character.toUpperCase(normal.charAt(i));
            }
            else if(Character.isUpperCase(normal.charAt(i)))
            {
                temp2=Character.toLowerCase(normal.charAt(i));
            }   
            else 
            temp2=normal.charAt(i);
            temp+=temp2;
            
        }
        normal=temp;
        return normal;
    }
}


