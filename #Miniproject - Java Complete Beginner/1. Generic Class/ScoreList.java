


import java.util.*;

public class ScoreList<N extends Number> {

    

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
    public Number getElement(int a)
    {
        return arr.get(a);
    }
    public String averageValues()
    {

        
            Number val=0.0;
            for(Number c:arr){
            val=val.doubleValue()+c.doubleValue();
            }
            val=val.doubleValue()/getSize();

            return String.format("%.2f", val);
        
      
    }
}
