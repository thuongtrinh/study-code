import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-counter',
  template: `
    {{counter}}
  `,
})
export class CounterComponent implements OnInit, OnDestroy {

  counter = 0;
  intervalId: any;

  constructor() { }

  ngOnInit() {
    this.startCounter();
    console.log('Interval started');
  }

  ngOnDestroy() {
    clearInterval(this.intervalId);
    console.log('Interval cleared');
  }

  startCounter() {
    this.intervalId = setInterval(() => {
      this.counter += 1;
    }, 1000);
  }
}
