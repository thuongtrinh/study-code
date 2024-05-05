import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-msg-country',
  templateUrl: './msg-country.component.html',
})
export class MsgCountryComponent implements OnInit {

  @Input() countryName: string;
  @Output() updateCountry = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }

}
