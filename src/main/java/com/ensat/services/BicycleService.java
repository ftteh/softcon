package com.ensat.services;

import com.ensat.entities.Bicycle;

public interface BicycleService {

    Iterable<Bicycle> listAllBicycle();

    Bicycle getBicycleById(Integer id);

    Bicycle saveBicycle(Bicycle bicycle);

    void deleteBicycle(Integer id);

}
