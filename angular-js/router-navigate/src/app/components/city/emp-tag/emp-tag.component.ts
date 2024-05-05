import { Component, OnInit, Input } from '@angular/core';
import { Emp } from '../emp';

@Component({
  selector: 'app-emp-tag',
  templateUrl: './emp-tag.component.html',
})
export class EmpTagComponent implements OnInit {

  @Input() emp: Emp;

  constructor() { }

  ngOnInit() {
  }
}
