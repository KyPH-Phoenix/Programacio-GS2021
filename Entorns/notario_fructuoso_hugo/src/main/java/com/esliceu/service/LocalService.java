package com.esliceu.service;

import com.esliceu.model.Meteorit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalService {
    private final List<Meteorit> meteorits;

    public LocalService() {
        this.meteorits = new ArrayList<>();
    }

    public List<Meteorit> findAll() throws IOException {
        return this.meteorits;
    }

    public void add(Meteorit meteorit) {
        this.meteorits.add(meteorit);
    }

    public void remove(int index) {
        this.meteorits.remove(index);
    }
}
