
package com.fresco;
import java.text.DecimalFormat;


public abstract class Student {

	//Write your code. Use this class as abstract class.
	public abstract String result(String MarksOfStudent);
	public double GradePoint(int mark)
	{
		double grade=0;
		if(mark<40)
		{
			grade=0;
		}
		else if(mark>=40 && mark<=49)
		{
			if(mark==40)
				grade=6.0;
			else if(mark==49)
				grade=6.9;
			else
				grade=6.0+(0.1*(mark-40));
		}
		else if(mark>=50 && mark<=59)
		{
			if(mark==50)
				grade=7.0;
			else if(mark==59)
				grade=7.9;
			else
				grade=7.0+(0.1*(mark-50));
		}
		else if(mark>=60 && mark<=74)
		{
			if(mark==60)
				grade=8.0;
			else if(mark==74)
				grade=8.9;
			else
				grade=8.0+((0.1/(1.5))*(mark-60));
		}
		else if(mark>=75 && mark<=100)
		{
			if(mark==75)
				grade=9.0;
			else if(mark==100)
				grade=10.0;
			else
				grade=9.0+((0.1/(2.36))*(mark-75));
		}
		//return grade;
		DecimalFormat df=new DecimalFormat("#.#");
		double ans=Double.parseDouble(df.format(grade));
		return ans;
	}

}