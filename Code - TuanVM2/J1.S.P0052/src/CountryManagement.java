
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class CountryManagement {

    private List<EastAsiaCountries> listCountry;

    public CountryManagement() {
        listCountry = new ArrayList<>();
        mockCountry();
    }

    private void mockCountry() {
        listCountry.add(new EastAsiaCountries("VN", "Viet Nam", 100000, "Nice"));
        listCountry.add(new EastAsiaCountries("THAI", "Thai Lan", 100000, "Nice"));
        listCountry.add(new EastAsiaCountries("IND", "Indonesia", 100000, "Nice"));
        listCountry.add(new EastAsiaCountries("MAS", "Malaysia", 100000, "Nice"));
    }

    void addCountry() {
        int count = 4;
        while (count < 5) {
            String code = "";
            while (true) {
                code = Validation.getString("Enter code of country:", "Code invalid", "^[A-Z]+$");
                if (isExist(code)) {
                    System.out.println("Duplicate code, Please enter another Code");
                } else {
                    break;
                }
            }

            String name = Validation.getString("Enter name of country:", "Name invalid", "^[a-zA-Z ]+$");
            float totalArea = Validation.getFloat("Enter total Area: ", "Total area invalid", 0f, Float.MAX_VALUE);
            String terrain = Validation.getString("Enter terrain of country:", "Terrain invalid", "^[a-zA-Z ]+$");
            EastAsiaCountries country = new EastAsiaCountries(code, name, totalArea, terrain);
            listCountry.add(country);
            count++;
        }

    }

    void displayCountry() {
        System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries country : listCountry) {
            country.display();
        }
    }

    void searchCountry() {
        String keyword = Validation.getString("Enter the name you want to search for: ", "Name invalid", "^[a-zA-Z ]+$");
        System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries country : listCountry) {
            if (country.getCountryName().contains(keyword)) {
                country.display();
            }
        }
    }

    void sortCountry() {
        Collections.sort(listCountry, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });
        displayCountry();
    }

    private boolean isExist(String code) {
        for (EastAsiaCountries country : listCountry) {
            if (country.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

}
