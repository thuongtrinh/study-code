package com.txt.java.structure.model.optional;

import java.util.Optional;

public class Country {
    Optional<PrimeMinister> primeMinister;

    public Country() {
    }

    public Country(Optional<PrimeMinister> primeMinister) {
        this.primeMinister = primeMinister;
    }

    public Optional<PrimeMinister> getPrimeMinister() {
        return primeMinister;
    }

    public void setPrimeMinister(Optional<PrimeMinister> primeMinister) {
        this.primeMinister = primeMinister;
    }
}
