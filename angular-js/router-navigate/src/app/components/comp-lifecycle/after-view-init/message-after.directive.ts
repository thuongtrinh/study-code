import { Directive, OnInit, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appMessageAfter]'
})
export class MessageAfterDirective {

  constructor(public viewContainerRef: ViewContainerRef) { }

}
