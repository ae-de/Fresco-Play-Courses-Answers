
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
public class StudentClass {



    public String getQuery(String studentData,String query){

        StringTokenizer st = new StringTokenizer(query,",");
        int qtype=Integer.parseInt(st.nextToken());
        String ans="";
        if(qtype==1)
        {
          char a=st.nextToken().charAt(0);
          StringTokenizer st2 = new StringTokenizer(studentData," ");
          StudentList<String> stx=new StudentList<String>();
          while(st2.hasMoreElements())
          {
            stx.addElement(st2.nextToken());
          }
          
          return stx.beginsWith(a);

        }
        else if(qtype==2)
        {
          String temp2=st.nextToken();
          String target=st.nextToken();
           StringTokenizer sttemp2 = new StringTokenizer(temp2," ");
          StringTokenizer st2 = new StringTokenizer(studentData," ");
          StudentList<String> stx=new StudentList<String>();
          while(st2.hasMoreElements())
          {
            stx.addElement(st2.nextToken());
          }
          String[] stemp=new String[stx.getSize()];
          int i=0;
          while(sttemp2.hasMoreElements())
          {
            stemp[i++]=sttemp2.nextToken();
          }
          

          return stx.bloodGroupOf(stemp,target);
        }
        else if(qtype==3)
        {
          String a=st.nextToken();
          StringTokenizer st2 = new StringTokenizer(studentData," ");
          StudentList<String> stx=new StudentList<String>();
          while(st2.hasMoreElements())
          {
            stx.addElement(st2.nextToken());
            
          }
          return stx.thresholdScore(a);

        }
        else if(qtype==4)
        {
          StringTokenizer st2 = new StringTokenizer(studentData," ");
          ScoreList<Integer> stx=new ScoreList<Integer>();
          while(st2.hasMoreElements())
          {
            stx.addElement(Integer.parseInt(st2.nextToken()));
          }
          return stx.averageValues();
        }
        else
        {
            StringTokenizer st2 = new StringTokenizer(studentData," ");
            ScoreList<Double> stx=new ScoreList<Double>();
          while(st2.hasMoreElements())
          {
            stx.addElement(Double.parseDouble(st2.nextToken()));
          }
          return  stx.averageValues();
        }

    }
    public boolean testGeneric3(){
        Field[] fields1 = StudentList.class.getDeclaredFields(); 
        Field[] fields2 = ScoreList.class.getDeclaredFields(); 
        int flag=0;
        for(Field field : fields1){
            if(field.getType().toString().equals("class java.util.ArrayList")){
                flag++;
            }
        }
        for(Field field : fields2){
            if(field.getType().toString().equals("class java.util.ArrayList")){
                flag++;
            }
        }
        if(flag>=2)
            return true;
        else
            return false;
    }
    
    
    public boolean testGeneric4(){
        TypeVariable<Class<StudentList>>[] parameter1=StudentList.class.getTypeParameters();
        TypeVariable<Class<ScoreList>>[] parameter2=ScoreList.class.getTypeParameters();
        if(parameter1.length==1 && parameter2.length==1)
            return true;
        else
            return false;
    }
    public static void main(String[] args)
    {
        StudentClass st=new StudentClass();
        System.out.println(st.testGeneric3()&&st.testGeneric4());
        String expected = "69.00";
        String actual = st.getQuery("90 78 69 45 90 42 69", "4");
        System.out.println(actual);
        System.out.println(actual.compareTo(expected));

    }

}
