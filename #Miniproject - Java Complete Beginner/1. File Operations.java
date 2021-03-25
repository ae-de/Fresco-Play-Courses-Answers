import java.io.*;
import java.util.Random;
import java.util.Scanner;
class EncryptDecryptFile
{
    public void writeDecryptionFile(String message)throws IOException
    {
        String encryptFilename=Solution.filepath+"DecryptionFile.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(encryptFilename));
        writer.write(message);
        writer.close();
    }
    public String readEncryptionFile() throws IOException
    {
        FileReader fr=new FileReader(Solution.filepath+"EncryptionFile.txt");    
        BufferedReader reader = new BufferedReader(fr);
        String ans="";
        int i;    
          while((i=reader.read())!=-1){  
          ans+=(char)i;  
          }  
          reader.close();
          return ans;
    }
}


public class Solution {
    public static String filepath = System.getenv("OUTPUT_PATH").substring(0, System.getenv("OUTPUT_PATH").lastIndexOf("\\") + 1);

    private static String generateString()
    {
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder generatedString = new StringBuilder(20);
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            char c = chars[random.nextInt(chars.length)];
            generatedString.append(c);
        }
        return generatedString.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        try{
            EncryptDecryptFile f = new EncryptDecryptFile ();

            String encryptFilename = Solution.filepath + "EncryptionFile.txt";
            String generatedString = generateString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(encryptFilename));
            writer.write(generatedString);
            writer.close();

            if(f.readEncryptionFile().equals(generatedString))
            {
                f.writeDecryptionFile(message);

                String decryptFilename = Solution.filepath + "DecryptionFile.txt";
                BufferedReader reader = new BufferedReader(new FileReader(decryptFilename));
                String messageFromFile = reader.readLine();
                reader.close();

                System.out.println(messageFromFile);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}