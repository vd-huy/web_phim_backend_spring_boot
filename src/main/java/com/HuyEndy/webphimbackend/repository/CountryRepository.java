package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {

    @Query("SELECT c FROM Country c WHERE c.status = true")
    List<Country> getAllCountryNotHidden();
}
