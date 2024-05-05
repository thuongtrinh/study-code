package com.txt.java.structure.util.stream;

import java.util.Optional;

import com.txt.java.structure.model.optional.Country;
import com.txt.java.structure.model.optional.Person;
import com.txt.java.structure.model.optional.PrimeMinister;

public class OptionalDemo {

    public static void main(String[] args) {
        Optional<PrimeMinister> pm = Optional.of(new PrimeMinister());
        String pmName = pm.map(PrimeMinister::getName).orElse("None");
        System.out.println(pmName);

        // Assign Some Value to PrimeMinister.name
        pm = Optional.of(new PrimeMinister("ABC PrimeMinister", 55));
        pmName = pm.map(PrimeMinister::getName).orElse("None");
        System.out.println(pmName);

        // flatMap
        System.out.println("\n2. flatMap:");
        Optional<PrimeMinister> primeMinister = Optional.of(new PrimeMinister("Prime2", 77));
        Optional<Country> country = Optional.of(new Country(primeMinister));
        Optional<Person> person = Optional.of(new Person(country));
        String pmName2 = person.flatMap(Person::getCountry).flatMap(Country::getPrimeMinister)
                .map(PrimeMinister::getName).orElse("None");
        System.out.println(pmName2);
    }
}
