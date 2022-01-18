/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinh
 */
import java.math.BigInteger;
public class ChangeBaseManager {

   // Đổi từ cơ số 2 hay cơ số 16 về cơ số 10
    public String convertOtherToDec(String value, String ibase) {
        BigInteger result = BigInteger.ZERO;
        String hex = "0123456789ABCDEF";
        BigInteger inBase = new BigInteger(ibase);
        for (int i = 0; i < value.length(); i++) {
            BigInteger num = BigInteger.valueOf(hex.indexOf(value.charAt(i)));
            result = result.add(num.multiply(inBase.pow(value.length() - 1 - i)));
        }
      
        return result.toString();
    }

    // Đổi từ cơ số 10 về cơ số 2 hoặc cơ số 16
    public String convertDectoOther(String decNumber, String obase) {
        String result = "";
        String hex = "0123456789ABCDEF";
        BigInteger dec = new BigInteger(decNumber);
        BigInteger outbase = new BigInteger(obase);
     
        if(decNumber.equals("0") && obase.equals("2")){
            return "0";
        }
        // Chia lấy dư cho đến khi giá trị của số cơ số 10 <=0
        while (dec.compareTo(BigInteger.ZERO) > 0) {
            int index = dec.mod(outbase).intValue();
            result = hex.charAt(index) + result;
            dec = dec.divide(outbase);
        }
        return result;
    }

}
