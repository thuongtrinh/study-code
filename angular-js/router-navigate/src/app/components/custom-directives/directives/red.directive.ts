import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appRed]'
})
export class RedDirective {

  constructor(elRef: ElementRef) {
    elRef.nativeElement.style.color = 'red';
  }
}
