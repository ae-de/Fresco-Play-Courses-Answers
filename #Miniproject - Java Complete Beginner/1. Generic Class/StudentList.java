
import java.util.*;
public class StudentList<N extends String> {
    public ArrayList<N> arr=new ArrayList<N>();
    //Write your code
    public  int getSize()
    {
        return arr.size();
    }
    public void addElement(N a)
    {
        arr.add(a);
    }
    public void removeElement(N a)
    {
        arr.remove(a);
    }
    public N getElement(int a)
    {
        return arr.get(a);
    }
    public String beginsWith(char a)
    {
        String ans="";
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).charAt(0)==Character.toLowerCase(a)||arr.get(i).charAt(0)==Character.toUpperCase(a))
            ans+=arr.get(i)+"\n";
        }
      return ans;

    }
    public String bloodGroupOf(String[] ss,String s)
    {
        String ans="";
        for(int i=0;i<getSize();i++)
        {
            if(ss[i].compareTo(s)==0)
            ans+=arr.get(i)+"\n";
        }
        
      return ans;

    }
    public String thresholdScore(String a)
    {
        int cnt=0;
        for(String temp:arr){
            if(temp.compareTo(a)>=0)
                cnt++;
        }
      return Integer.toString(cnt)+" students scored "+a+" above";
    }



}
