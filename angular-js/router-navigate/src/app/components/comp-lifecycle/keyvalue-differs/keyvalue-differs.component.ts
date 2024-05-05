import { Component, OnInit } from '@angular/core';
import { EmployeeKV } from './employeeKV';

@Component({
  selector: 'app-keyvalue-differs',
  templateUrl: './keyvalue-differs.component.html',
  styleUrls: ['../comp-lifecycle.component.scss'],
})
export class KeyvalueDiffersComponent implements OnInit {

  constructor() { }

  // For IterableDiffers: it tracks the changes in an iterable
  klass = ['color', 'bg', 'border'];

  // For KeyValueDiffers: it tracks the changes in an object
  empArray = [];
  index = 102;
  nameCount = 1;

  ngOnInit() {
    this.empArray.push(new EmployeeKV(100, 'Mahesh'));
    this.empArray.push(new EmployeeKV(101, 'Krishna'));
  }

  add() {
    this.empArray.push(new EmployeeKV(this.index++, 'ABCD'));
    console.log('Employee added: ' + JSON.stringify(this.empArray));
  }

  update() {
    this.empArray[this.empArray.length - 1].name = 'Sliver' + this.nameCount++;
    console.log('Employee updated: ' + JSON.stringify(this.empArray));
  }

  delete() {
    if (this.empArray && this.empArray.length > 2) {
      this.empArray.pop();
      console.log('Employee deleted: ' + JSON.stringify(this.empArray));
    } else {
      console.log('No further delete.');
    }
  }

  // For IterableDiffers
  change() {
    this.klass = ['color'];
  }

  changeTwo() {
    this.klass = ['color', 'border'];
  }
}
