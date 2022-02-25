
package p0023;
import java.io.*;
import java.lang.*;

public class Utilities {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public static int getInt(String msg, String err, int min, int max) throws IOException{
        while(true){
            try{
                System.out.print(msg);
                int num;
                num = Integer.parseInt(in.readLine());
                if (min <= num && num <= max){
                    return num;
                }else{
                    System.out.println("Input must lie in the range [" + min + " - " + max + "]");

                }
            }catch (IOException | NumberFormatException ex){
                System.out.println(err);
            }
        }
    }
    
    public static double getDouble(String msg, String err, double min, double max) throws IOException{
        while(true){
            try{
                System.out.print(msg);
                double num;
                num = Integer.parseInt(in.readLine());
                if (min <= num && num <= max){
                    return num;
                }else{
                    System.out.println("Input must lie in the range [" + min + " - " + max + "]");

                }
            }catch (IOException | NumberFormatException ex){
                System.out.println(err);
            }
        }
    }
        
        
    public static String getString(String msg, String err, String regex){
        while(true){
            try {
                System.out.print(msg);
                String str = in.readLine();
                if (str.matches(regex)){
                    return str;
                }
            }catch (IOException ex){
                System.out.println("IOException");
            }
            System.out.println(err);
        }
    }
}
