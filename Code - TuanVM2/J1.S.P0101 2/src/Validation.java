
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author win
 */
public class Validation {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static Integer getInt(String msg, String err, int min, int max, String ignore) {
        while (true) {
            try {
                System.out.println(msg);
                int num;
                String str = in.readLine();
                if (ignore != null && str != null && str.trim().equals(ignore)) {
                    return null;
                }
                num = Integer.parseInt(str);
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Number inrange[" + min + "-" + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static Double getDouble(String msg, String err, double min, double max, String ignore) {
        while (true) {
            try {
                System.out.println(msg);
                double num;
                String str = in.readLine();
                if (ignore != null && str != null && str.trim().equals(ignore)) {
                    return null;
                }
                num = Double.parseDouble(str);
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.out.println("Number inrange[" + min + "-" + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }

    public static String getString(String msg, String err, String regex, String ignore) {
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (ignore != null && str != null && str.trim().equals(ignore)) {
                    return null;
                }
                if (str.matches(regex)) {
                    return str;
                }
            } catch (IOException e) {
                System.out.println("Meet IOException");
            }
            System.out.println(err);
        }
    }

    public static Date getDate(String msg, String err, String format, String ignore) {
        while (true) {
            try {
                System.out.println(msg);
                String str = in.readLine();
                if (ignore != null && str != null && str.trim().equals(ignore)) {
                    return null;
                }
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                Date date = sdf.parse(str);
                return date;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    public static Date toDate(String str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            Date date = sdf.parse(str);
            return date;
        } catch (Exception e) {
            System.out.println("Date format invalid");
        }
        return null;
    }

    public static String toString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
