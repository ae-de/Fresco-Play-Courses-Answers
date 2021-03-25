import java.util.Scanner;

class InvalidMessageException extends Exception
{
    
    public String toString(){
     return ("InvalidMessageException: Try again with valid message") ;
    }
}
class Encrypter
{
    static String encryptMessage(String name) throws InvalidMessageException
    {
        int cnt=0;
        for(int i=0;i<name.length();i++)
        {
            
            if(Character.isAlphabetic(name.charAt(i))||name.charAt(i)==' ')
            cnt++;
        }
        String ans="InvalidMessageException";
        if(cnt==name.length())
        {
            StringBuilder input1 = new StringBuilder();
            input1.append(name);
            input1 = input1.reverse();
            
            ans=input1.toString();
            ans=ans.toLowerCase();     
        }
        else{
            throw new InvalidMessageException();
            
        }
        return ans;
        
    }
}

class Validator {
    public static boolean validate(String message) {
        return message.matches("[A-Za-z0-9 ]+");
    }
}

public class Solution {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    
    public static void main(String[] args) {
        String message = INPUT_READER.nextLine();
        
        try {
            String encrypted_message = Encrypter.encryptMessage(message);
            if(! encrypted_message.startsWith("InvalidMessageException"))
                System.out.println(encrypted_message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}