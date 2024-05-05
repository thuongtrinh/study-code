import { Component, OnInit } from '@angular/core';
import { PersonComp } from 'src/app/models/person-comp';
import { Log } from 'src/app/models/log';
import { LoggerCompService } from 'src/app/services/logger-comp.service';

@Component({
  selector: 'app-comp2',
  templateUrl: './comp2.component.html'
})
export class Comp2Component implements OnInit {

  name: string;
  persons: PersonComp[] = [];
  allLogs: Log[] = [];

  constructor(private loggerService: LoggerCompService) { }

  ngOnInit() {
    this.allLogs = this.loggerService.getAllCP2Logs();
  }

  add() {
    let personId = 0;
    const maxIndex = this.persons.length - 1;

    if (maxIndex === -1) {
      personId = 1;
    } else {
      const personWithMaxIndex = this.persons[maxIndex];
      personId = personWithMaxIndex.id + 1;
    }

    this.persons.push(new PersonComp(personId, this.name));
    this.name = '';
  }

  remove(personId: number) {
    const item = this.persons.find(ob => ob.id === personId);
    const itemIndex = this.persons.indexOf(item);

    this.persons.splice(itemIndex, 1);
  }
}
