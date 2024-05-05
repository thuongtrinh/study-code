import { Component, OnInit, OnDestroy } from '@angular/core';
import { LoggerCompService } from 'src/app/services/logger-comp.service';

@Component({
  selector: 'app-comp1',
  template: `
    <b>--- This is CP1Component ---</b>
  `,
})
export class Comp1Component implements OnInit, OnDestroy {

  constructor(private loggerService: LoggerCompService) { }

  ngOnInit() {
    this.loggerService.setCP1Log('c', 'Component created');
  }

  ngOnDestroy() {
    this.loggerService.setCP1Log('r', 'Component destroyed');
  }
}
