package Containers2.Exercici4and5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countryList = new ArrayList<>();

        countryList.add(new Country("Spain"));
        countryList.add(new Country("Germany"));
        countryList.add(new Country("Mexico"));
        countryList.add(new Country("Afganistan"));

        System.out.println(countryList);
        Collections.shuffle(countryList);

        System.out.println(countryList);
        Collections.shuffle(countryList);

        System.out.println(countryList);
        Collections.shuffle(countryList);

        System.out.println(countryList);

        /**** Exercici 5 ****/
        // No es pot afegir algo que no sigui "Country"
        // countryList.add("Manolo");
    }
}
