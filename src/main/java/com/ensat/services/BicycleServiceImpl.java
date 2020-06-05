package com.ensat.services;

import com.ensat.entities.Bicycle;
import com.ensat.repositories.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BicycleServiceImpl implements BicycleService {

    private BicycleRepository bicycleRepository;

    @Autowired
    public void setBicycleRepository(BicycleRepository bicycleRepository) {
        this.bicycleRepository = bicycleRepository;
    }

    @Override
    public Iterable<Bicycle> listAllBicycle() {
        return bicycleRepository.findAll();
    }

    @Override
    public Bicycle getBicycleById(Integer id) {
        return bicycleRepository.findOne(id);
    }

    @Override
    public Bicycle saveBicycle(Bicycle bicycle) {
        return bicycleRepository.save(bicycle);
    }

    @Override
    public void deleteBicycle(Integer id) {
        bicycleRepository.delete(id);
    }

}
