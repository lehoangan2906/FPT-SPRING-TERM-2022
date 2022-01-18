
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author win
 */
public class AccountManagement {

    private String fileName = "user.dat";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void createAccount() {
        List<Account> listAccount = FileProcess.readListAccount(fileName);
        System.out.println(listAccount);
        String username = "";
        while (true) {
            username = Validation.getString("Enter Username: ",
                    "You must enter least at 5 character, and no space!", "[a-zA-Z]{5,}");
            if (isUserNameExist(username, listAccount)) {
                System.out.println("Username has existed! Please enter another username");
            } else {
                break;
            }
        }
        String password = Validation.getString("Enter Password: ",
                "You must enter least at 6 character, and no space!", "[a-zA-Z]{6,}");
        listAccount.add(new Account(username, password));
        System.out.println(listAccount);
        FileProcess.writeListAccount(fileName, listAccount);

    }

    public void login() {
        List<Account> listAccount = FileProcess.readListAccount(fileName);
        System.out.println(listAccount);

        String username = Validation.getString("Enter Username: ",
                "You must enter least at 5 character, and no space!", "[a-zA-Z]{5,}");
        String password = Validation.getString("Enter Password: ",
                "You must enter least at 6 character, and no space!", "[a-zA-Z]{6,}");
        if (isCorrectAccount(username, password, listAccount)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Username or password incorrect!");
        }
    }

    private boolean isCorrectAccount(String username, String password, List<Account> listAccount) {
        for (Account account : listAccount) {
            if (account.getUsername().equalsIgnoreCase(username)
                    && account.getPassword().equalsIgnoreCase(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUserNameExist(String username, List<Account> listAccount) {
        for (Account account : listAccount) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

}
