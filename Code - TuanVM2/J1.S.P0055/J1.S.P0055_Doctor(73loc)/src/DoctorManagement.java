
import java.util.ArrayList;
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
public class DoctorManagement {

    private List<Doctor> listDoctor = new ArrayList<>();

    public void addDoctor() {
        String code = "";
        while (true) {
            code = Validation.getString("Enter Code: ", "Code invalid", "^DOC\\s\\d+$");
            if (indexCode(listDoctor, code) != -1) {
                System.out.println("Doctor code has existed");
            } else {
                break;
            }
        }
        String name = Validation.getString("Enter Name: ", "Name invalid", "^[a-zA-Z ]+$");
        String specialization = Validation.getString("Enter Specialization: ", "Specialization invalid", "^[a-zA-Z ]+$");
        int availability = Validation.getInt("Enter Availability: ", "Availability invalid", 1, Integer.MAX_VALUE);
        listDoctor.add(new Doctor(code, name, specialization, availability));
        System.out.println("Add Doctor successful");
    }

    public void updateDoctor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteDoctor() {
        String code = Validation.getString("Enter Code: ", "Code invalid", "^DOC\\s\\d+$");
        int index = indexCode(listDoctor, code);
        if (index != -1) {
            listDoctor.remove(index);
        } else {
            System.out.println("Doctor code does not exist");
        }

    }

    public void searchDoctor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int indexCode(List<Doctor> listDoctor, String code) {
        for (int i = 0; i < listDoctor.size(); i++) {
            Doctor doctor = listDoctor.get(i);
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

}
