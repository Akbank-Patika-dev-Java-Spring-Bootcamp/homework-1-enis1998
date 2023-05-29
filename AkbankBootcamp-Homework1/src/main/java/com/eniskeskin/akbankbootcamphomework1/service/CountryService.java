package com.eniskeskin.akbankbootcamphomework1.service;

import com.eniskeskin.akbankbootcamphomework1.dto.request.CountryDtoRequest;
import com.eniskeskin.akbankbootcamphomework1.dto.response.CountryDtoResponse;
import com.eniskeskin.akbankbootcamphomework1.entity.Country;
import com.eniskeskin.akbankbootcamphomework1.mapper.CountryMapper;
import com.eniskeskin.akbankbootcamphomework1.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryService(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    public Country saveCountry(CountryDtoRequest countryDtoRequest) {
        Country country = countryMapper.countryDtoRequestToCountry(countryDtoRequest);
        return countryRepository.save(country);
    }

    public List<CountryDtoResponse> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countryMapper.countryToCountryDtoResponses(countries);
    }

    public CountryDtoResponse getCountryById(Long id) {
        Country country = countryRepository.findById(id).orElseThrow();
        return countryMapper.countryToCountryDtoResponse(country);
    }

    public CountryDtoResponse updatePresident(Long id, String president) {
        Country country = countryRepository.findById(id).orElseThrow();
        country.setPresident((president));
        countryRepository.save(country);
        return countryMapper.countryToCountryDtoResponse(country);
    }

    public void deleteCountry(Long id) {
        System.out.println(getCountryById(id).getName());
        Country country = countryMapper.countryDtoResponseToCountry(getCountryById(id));
        System.out.println(country.getName());
        countryRepository.delete(country);
    }


}

