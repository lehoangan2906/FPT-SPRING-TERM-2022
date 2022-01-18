/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Comparator;
import model.Employee;

/**
 *
 * @author VINH
 */
public class Management {

    ArrayList<Employee> listEmployees = new ArrayList<>();
    public boolean addEmployee(int id, String firstName, String lastName, String phone, String email, String address, String dob, boolean sex, double salary, String agency) {
        return listEmployees.add(new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency));
    }

    public ArrayList<Employee> getListEmployees() {
        return listEmployees;
    }

    public void updateEmployee(int id, String firstName, String lastName, String phone, String email, String address, String dob, Boolean sex, double salary, String agency) {

        Employee em = getEployeeById(id);
        if (!"".equals(firstName)) {
            em.setFirstName(firstName);
        }
        if (!"".equals(lastName)) {
            em.setLastName(lastName);
        }
        if (!"".equals(address)) {
            em.setAddress(address);
        }
        if (!"".equals(agency)) {
            em.setAgency(agency);
        }
        if (!"".equals(email)) {
            em.setEmail(email);
        }
        if (!"".equals(phone)) {
            em.setPhone(phone);
        }
        if (!"".equals(dob)) {
            em.setDob(dob);
        }
        if (salary != 0) {
            em.setSalary(salary);
        }
        if (sex != null) {
            em.setSex(sex);
        }

    }

    public Employee getEployeeById(int id) {
        for (Employee em : listEmployees) {
            if (em.getId() == id) {
                return em;
            }
        }
        return null;
    }

    public boolean removeEmployee(int id) {
        for (Employee em : listEmployees) {
            if (em.getId() == id) {
                listEmployees.remove(em);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> searchEmployeeByName(String searchValue) {
        if ("".equals(searchValue)) {
            return listEmployees;
        } else {
            ArrayList<Employee> ListSearch = new ArrayList<>();
            for (Employee em : listEmployees) {
                String name = em.getFirstName() + em.getLastName();
                if (name.toUpperCase().contains(searchValue.toUpperCase())) {
                    ListSearch.add(em);
                }
            }
            return ListSearch;
        }
    }

    public ArrayList<Employee> sortEmployeeBySalary() {
        listEmployees.sort(Comparator.comparing(Employee::getSalary));
        return listEmployees;
    }
}
