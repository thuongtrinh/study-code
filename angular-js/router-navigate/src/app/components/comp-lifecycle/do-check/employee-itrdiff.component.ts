import { Component, OnInit, Input, IterableDiffers, DoCheck } from '@angular/core';
import { EmployeeKV } from '../keyvalue-differs/employeeKV';

@Component({
  selector: 'app-emp-itr',
  template: `
    <div *ngFor="let log of itrChangeLogs">
      {{log}}
    </div>
  `
})
export class EmployeeITRDiffComponent implements OnInit, DoCheck {

  @Input() empArray: EmployeeKV[];
  itrChangeLogs: string[] = [];
  empDiffer: any;

  constructor(private itrDiffers: IterableDiffers) { }

  ngOnInit() {
    this.empDiffer = this.itrDiffers.find([]).create(null);
  }

  ngDoCheck() {
    const empArrayChanges = this.empDiffer.diff(this.empArray);
    if (empArrayChanges) {
      empArrayChanges.forEachAddedItem(record => {
        const emp = record.item;
        console.log('Added ' + emp.name);
        this.itrChangeLogs.push('Added ' + emp.name);
      });

      empArrayChanges.forEachRemovedItem(record => {
        const emp = record.item;
        console.log('Removed ' + emp.name);
        this.itrChangeLogs.push('Removed ' + emp.name);
      });
    }
  }
}
