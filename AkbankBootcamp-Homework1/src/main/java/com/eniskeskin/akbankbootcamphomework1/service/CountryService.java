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

    CountryRepository countryRepository;
    CountryMapper countryMapper = CountryMapper.INSTANCE;
    //private static Map<Long, CountryDtoRequest> countryMap = new HashMap<>();

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryDtoResponse saveCountry(CountryDtoRequest countryDtoRequest) {
        Country country = countryMapper.countryDtoRequestToCountry(countryDtoRequest);
        countryRepository.save(country);
        return countryMapper.countryToCountryDtoResponse(country);
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
        Country country = countryMapper.countryDtoResponseToCountry(getCountryById(id));
        countryRepository.delete(country);
    }


}

