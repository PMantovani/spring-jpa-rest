package com.mantovani.springjparest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Sql({"/schema.sql", "/data.sql"})
class CityRepositoryIntegrationTest {

    @Autowired
    private CityRepository cityRepo;

    @Test
    void whenFindByCountryNameWithFilter_thenReturnList() {
        List<City> found = cityRepo.findCityByCountryNameContaining("Uni");
        assertEquals(3, found.size());
    }

    @Test
    void whenFindByCountryNameWithoutFilter_thenReturnFullList() {
        List<City> found = cityRepo.findCityByCountryNameContaining("");
        assertEquals(9, found.size());
    }

}