import { Component, OnInit, ViewChild } from '@angular/core';
import { CpcolorDirective } from './cpcolor.directive';

@Component({
  selector: 'app-cpcolor-parent',
  templateUrl: './cpcolor-parent.component.html',
})
export class CpcolorParentComponent implements OnInit {

  @ViewChild(CpcolorDirective, {static: false})
  private cpcolorDirective: CpcolorDirective;

  constructor() { }

  ngOnInit() {
  }

  changeColor(color: string) {
    this.cpcolorDirective.changeColor(color);
  }
}
