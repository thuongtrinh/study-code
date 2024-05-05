import { Component, OnInit, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-after-view-init-demo',
  template: `
    <h4>ngAfterViewInit() Demo</h4>
  `,
})
export class AfterViewInitDemoComponent implements AfterViewInit {

  constructor() { }

  ngAfterViewInit(): void {
    console.log('---ngAfterViewInit() Demo---');
  }
}
