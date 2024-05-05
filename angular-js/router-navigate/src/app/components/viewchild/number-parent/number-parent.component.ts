import { Component, OnInit, ViewChild } from '@angular/core';
import { NumberComponent } from '../number/number.component';

@Component({
  selector: 'app-number-parent',
  templateUrl: './number-parent.component.html',
})
export class NumberParentComponent implements OnInit {

  @ViewChild(NumberComponent, {static: false})
  private numberComponent: NumberComponent;

  constructor() { }

  ngOnInit() {
  }

  increase() {
    this.numberComponent.increaseNumber();
  }

  decrease() {
    this.numberComponent.decreaseNumber();
  }
}
