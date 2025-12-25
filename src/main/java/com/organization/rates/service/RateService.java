package com.organization.rates.service;

import com.organization.rates.model.Rate;
import com.organization.rates.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {

    @Autowired
    private RateRepository rateRepository;

    public Rate createRate(Rate rate) {
        return rateRepository.save(rate);
    }

    public List<Rate> getAllRates() {
        return rateRepository.findAll();
    }

    public Rate updateRate(Long id, Rate rate) {
        Rate existingRate = rateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rate not found"));
        existingRate.setType(rate.getType());
        existingRate.setValue(rate.getValue());
        existingRate.setCurrency(rate.getCurrency());
        return rateRepository.save(existingRate);
    }

    public void deleteRate(Long id) {
        rateRepository.deleteById(id);
    }
}