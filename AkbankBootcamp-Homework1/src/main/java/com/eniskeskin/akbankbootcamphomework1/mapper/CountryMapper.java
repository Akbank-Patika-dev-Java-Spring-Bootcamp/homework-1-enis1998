package com.eniskeskin.akbankbootcamphomework1.mapper;

import com.eniskeskin.akbankbootcamphomework1.dto.request.CountryDtoRequest;
import com.eniskeskin.akbankbootcamphomework1.dto.response.CountryDtoResponse;
import com.eniskeskin.akbankbootcamphomework1.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDtoResponse countryToCountryDtoResponse(Country country);
    List<CountryDtoResponse> countryToCountryDtoResponses(List<Country> country);
    Country countryDtoRequestToCountry(CountryDtoRequest countryDtoRequest);
    Country countryDtoResponseToCountry(CountryDtoResponse countryDtoResponse);
}
