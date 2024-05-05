import { Directive, Input, AfterViewInit, ElementRef } from '@angular/core';

@Directive({
  selector: '[appColorInput]'
})
export class ColorInputDirective implements AfterViewInit {

  @Input() inputColor: string;

  constructor(public elRef: ElementRef) { }

  ngAfterViewInit(): void {
    this.elRef.nativeElement.style.color = this.inputColor;
  }
}
