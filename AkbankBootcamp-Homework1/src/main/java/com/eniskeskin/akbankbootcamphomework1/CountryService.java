package com.eniskeskin.akbankbootcamphomework1;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {

    private final Map<Integer, Country>  countryMap = new HashMap<>();

    public Country saveCountry(CountryDto countryDto) {
        Country country = CountryMapper.INSTANCE.countryDtoToCountry(countryDto);
        countryMap.put(country.getId(), country);
        return country;
    }

    public List<Country> getAllCountries() {
        return new ArrayList<>(countryMap.values());
    }

    public Country getCountryById(int id) {
        return countryMap.get(id);
    }

    public Country updatePresident(int id, String president) {
        Country country = countryMap.get(id);
        if (country == null) {
            return null;
        }
        country.setPresident(president);
        return country;
    }

    public boolean deleteCountry(int id) {
        Country country = countryMap.remove(id);
        return country != null;
    }


}

