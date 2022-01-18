/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbank;

import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author win
 */
public class Management {

    public void loginWithVietNamese(ResourceBundle bundle) {
        bundle = ResourceBundle.getBundle("tpbank.language_vi_VN");
        login(bundle);

    }

    public void loginWithEnglish(ResourceBundle bundle) {
        bundle = ResourceBundle.getBundle("tpbank.language_en_US");
        login(bundle);
    }

    private String randomCaptcha() {
        Random rand = new Random();
        StringBuilder anphabet = new StringBuilder();
        boolean isLowerExisted = false;
        boolean isUpperExisted = false;
        boolean isDigitExisted = false;
        for (char i = 'a'; i <= 'z'; i++) {
            anphabet.append(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            anphabet.append(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            anphabet.append(i);
        }
        StringBuilder captCha;
        do {
            captCha = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                int index = rand.nextInt(anphabet.length());
                char randomChar = anphabet.charAt(index);
                if (randomChar >= 'a' && randomChar <= 'z') {
                    isLowerExisted = true;
                } else if (randomChar >= 'A' && randomChar <= 'Z') {
                    isUpperExisted = true;
                } else {
                    isDigitExisted = true;
                }
                captCha.append(randomChar);
            }
        } while (!isLowerExisted || !isUpperExisted || !isDigitExisted);
        return captCha.toString();
    }

    private void login(ResourceBundle bundle) {
        // get a string and set to accountNumber variable
        String accountNumber = Validation.getString(bundle.getString("account"),
                bundle.getString("account.error"), "^\\d{10}$");
        // get a string and set to password variable
        String password = Validation.getPassword(bundle.getString("password"),
                bundle.getString("password.error"));

        //random captcha 5 character include alphanumeric
        while (true) {
            String captcha = randomCaptcha();
            System.out.println("Captcha: " + captcha);
            String reCaptcha = Validation.getString(bundle.getString("captcha"),
                    bundle.getString("captcha.error"), "^[a-zA-Z0-9]{5}$");
            if (captcha.equals(reCaptcha)) {
                System.out.println(bundle.getString("login.success"));
                break;
            } else {
                System.out.println(bundle.getString("captcha.incorrect"));
            }
        }
    }

}
