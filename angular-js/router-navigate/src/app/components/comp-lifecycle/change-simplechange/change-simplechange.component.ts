import { Component, OnInit } from '@angular/core';
import { Employeez } from './employeez.model';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-change-simplechange',
  templateUrl: './change-simplechange.component.html',
})
export class ChangeSimplechangeComponent implements OnInit {

  emp = new Employeez('Marry', 20);
  msg = 'Hello World';

  constructor() { }

  ngOnInit() {
  }

  onFormSubmit(empForm: NgForm) {
    const name = empForm.controls.name.value;
    const age = empForm.controls.age.value;
    this.emp = new Employeez(name, age);
  }
}
