import { Injectable } from '@angular/core';
import { Router, Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

import { Country } from 'src/app/models/country.model';
import { CountryService } from 'src/app/services/country.service';

@Injectable()
export class CountryDetailResolver implements Resolve<Country> {

  constructor(private countryService: CountryService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Country> {
    const id = route.paramMap.get('country-id');
    console.log('Resolving for country id: ' + id);

    return this.countryService.getCountry(id).pipe(map(country => {
      if (country) {
        console.log('Exist country');
        return country;
      } else {
        console.log('Country is null');
        this.router.navigate(['/country/list']);
        return null;
      }
    }));
  }
}
