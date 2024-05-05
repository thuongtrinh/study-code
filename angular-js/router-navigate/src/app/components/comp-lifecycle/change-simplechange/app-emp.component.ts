import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Employeez } from './employeez.model';

@Component({
  selector: 'app-emp',
  templateUrl: './app-emp.component.html',
})
export class AppEmpComponent implements OnChanges {

  @Input() employee: Employeez;
  @Input() message: string;

  allMsgChangeLogs: string[] = [];
  allEmployeeChangeLogs: string[] = [];

  constructor() { }

  ngOnChanges(changes: SimpleChanges): void {
    // tslint:disable-next-line: forin
    for (const propName in changes) {
        const change = changes[propName];
        const curVal = JSON.stringify(change.currentValue);
        const prevVal = JSON.stringify(change.previousValue);
        const changeLog = `${propName}: currentValue = ${curVal}, previousValue = ${prevVal}`;

        if (propName === 'message') {
          this.allMsgChangeLogs.push(changeLog);
        } else if (propName === 'employee') {
          this.allEmployeeChangeLogs.push(changeLog);
        }
    }
  }
}
