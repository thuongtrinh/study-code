import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appTheme]'
})
export class ThemeDirective {

  constructor(elRef: ElementRef) {
    elRef.nativeElement.style.color = '#00cc66';
    elRef.nativeElement.style.backgroundColor = '#ccccff';
    elRef.nativeElement.style.fontSize = '20px';
  }

}
