package com.mantovani.springjparest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private final CountryRepository countryRepo;

    public CountryController(CountryRepository countryRepo) {
        this.countryRepo = countryRepo;
    }

    @GetMapping(path = "/rest/countries")
    public Iterable<Country> getCountries() {
        return countryRepo.findAll();
    }

    @PostMapping(path = "/rest/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryRepo.save(country);
    }
}
