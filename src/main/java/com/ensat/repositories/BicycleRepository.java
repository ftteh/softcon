package com.ensat.repositories;

import com.ensat.entities.Bicycle;
import org.springframework.data.repository.CrudRepository;

public interface BicycleRepository extends CrudRepository<Bicycle, Integer> {

}
