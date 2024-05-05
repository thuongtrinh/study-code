import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-uppercase',
  templateUrl: './uppercase.component.html',
})
export class UppercaseComponent implements OnInit {

  firstName: string;

  constructor() { }

  ngOnInit() {
  }

  toUpper(val: string) {
    this.firstName = val.toUpperCase();
  }
}
