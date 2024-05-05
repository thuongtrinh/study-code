import { Component, OnInit } from '@angular/core';
import { EmployeeKV } from '../keyvalue-differs/employeeKV';

@Component({
  selector: 'app-do-check',
  templateUrl: './do-check.component.html',
})
export class DoCheckComponent implements OnInit {

  empArray = [];
  index = 103;

  constructor() { }

  ngOnInit() {
    this.empArray.push(new EmployeeKV(100, 'Smith'));
    this.empArray.push(new EmployeeKV(101, 'Marry'));
    this.empArray.push(new EmployeeKV(102, 'Tom'));
  }

  add() {
    this.empArray.push(new EmployeeKV(this.index, 'Name'+ this.index++));
    console.log('Employee added: ' + JSON.stringify(this.empArray));
  }

  update(index) {
    this.empArray[index].name += '-U';
  }

  remove(index) {
    console.log(index);
    this.empArray.splice(index, 1);
  }
}
