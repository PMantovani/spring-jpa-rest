package com.mantovani.springjparest;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CountryRepository extends CrudRepository<Country, Long> {}
