import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-comp-lifecycle',
  templateUrl: './comp-lifecycle.component.html',
  styleUrls: ['./comp-lifecycle.component.scss'],
  encapsulation: ViewEncapsulation.Native
})
export class CompLifecycleComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
