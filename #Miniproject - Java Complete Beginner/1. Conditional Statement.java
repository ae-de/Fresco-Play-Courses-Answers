import java.io.*;
import java.math.*;
import java.util.*;


class Result {

    /*
     * Complete the 'calculateGrade' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY students_marks as parameter.
     */

    public static String[] calculateGrade(int[][] students_marks) {
            String[] ans=new String[students_marks.length];
            int i=0;
            for(int[] marks: students_marks)
            {
                double avgg=Arrays.stream(marks).average().getAsDouble();
                if(avgg>=90)
                ans[i]="A+";
                else if(avgg>=80)
                ans[i]="A";
                else if(avgg>=70)
                ans[i]="B";
                else if(avgg>=60)
                ans[i]="C";
                else if(avgg>=50)
                ans[i]="D";
                else
                ans[i]="F";
                i++;
            }
            return ans;
    }

}

public class Solution {