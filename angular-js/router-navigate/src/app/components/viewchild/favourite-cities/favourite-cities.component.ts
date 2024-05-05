import { Component, OnInit, QueryList, ContentChildren } from '@angular/core';
import { City2Component } from '../city2/city2.component';

@Component({
  selector: 'app-favourite-cities',
  templateUrl: './favourite-cities.component.html',
})
export class FavouriteCitiesComponent implements OnInit {

  @ContentChildren(City2Component) topCities: QueryList<City2Component>;
  @ContentChildren(City2Component, {descendants: true}) allCities: QueryList<City2Component>;

  constructor() { }

  ngOnInit() {
  }

}
