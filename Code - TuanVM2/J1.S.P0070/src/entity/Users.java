/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 *@author VINH
 */
public class Users {
    String accNumber;
    String pw;

    public Users() {
    }

    public Users(String accNumber, String pw) {
        this.accNumber = accNumber;
        this.pw = pw;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
    
}
