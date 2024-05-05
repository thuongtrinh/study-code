import { Component, OnInit, ViewChildren, ElementRef, AfterViewInit, QueryList } from '@angular/core';

@Component({
  selector: 'app-vc-demo3',
  templateUrl: './vc-demo3.component.html',
})
export class VcDemo3Component implements OnInit, AfterViewInit {

  @ViewChildren('pname')
  private persons: QueryList<ElementRef>;

  // We have some <div> and we have assigned template reference variable to it
  // and we are querying ElementRef.

  constructor() { }

  ngOnInit() {
  }

  ngAfterViewInit() {
    console.log('-=-=-=-@ViewChildren with ElementRef-=-=-=-');
    this.persons.forEach(eleRef => console.log(eleRef));
  }
}
