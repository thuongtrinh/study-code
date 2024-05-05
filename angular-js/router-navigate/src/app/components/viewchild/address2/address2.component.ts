import { Component, OnInit, ContentChild } from '@angular/core';
import { City2Component } from '../city2/city2.component';

@Component({
  selector: 'app-address2',
  templateUrl: './address2.component.html',
})
export class Address2Component implements OnInit {

  @ContentChild(City2Component, {static: false}) city: City2Component;

  title = 'Address';

  constructor() { }

  ngOnInit() {
  }

}
