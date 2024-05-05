import { Component, OnInit } from '@angular/core';
import { Log } from 'src/app/models/log';
import { LoggerCompService } from 'src/app/services/logger-comp.service';

@Component({
  selector: 'app-life-comp',
  templateUrl: './life-comp.component.html',
})
export class LifeCompComponent implements OnInit {

  cp1log: Log;
  showCP1 = true;
  showCounter = true;

  constructor(private loggerService: LoggerCompService) { }

  ngOnInit() {
    this.cp1log = this.loggerService.getCP1Log();
  }

  onToggleCP1() {
    this.showCP1 = this.showCP1 === true ? false : true;
  }

  onToggleCounter() {
    this.showCounter = this.showCounter === true ? false : true;
  }
}
