package com.example.androidtest.data.dbo;

import java.util.ArrayList;
import java.util.List;

public class CountryUtil {

    public static List<CountryDbo> getCountries() {

        CountryDbo spainCountry = new CountryDbo();
        spainCountry.setId(3);
        spainCountry.setName("SPAIN");
        spainCountry.setCode("ES");
        CountryDbo usaCountry = new CountryDbo();
        usaCountry.setId(1);
        usaCountry.setName("USA");
        usaCountry.setCode("US");
        CountryDbo portugalCountry = new CountryDbo();
        portugalCountry.setId(2);
        portugalCountry.setName("PORTUGAL");
        portugalCountry.setCode("PT");

        List<CountryDbo> countryDboList = new ArrayList<>();
        countryDboList.add(spainCountry);
        countryDboList.add(usaCountry);
        countryDboList.add(portugalCountry);
        return countryDboList;

    }

}
