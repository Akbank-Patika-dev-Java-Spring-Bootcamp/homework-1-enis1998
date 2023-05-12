package com.eniskeskin.akbankbootcamphomework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController

public class CountryController {

    private final CountryService countryService;
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @PostMapping
    public ResponseEntity<CountryDto> saveCountry(@RequestBody CountryDto countryDto) {
        Country country = countryService.saveCountry(countryDto);
        CountryDto savedCountryDto = CountryMapper.INSTANCE.countryToCountryDto(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountryDto);
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        List<CountryDto> countryDtos = countries.stream()
                .map(CountryMapper.INSTANCE::countryToCountryDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(countryDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable int id) {
        Country country = countryService.getCountryById(id);
        if (country == null) {
            return ResponseEntity.notFound().build();
        }
        CountryDto countryDto = CountryMapper.INSTANCE.countryToCountryDto(country);
        return ResponseEntity.ok(countryDto);
    }

    @PutMapping("/{id}/president")
    public ResponseEntity<CountryDto> updatePresident(
            @PathVariable int id,
            @RequestParam String president
    ) {
        Country country = countryService.updatePresident(id, president);
        if (country == null) {
            return ResponseEntity.notFound().build();
        }
        CountryDto countryDto = CountryMapper.INSTANCE.countryToCountryDto(country);
        return ResponseEntity.ok(countryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable int id) {
        boolean isDeleted = countryService.deleteCountry(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
