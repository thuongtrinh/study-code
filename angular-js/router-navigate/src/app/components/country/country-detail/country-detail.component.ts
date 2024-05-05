import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Country } from 'src/app/models/country.model';
import { map, switchMap } from 'rxjs/operators';
import { CountryService } from 'src/app/services/country.service';

@Component({
  selector: 'app-country-detail',
  templateUrl: './country-detail.component.html',
  styleUrls: ['./country-detail.component.scss']
})
export class CountryDetailComponent implements OnInit {

  country: Country;

  constructor(private activatedRoute: ActivatedRoute, private countryService: CountryService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.pipe(
      map(params => params.get('country-id')),
      switchMap(id => this.countryService.getCountry(id))
    ).subscribe(country => this.country = country);
  }

}
