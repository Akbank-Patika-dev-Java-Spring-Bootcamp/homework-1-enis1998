package com.eniskeskin.akbankbootcamphomework1.repository;

import com.eniskeskin.akbankbootcamphomework1.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}