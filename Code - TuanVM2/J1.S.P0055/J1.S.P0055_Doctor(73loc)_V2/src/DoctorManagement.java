
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    
    public static final String DOCTOR_FILE = "doctors.txt";
    
    public void addDoctor() {
        Map<String, Doctor> doctorMap = FileProcess.readDoctors(DOCTOR_FILE);
        String code = "";
        while (true) {
            code = Validation.getString("Enter Code: ", "Code invalid", "^DOC\\s\\d+$");
            if (doctorMap.containsKey(code)) {
                System.out.println("Doctor code has existed");
            } else {
                break;
            }
        }
        String name = Validation.getString("Enter Name: ", "Name invalid", "^[a-zA-Z ]+$");
        String specialization = Validation.getString("Enter Specialization: ", "Specialization invalid", "^[a-zA-Z ]+$");
        int availability = Validation.getInt("Enter Availability: ", "Availability invalid", 1, Integer.MAX_VALUE);
        doctorMap.put(code, new Doctor(code, name, specialization, availability));
        FileProcess.writeDoctors(DOCTOR_FILE, doctorMap);
        System.out.println("Add Doctor successful");
    }
    
    public void updateDoctor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void deleteDoctor() {
        Map<String, Doctor> doctorMap = FileProcess.readDoctors(DOCTOR_FILE);
        String code = Validation.getString("Enter Code: ", "Code invalid", "^DOC\\s\\d+$");
        if (doctorMap.containsKey(code)) {
            doctorMap.remove(code);
        } else {
            System.out.println("Doctor code does not exist");
        }
        
    }
    
    public void searchDoctor() {
        Map<String, Doctor> doctorMap = FileProcess.readDoctors(DOCTOR_FILE);
        String keyword = Validation.getString("Enter keyword: ", "Keyword invalid", "^\\w+$");
        boolean isExisted = false;
        for (Map.Entry<String, Doctor> entry : doctorMap.entrySet()) {
            String code = entry.getKey();
            Doctor doctor = entry.getValue();
            
            if (doctor.getCode().contains(keyword)
                    || doctor.getName().contains(keyword)
                    || (doctor.getAvailability() + "").contains(keyword)
                    || doctor.getSpecialization().contains(keyword)) {
                System.out.println(doctor);
                isExisted = true;
            }
        }
        if (!isExisted) {
            System.out.println("Not found");
        }
    }
    
}
