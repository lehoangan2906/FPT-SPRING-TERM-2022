import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ThinkPro
 */
public class Convert {

    public BigInteger OtherToDec(String Other, int base) {
        BigInteger result = new BigInteger("0");
        String HEX = "0123456789ABCDEF";
        Other = Other.toUpperCase();
        for (int i = 0; i < Other.length(); i++) {
            int value = (int) (HEX.indexOf(Other.charAt(i)) * Math.pow(base, Other.length() - 1 - i));
            result = result.add(new BigInteger(value + ""));
        }
        return result;
    }

    public BigInteger OtherToDecOptimize(String Other, int base) {
        BigInteger result = new BigInteger("0");
        String HEX = "0123456789ABCDEF";
        Other = Other.toUpperCase();
        BigInteger s = new BigInteger("1");
        for (int i = Other.length() - 1; i >= 0; i--) {
            int value = HEX.indexOf(Other.charAt(i));
            result = result.add(new BigInteger(value + "").multiply(s));
            s = s.multiply(new BigInteger(base + ""));

        }
        return result;
    }

    public String DecToOther(BigInteger Dec, int base) {
        String result = "";
        String HEX = "0123456789ABCDEF";
        while (Dec.compareTo(new BigInteger("0")) > 0) {
            int index = Dec.mod(new BigInteger(base + "")).intValue();
            result = HEX.charAt(index) + result;
            Dec = Dec.divide(new BigInteger(base + ""));
        }
        return result;
    }
}
