package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
