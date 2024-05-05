import { Directive, Input, OnInit, OnDestroy } from '@angular/core';
import { LoggerCompService } from 'src/app/services/logger-comp.service';
import { Log } from 'src/app/models/log';

@Directive({
  selector: '[appComp]'
})
export class CompDirective implements OnInit, OnDestroy {

  @Input('appComp') personName: string;

  constructor(private loggerService: LoggerCompService) { }

  ngOnInit(): void {
    this.loggerService.createCP2Log(new Log('c', this.personName + ' is created.'));
  }

  ngOnDestroy(): void {
    this.loggerService.createCP2Log(new Log('r', this.personName + ' is removed.'));
  }
}
