package com.mantovani.springjparest;

import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    private final CityRepository cityRepo;

    public CityController(CityRepository cityRepo) {
        this.cityRepo = cityRepo;
    }

    @GetMapping("/rest/cities")
    public Iterable<City> getCities(@RequestParam(value="country", defaultValue="") String name) {
        if (name.equals("")) {
            return cityRepo.findAll();
        } else {
            return cityRepo.findCityByCountryNameContaining(name);
        }
    }

    @PostMapping(path = "/rest/cities", consumes = "application/json", produces = "application/json")
    public void addCity(@RequestBody City city) {
        cityRepo.save(city);
    }

}
