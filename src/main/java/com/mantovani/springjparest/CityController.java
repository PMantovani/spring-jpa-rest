package com.mantovani.springjparest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    private final CityRepository cityRepo;
    private final CountryRepository countryRepo;

    public CityController(CityRepository cityRepo, CountryRepository countryRepo) {
        this.cityRepo = cityRepo;
        this.countryRepo = countryRepo;
    }

    @RequestMapping("/rest/cities")
    public Iterable<City> getCities(@RequestParam(value="country", defaultValue="") String name) {
        if (name.equals("")) {
            return cityRepo.findAll();
        } else {
            return cityRepo.findCityByCountryNameContaining(name);
        }
    }
}
