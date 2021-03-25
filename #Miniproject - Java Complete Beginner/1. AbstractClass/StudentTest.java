
package com.fresco;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ram
 */
public class StudentTest {
    Aided aided;
    SelfFinance self;
    public StudentTest() {
    }
    
    @Before
    public void setUp() {
        aided= new Aided();
        self = new SelfFinance();
    }
        

    
    public boolean testAbstract() {
        Method[] methods = Student.class.getMethods();
       boolean a=false;
       for(int i=0;i<methods.length;i++){
    a=Modifier.isAbstract(methods[i].getModifiers());
    if(a==true)
    break;
       }
       return a;
    }

    @Test
    public void testResult1() {
        if(testAbstract()){
            
            String allMarks="100 5,100 2,100 5|0,100,5|1,100,5";
            String actual=aided.result(allMarks);
            int expected=1714193;
            assertEquals(expected,actual.hashCode());
        }
        else{
            assertEquals(0,1);
        }
    }
    @Test
    public void testResult2() {
        if(testAbstract()){
            
            String allMarks="67 4,34 2,54 5,100 2|1,100,5|0,100,5";
            String actual=aided.result(allMarks);
            int expected=1624853;
            assertEquals(expected,actual.hashCode());
        }
        else{
            assertEquals(0,1);
        }
    }
    @Test
    public void testResult3() {
        if(testAbstract()){
            
            String allMarks="100 5,100 5,100 5|0,100,5|1,100,5";
            String actual=aided.result(allMarks);
            int expected=46728239;
            assertEquals(expected,actual.hashCode());
        }
        else{
            assertEquals(0,1);
        }
    }

    @Test
    public void testResult4() {
        if(testAbstract()){
            
            String allMarks="100 5,100 2,56 5|1,100,5";
            String actual=self.result(allMarks);
            int expected=1684526;
            assertEquals(expected,actual.hashCode());
        }
        else{
            assertEquals(0,1);
        }
    }
    @Test
    public void testResult5() {
        if(testAbstract()){
            
            String allMarks="100 5,100 2,46 5|1,100,5";
            String actual=self.result(allMarks);
            int expected=1684438;
            assertEquals(expected,actual.hashCode());
        }
        else{
            assertEquals(0,1);
        }
    }
    @Test
    public void testResult6() {
        if(testAbstract()){
            
            String allMarks="100 5,100 5,100 5,76 3|0,100,5";
            String actual=self.result(allMarks);
            int expected=1714291;
            assertEquals(expected,actual.hashCode());
        }
        else{
            assertEquals(0,1);
        }
    }
    @Test
    public void testResult7() {
        if(testAbstract()){
            
            String allMarks="100 5,100 5,100 5|0,100,5";
            String actual=self.result(allMarks);
            int expected=46728239;
            assertEquals(expected,actual.hashCode());
        }
        else{
            assertEquals(0,1);
        }
    }    

    
}
