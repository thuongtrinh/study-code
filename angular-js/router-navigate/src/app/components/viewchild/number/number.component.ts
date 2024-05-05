import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-number',
  templateUrl: './number.component.html',
})
export class NumberComponent implements OnInit {

  message = '';
  count = 0;

  constructor() { }

  ngOnInit() {
  }

  increaseNumber() {
    this.count++;
    this.message = 'Counter: ' + this.count;
  }

  decreaseNumber() {
    this.count--;
    this.message = 'Counter: ' + this.count;
  }
}
