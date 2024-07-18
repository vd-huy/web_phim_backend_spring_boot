package com.HuyEndy.webphimbackend.controller.country;


import com.HuyEndy.webphimbackend.dto.CountryDTO;
import com.HuyEndy.webphimbackend.dto.MovieDTO;
import com.HuyEndy.webphimbackend.dto.ResponseDTO;
import com.HuyEndy.webphimbackend.model.Country;
import com.HuyEndy.webphimbackend.model.Movie;
import com.HuyEndy.webphimbackend.repository.CountryRepository;
import com.HuyEndy.webphimbackend.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService ;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public Page<Country> getAllCountries(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return countryService.getAllCountries(page, size, sortBy, direction);
    }

    @GetMapping("/all")
    public List<ResponseDTO> getAll(){
        List<Country> countries = countryRepository.getAllCountryNotHidden();

        List<ResponseDTO> responseDTOList = new ArrayList<>();

        for (Country country : countries) {
            ResponseDTO responseDTO = new ResponseDTO();

            responseDTO.setId(country.getId());
            responseDTO.setTitle(country.getTitle());

            responseDTOList.add(responseDTO);
        }

        return  responseDTOList;
    }
}
