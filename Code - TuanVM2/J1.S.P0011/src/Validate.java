
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThinkPro
 */
public class Validate {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int getBase(String msg, String err) {

        while (true) {

            try {
                System.out.println(msg);
                int base = Integer.parseInt(in.readLine());
                if (base == 2 || base == 10 || base == 16) {
                    return base;
                }

            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
            System.out.println(err);
        }

    }

    public String getValue(String msg, String err, int base) {
        while (true) {
            try {
                System.out.println(msg);
                String value = in.readLine();
                switch (base) {
                    case 2:
                        if (value.matches("[0-1]+")) {
                            return value;
                        }
                        break;
                    case 10:
                        if (value.matches("[0-9]+")) {
                            return value;
                        }
                        break;
                    case 16:
                        if (value.matches("[0-9a-fA-F]+")) {
                            return value;
                        }
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
            System.out.println(err);
        }
    }

}
