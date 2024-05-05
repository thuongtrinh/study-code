import { Directive, AfterViewInit, ElementRef } from '@angular/core';

@Directive({
  selector: '[appCpcolor]'
})
export class CpcolorDirective implements AfterViewInit {

  constructor(private elRef: ElementRef) { }

  ngAfterViewInit() {
    this.elRef.nativeElement.style.color = 'red';
  }

  changeColor(color: string) {
    this.elRef.nativeElement.style.color = color;
  }
}
