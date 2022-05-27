package com.esliceu.controller;

import com.esliceu.model.Meteorit;
import com.esliceu.service.LocalService;
import com.esliceu.service.MeteroidsService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MeteoritsController {
    LocalService localService;
    MeteroidsService meteroidsService;

    public MeteoritsController() {
        this.localService = new LocalService();
        this.meteroidsService = new MeteroidsService();
    }

    public List<Meteorit> getAsteroids() throws IOException {
        LocalDate date = LocalDate.now();
        List<Meteorit> meteorits = new ArrayList<>();
        meteorits.addAll(this.localService.findAll());
        meteorits.addAll(this.meteroidsService.getMeteorits(date));
        return meteorits;
    }
}
