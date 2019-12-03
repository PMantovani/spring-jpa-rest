package com.mantovani.springjparest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Sql({"/schema.sql", "/data.sql"})
class CityControllerIntegrationTest {

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private CountryRepository countryRepo;

    @Test
    void whenPostCityIncrementsList() {
        CityController controller = new CityController(cityRepo);
        controller.addCity(new City("Curitiba", countryRepo.findById(1L).get()));

        Iterator citiesAfterInsert = controller.getCities("").iterator();
        int finalCounter = 0;
        while (citiesAfterInsert.hasNext()) {
            finalCounter++;
            citiesAfterInsert.next();
        }

        assertEquals(10, finalCounter);
    }
}