package com.eniskeskin.akbankbootcamphomework1.controller;

import com.eniskeskin.akbankbootcamphomework1.dto.request.CountryDtoRequest;
import com.eniskeskin.akbankbootcamphomework1.dto.response.CountryDtoResponse;
import com.eniskeskin.akbankbootcamphomework1.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/countries")

public class CountryController {
    
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @PostMapping
    public ResponseEntity<CountryDtoResponse> saveCountry(@RequestBody CountryDtoRequest countryDtoRequest) {
        CountryDtoResponse countryDtoResponse = countryService.saveCountry(countryDtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryDtoResponse);
    }

    @GetMapping
    public ResponseEntity<List<CountryDtoResponse>> getAllCountries() {
        List<CountryDtoResponse> countryDtoResponseList  = countryService.getAllCountries();
        return ResponseEntity.ok(countryDtoResponseList );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDtoResponse> getCountryById(@PathVariable Long id) {
        return  ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PutMapping("/{id}/president")
    public ResponseEntity<CountryDtoResponse> updatePresident(
            @PathVariable Long id,
            @RequestParam String president
    ) {
        CountryDtoResponse countryDtoResponse = countryService.updatePresident(id, president);
        return ResponseEntity.ok(countryDtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok("Deleted!");
    }

}
