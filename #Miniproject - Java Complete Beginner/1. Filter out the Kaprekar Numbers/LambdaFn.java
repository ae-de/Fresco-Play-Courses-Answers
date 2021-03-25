
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LambdaFn {
    boolean isKaprekar(String num)
    {
      long ans=Long.parseLong(num);
      Long numu=ans;
      ans=ans*ans;
      String x=Long.toString(ans);
      int mid=x.length()/2;
      String left=x.substring(0,mid);
      String right=x.substring(mid,x.length());
      return numu==(Long.parseLong(left.length()>0?left:"0")+Long.parseLong(right.length()>0?right:"0"));

    }
    public List<Long> functionalProgtamming(List<String> listOfIntegers)
    {
        //Write your code here
        List<Long> outputList=listOfIntegers.stream().filter(x->isKaprekar(x)).map(s->Long.parseLong(s)).collect(Collectors.toList());
        System.out.println(outputList.toString());
        return outputList;

    }
    public static void main(String[] args)
    {
      LambdaFn fn=new LambdaFn();
            int a=46;
            int b=1000;
            List<String> listOfIntegers = new ArrayList<>();
            for(long i=a;i<=b;i++)
            {
                listOfIntegers.add(i+"");
            }
            System.out.println(fn.functionalProgtamming(listOfIntegers).hashCode());
    }

}