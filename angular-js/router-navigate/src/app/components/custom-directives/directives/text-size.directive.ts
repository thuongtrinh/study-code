import { Directive, Input, AfterViewInit, ElementRef } from '@angular/core';

@Directive({
  selector: '[appTextSize]'
})
export class TextSizeDirective implements AfterViewInit {

  @Input('appTextSize') tsize: string;

  constructor(private elRef: ElementRef) { }

  ngAfterViewInit(): void {
    this.elRef.nativeElement.style.fontSize = this.tsize;
  }
}
