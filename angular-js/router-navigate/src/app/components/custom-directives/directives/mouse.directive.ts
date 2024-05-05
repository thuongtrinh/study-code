import { Directive, ElementRef, HostListener, AfterViewInit } from '@angular/core';

@Directive({
  selector: '[appMouse]'
})
export class MouseDirective implements AfterViewInit {

  constructor(private elRef: ElementRef) { }

  ngAfterViewInit(): void {
    this.elRef.nativeElement.style.fontSize = '30px';
  }

  @HostListener('mouseover') onMouseOver() {
    this.changeBackgroundColor('darkgrey');
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.changeBackgroundColor('red');
  }

  private changeBackgroundColor(color: string) {
    this.elRef.nativeElement.style.color = color;
  }
}
