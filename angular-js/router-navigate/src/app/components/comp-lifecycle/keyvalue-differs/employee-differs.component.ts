import { Component, OnInit, Input, KeyValueDiffers, DoCheck, KeyValueDiffer } from '@angular/core';
import { EmployeeKV } from './employeeKV';

@Component({
  selector: 'app-emp-differs',
  template: `
    <h3>Change Logs</h3>
    <div *ngFor='let log of changeLogs'>{{ log }}</div>
  `,
})
export class EmployeeDiffersComponent implements OnInit, DoCheck {

  @Input() empArray: EmployeeKV[];

  arrayDiffers: KeyValueDiffer<any, any>| null;
  empDifferMap = new Map<number, any>();
  empMap = new Map<number, EmployeeKV>();
  changeLogs: string[] = [];

  constructor(private kvDiffers: KeyValueDiffers) { }

  ngOnInit() {
    this.arrayDiffers = this.kvDiffers.find(this.empArray).create();

    this.empArray.forEach(emp => {
      this.empDifferMap[emp.id] = this.kvDiffers.find(emp).create();
      this.empMap[emp.id] = emp;
    });
  }

  ngDoCheck() {
    // Detect changes in array when item added or removed
    const empArrayChanges = this.arrayDiffers.diff(this.empArray);

    if (empArrayChanges) {
      console.log('... Array changes ...');
      this.changeLogs.push('... Array changes ...');

      empArrayChanges.forEachAddedItem(record => {
        const emp = record.currentValue;
        this.empDifferMap.set(emp.id, this.kvDiffers.find(emp).create());
        this.empMap.set(emp.id, emp);
        console.log('Added ' + emp.name);
        this.changeLogs.push('Added ' + emp.name);
      });

      empArrayChanges.forEachRemovedItem(record => {
        const emp = record.previousValue;
        this.empDifferMap.delete(emp.id);
        this.empMap.delete(emp.id);
        console.log('Removed ' + emp.name);
        this.changeLogs.push('Removed ' + emp.name);
      });
    }

    // Detect changes in object inside array
    this.empDifferMap.forEach((empDiffer, key) => {
      const empChanges = empDiffer.diff(this.empMap.get(key));

      if (empChanges) {
        empChanges.forEachChangedItem(record => {
          console.log('--- Employee with id ' + key + ' updated ---');
          this.changeLogs.push('--- Employee with id ' + key + ' updated ---');

          console.log('Previous value: ' + record.previousValue);
          this.changeLogs.push('Previous value: ' + record.previousValue);
          console.log('Current value: ' + record.currentValue);
          this.changeLogs.push('Current value: ' + record.currentValue);
        });
      }
    });
  }
}
