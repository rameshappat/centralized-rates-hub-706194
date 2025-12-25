package com.organization.rates.controller;

import com.organization.rates.model.Rate;
import com.organization.rates.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rates")
public class RateController {

    @Autowired
    private RateService rateService;

    @PostMapping
    public ResponseEntity<Rate> createRate(@RequestBody Rate rate) {
        Rate createdRate = rateService.createRate(rate);
        return new ResponseEntity<>(createdRate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rate>> getAllRates() {
        List<Rate> rates = rateService.getAllRates();
        return new ResponseEntity<>(rates, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rate> updateRate(@PathVariable Long id, @RequestBody Rate rate) {
        Rate updatedRate = rateService.updateRate(id, rate);
        return new ResponseEntity<>(updatedRate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRate(@PathVariable Long id) {
        rateService.deleteRate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}