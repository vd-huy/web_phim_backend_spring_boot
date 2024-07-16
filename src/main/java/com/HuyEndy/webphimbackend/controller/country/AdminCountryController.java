package com.HuyEndy.webphimbackend.controller.country;

import com.HuyEndy.webphimbackend.model.Country;
import com.HuyEndy.webphimbackend.service.country.CountryService;
import com.HuyEndy.webphimbackend.service.slug.SlugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin/country")
public class AdminCountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private SlugService slugService;

    @GetMapping("/{id}")
    public Country getCountryById(@RequestHeader("Authorization") String jwt, @PathVariable Long id) throws Exception {

        Optional<Country> optional = countryService.getCountryById(id);

        if (optional.isEmpty() ){
            throw new Exception("Country not found with id" + id);
        }

        return optional.get();
    }

    @PostMapping
    public Country createCountry(@RequestHeader("Authorization") String jwt,@RequestBody Country req) {

        Country country = new Country();
        country.setTitle(req.getTitle());
        country.setDescription(req.getDescription());
        country.setStatus(req.getStatus());
        country.setSlug(slugService.toSlug(req.getTitle()));

        return countryService.createOrUpdateCountry(country);
    }

    @PutMapping("/{id}")
    public Country updateCountry(@RequestHeader("Authorization") String jwt,@PathVariable Long id, @RequestBody Country req) throws Exception {
        Optional<Country> optional = countryService.getCountryById(id);

        if (optional.isEmpty() ){
            throw new Exception("Country not found with id" + id);
        }

        Country country = optional.get();
        country.setTitle(req.getTitle());
        country.setDescription(req.getDescription());
        country.setStatus(req.getStatus());
        country.setSlug(slugService.toSlug(req.getTitle()));

        return countryService.createOrUpdateCountry(country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@RequestHeader("Authorization") String jwt,@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
