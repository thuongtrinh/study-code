import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-city2',
  templateUrl: './city2.component.html',
})
export class City2Component implements OnInit {

  @Input() cityId: string;
  @Input() cityName: string;

  constructor() { }

  ngOnInit() {
  }

}
