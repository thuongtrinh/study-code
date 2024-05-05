import { Injectable } from '@angular/core';
import { Country } from '../models/country.model';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

const COUNTRIES: Country[] = [
  { countryId: '1', name: 'India', capital: 'New Delhi', currency: 'INR' },
  { countryId: '2', name: 'China', capital: 'Beijing', currency: 'RMB' }
];

let countriesObservable = of(COUNTRIES);

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  url = '/api/countries';
  constructor(private http: HttpClient) {}

  addCountry(country: Country): Observable<Country> {
    return this.http.post<Country>(this.url, country);
  }

  getCountries(): Observable<Country[]>{
    return countriesObservable;
  }

  getCountry(id: string): Observable<Country> {
    console.log('Get country by id = ' + id);
    return countriesObservable.pipe(
      map(countries => countries.find(country => country.countryId === id))
    );
  }

  updateCountry(country: Country): Observable<Country> {
    console.log('Country updating...');
    return this.getCountries().pipe(map(countries => {
      let countryObj = countries.find(obj => obj.countryId === country.countryId);
      countryObj = country;
      return countryObj;
    }));
  }
}
